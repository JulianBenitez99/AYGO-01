package co.edu.escuelaing.logservice.util;

import com.google.gson.Gson;
import spark.ResponseTransformer;

public class JsonUtil {

    private static Gson gson = new Gson();

    private JsonUtil() {
    }

    public static String toJson(Object object) {
        return gson.toJson(object);
    }
    public static ResponseTransformer json() {
        return JsonUtil::toJson;
    }
}
