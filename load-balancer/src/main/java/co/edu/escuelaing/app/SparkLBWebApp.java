package co.edu.escuelaing.app;

import co.edu.escuelaing.app.controller.LogController;
import co.edu.escuelaing.app.factories.impl.ControllerFactory;

import static co.edu.escuelaing.app.config.Config.getPort;
import static co.edu.escuelaing.app.util.JsonUtil.json;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.staticFiles;

public class SparkLBWebApp {
    public static void main(String[] args) {
        LogController controller = ControllerFactory.instance.getInstance();
        staticFiles.location("/public");
        port(getPort());
        post("/send", controller::send, json());
    }
}