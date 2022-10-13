package co.edu.escuelaing.logservice.controller;

import co.edu.escuelaing.logservice.entities.Log;
import co.edu.escuelaing.logservice.services.ILogService;
import spark.Request;
import spark.Response;

import java.util.List;

import static spark.Spark.halt;

public class LogController {

    private final ILogService logService;

    private static final String TYPE_JSON = "application/json";

    public LogController(ILogService logService) {
        this.logService = logService;
    }

    public List<Log> save(Request request, Response response) {
        String msg = request.queryParams("msg");
        if (msg == null) {
            halt(400, "msg parameter is required");
        }
        response.type(TYPE_JSON);
        return logService.saveAndList(msg);
    }

}
