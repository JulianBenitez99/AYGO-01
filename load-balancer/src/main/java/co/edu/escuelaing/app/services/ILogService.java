package co.edu.escuelaing.app.services;

import co.edu.escuelaing.app.entities.Log;

import java.util.List;

public interface ILogService {

    Log[] saveAndList(String msg);

}
