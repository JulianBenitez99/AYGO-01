package co.edu.escuelaing.logservice.repository;

import co.edu.escuelaing.logservice.entities.Log;

import java.util.List;

public interface ILogRepository {
    void saveLog(Log log);

    List<Log> getLogs(int n);
}
