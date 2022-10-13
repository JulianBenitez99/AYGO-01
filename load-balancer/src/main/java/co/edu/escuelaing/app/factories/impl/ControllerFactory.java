package co.edu.escuelaing.app.factories.impl;

import co.edu.escuelaing.app.controller.LogController;
import co.edu.escuelaing.app.factories.Factory;

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
