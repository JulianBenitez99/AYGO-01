package co.edu.escuelaing.app.loadbalancer;

import java.util.Collections;
import java.util.List;

public abstract class LoadBalancer {

    protected final List<String> servers;

    public LoadBalancer(List<String> servers) {
        this.servers = Collections.unmodifiableList(servers);
    }

    public abstract String getServer();

}
