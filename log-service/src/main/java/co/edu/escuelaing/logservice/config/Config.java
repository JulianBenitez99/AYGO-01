package co.edu.escuelaing.logservice.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;

import java.util.Map;

/**
 * Config class that contains the configuration of the application
 */
public class Config {

    private Config() {
    }

    public static MongoClientSettings getMongoClientSettings() {
        Map<String, String> envs = System.getenv();
        String mongoHost = envs.getOrDefault("MONGO_HOST", "localhost");
        String mongoPort = envs.getOrDefault("MONGO_PORT", "27017");
        return MongoClientSettings.builder()
                .applyConnectionString(
                        new ConnectionString(String.format("mongodb://%s:%s", mongoHost, mongoPort))
                )
                .build();
    }

    public static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

}
