package co.edu.escuelaing.app.loadbalancer;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RoundRobinLoadBalancer extends LoadBalancer {

    private AtomicInteger currentServer = new AtomicInteger(0);

    public RoundRobinLoadBalancer(List<String> servers) {
        super(servers);
    }

    @Override
    public String getServer() {
        int server = currentServer.getAndIncrement();
        if (server >= servers.size()) {
            currentServer.set(0);
            server = 0;
        }
        return servers.get(server);
    }
}
