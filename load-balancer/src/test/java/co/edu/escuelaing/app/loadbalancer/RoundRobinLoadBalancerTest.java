package co.edu.escuelaing.app.loadbalancer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoundRobinLoadBalancerTest {

    @Test
    public void shouldDoAFullRoundRobin() {
        RoundRobinLoadBalancer roundRobinLoadBalancer = new RoundRobinLoadBalancer(Arrays.asList("server1", "server2", "server3"));
        String server = roundRobinLoadBalancer.getServer();
        assertEquals("server1", server);
        server = roundRobinLoadBalancer.getServer();
        assertEquals("server2", server);
        server = roundRobinLoadBalancer.getServer();
        assertEquals("server3", server);
        server = roundRobinLoadBalancer.getServer();
        assertEquals("server1", server);
    }
}
