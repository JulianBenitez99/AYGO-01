package co.edu.escuelaing.app.controller;

import co.edu.escuelaing.app.entities.Log;
import co.edu.escuelaing.app.services.ILogService;
import spark.Request;
import spark.Response;

import static spark.Spark.halt;

public class LogController {

    private final ILogService logService;

    private static final String TYPE_JSON = "application/json";

    public LogController(ILogService logService) {
        this.logService = logService;
    }

    public Log[] send(Request req, Response res) {
        String msg = req.queryParams("msg");
        if (msg == null) {
            halt(400, "msg parameter is required");
        }
        res.type(TYPE_JSON);
        return logService.saveAndList(msg);
    }


}
