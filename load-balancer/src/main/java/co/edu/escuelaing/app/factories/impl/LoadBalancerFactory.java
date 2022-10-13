package co.edu.escuelaing.app.factories.impl;

import co.edu.escuelaing.app.config.Config;
import co.edu.escuelaing.app.factories.Factory;
import co.edu.escuelaing.app.loadbalancer.LoadBalancer;
import co.edu.escuelaing.app.loadbalancer.RoundRobinLoadBalancer;

public class LoadBalancerFactory implements Factory<LoadBalancer> {

    public static LoadBalancerFactory instance = new LoadBalancerFactory();

    private LoadBalancer loadBalancer;

    private LoadBalancerFactory() {
    }

    public LoadBalancer getInstance() {
       if (loadBalancer == null) {
           loadBalancer = new RoundRobinLoadBalancer(Config.getServers());
       }
       return loadBalancer;
    }
}
