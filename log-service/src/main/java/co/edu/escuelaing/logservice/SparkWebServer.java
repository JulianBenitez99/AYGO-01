package co.edu.escuelaing.logservice;

import co.edu.escuelaing.logservice.controller.LogController;
import co.edu.escuelaing.logservice.factories.impl.ControllerFactory;

import static co.edu.escuelaing.logservice.config.Config.getPort;
import static co.edu.escuelaing.logservice.util.JsonUtil.json;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

public class SparkWebServer {
    public static void main(String... args) {
        LogController controller = ControllerFactory.instance.getInstance();
        port(getPort());
        get("hello", (req, res) -> "Hello!");
        post("save", controller::save, json());
    }

}