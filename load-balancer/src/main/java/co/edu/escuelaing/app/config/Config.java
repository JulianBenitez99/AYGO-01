package co.edu.escuelaing.app.config;

import java.util.Arrays;
import java.util.List;

public class Config {
    public static List<String> getServers() {
        String servers = System.getenv("SERVERS");
        if (servers == null) {
            servers = "http://localhost:4567";
        }
        return Arrays.asList(servers.split(","));
    }

    public static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4568;
    }

}
