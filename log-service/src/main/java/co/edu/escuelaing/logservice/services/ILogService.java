package co.edu.escuelaing.logservice.services;

import co.edu.escuelaing.logservice.entities.Log;

import java.util.List;

public interface ILogService {

    List<Log> saveAndList(String msg);

}
