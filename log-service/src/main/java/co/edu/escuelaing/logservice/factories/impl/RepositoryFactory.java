package co.edu.escuelaing.logservice.factories.impl;

import co.edu.escuelaing.logservice.factories.Factory;
import co.edu.escuelaing.logservice.repository.ILogRepository;
import co.edu.escuelaing.logservice.repository.impl.LogMongoRepository;

public class RepositoryFactory implements Factory<ILogRepository> {

    public static RepositoryFactory instance = new RepositoryFactory();

    private ILogRepository logRepository;

    private RepositoryFactory() {
    }

    @Override
    public ILogRepository getInstance() {
        if (logRepository == null) {
            logRepository = new LogMongoRepository();
        }
        return logRepository;
    }
}
