package co.edu.escuelaing.logservice.repository.impl;

import co.edu.escuelaing.logservice.config.Config;
import co.edu.escuelaing.logservice.entities.Log;
import co.edu.escuelaing.logservice.repository.ILogRepository;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.mongodb.client.model.Sorts.descending;

/*
 * LogMongoRepository
 */
public class LogMongoRepository implements ILogRepository {

    private static String MONGO_DB = "logs";

    private static String MONGO_COLLECTION = "logs";

    private MongoCollection<Document> logMongoCollection;

    public LogMongoRepository() {
        MongoClient mongoClient = MongoClients.create(Config.getMongoClientSettings());
        logMongoCollection = mongoClient
                .getDatabase(MONGO_DB)
                .getCollection(MONGO_COLLECTION);
    }

    @Override
    public void saveLog(Log log) {
        Document document = new Document()
                .append("msg", log.getMessage())
                .append("date", log.getEventDate().toString());
        logMongoCollection.insertOne(document);
    }

    @Override
    public List<Log> getLogs(int n) {
        List<Document> logsDocuments = new ArrayList<>();
        logMongoCollection
                .find()
                .sort(descending("_id"))
                .limit(n)
                .into(logsDocuments);
        return logsDocuments.stream()
                .map(d -> new Log(d.getString("msg"), LocalDateTime.parse(d.getString("date"))))
                .collect(Collectors.toList());
    }
}
