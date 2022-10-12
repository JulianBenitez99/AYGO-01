package co.edu.escuelaing.logservice.services.impl;

import co.edu.escuelaing.logservice.entities.Log;
import co.edu.escuelaing.logservice.repository.ILogRepository;
import co.edu.escuelaing.logservice.services.ILogService;

import java.time.LocalDateTime;
import java.util.List;

public class LogService implements ILogService {

    private final ILogRepository logRepository;

    private static final int LIMIT = 10;

    public LogService(ILogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public List<Log> saveAndList(String msg) {
        Log log = new Log(msg, LocalDateTime.now());
        logRepository.saveLog(log);
        return logRepository.getLogs(LIMIT);
    }
}
