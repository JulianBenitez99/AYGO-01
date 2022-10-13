package co.edu.escuelaing.app.factories.impl;

import co.edu.escuelaing.app.factories.Factory;
import co.edu.escuelaing.app.services.ILogService;
import co.edu.escuelaing.app.services.impl.LogService;

public class ServiceFactory implements Factory<ILogService> {

    public static ServiceFactory instance = new ServiceFactory();

    private ILogService logService;

    private ServiceFactory() {
    }

    @Override
    public ILogService getInstance() {
        if (logService == null) {
            logService = new LogService(LoadBalancerFactory.instance.getInstance());
        }
        return logService;
    }
}
