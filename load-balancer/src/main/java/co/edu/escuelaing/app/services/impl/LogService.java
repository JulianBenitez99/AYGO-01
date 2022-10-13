package co.edu.escuelaing.app.services.impl;

import co.edu.escuelaing.app.entities.Log;
import co.edu.escuelaing.app.loadbalancer.LoadBalancer;
import co.edu.escuelaing.app.services.ILogService;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class LogService implements ILogService {

    private static final Logger logger = LoggerFactory.getLogger(LogService.class);

    private final LoadBalancer loadBalancer;

    private final Gson gson;

    private final OkHttpClient client;

    public LogService(LoadBalancer loadBalancer) {
        this.gson = new Gson();
        this.loadBalancer = loadBalancer;
        this.client = new OkHttpClient();
    }

    @Override
    public Log[] saveAndList(String msg) {
        okhttp3.Request request = new Request.Builder()
                .post(RequestBody.create("", null))
                .url(String.format("%s/save?msg=%s", loadBalancer.getServer(), msg))
                .build();
        try {
            okhttp3.Response response = client.newCall(request).execute();
            return gson.fromJson(response.body().string(), Log[].class);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new RuntimeException("Failed to save log", e);
        }
    }
}
