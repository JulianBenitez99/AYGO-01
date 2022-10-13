package co.edu.escuelaing.logservice.respository.impl;

import co.edu.escuelaing.logservice.entities.Log;
import co.edu.escuelaing.logservice.factories.impl.RepositoryFactory;
import co.edu.escuelaing.logservice.repository.ILogRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.time.LocalDateTime;

import static com.github.stefanbirkner.systemlambda.SystemLambda.withEnvironmentVariable;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
public class LogMongoRepositoryIntegrationTest {

    @Container
    final static MongoDBContainer mongoDBContainer = new MongoDBContainer(DockerImageName.parse("mongo:6.0.2"));

    @BeforeAll
    public static void setUp() {
        mongoDBContainer.start();
    }

    @Test
    public void saveAndRetrieve() throws Exception {
        withEnvironmentVariable("MONGO_PORT", String.valueOf(mongoDBContainer.getMappedPort(27017)))
                .execute(() -> {
                    ILogRepository logRepository = RepositoryFactory.instance.getInstance();
                    Log log = new Log("test", LocalDateTime.now().toString());
                    logRepository.saveLog(log);
                    assertEquals(logRepository.getLogs(1).get(0), log);
                });
    }
}
