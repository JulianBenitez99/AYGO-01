package co.edu.escuelaing.logservice.factories.impl;

import co.edu.escuelaing.logservice.controller.LogController;
import co.edu.escuelaing.logservice.factories.Factory;

public class ControllerFactory implements Factory<LogController> {

    public static ControllerFactory instance = new ControllerFactory();

    private LogController logController;

    private ControllerFactory() {
    }

    @Override
    public LogController getInstance() {
        if (logController == null) {
            logController = new LogController(ServiceFactory.instance.getInstance());
        }
        return logController;
    }

}
