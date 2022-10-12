package co.edu.escuelaing.logservice.factories.impl;

import co.edu.escuelaing.logservice.factories.Factory;
import co.edu.escuelaing.logservice.services.ILogService;
import co.edu.escuelaing.logservice.services.impl.LogService;

public class ServiceFactory implements Factory<ILogService> {

    public static ServiceFactory instance = new ServiceFactory();

    private ILogService logService;

    private ServiceFactory() {
    }

    @Override
    public ILogService getInstance() {
        if (logService == null) {
            logService = new LogService(RepositoryFactory.instance.getInstance());
        }
        return logService;
    }
}
