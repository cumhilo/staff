package com.github.vcamilx.staff.manager.database;

import com.github.vcamilx.staff.Staff;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bukkit.Bukkit;

import javax.inject.Inject;

@SuppressWarnings("ConstantConditions")
public class MongoManager {

    @Inject
    private Staff staff;
    private final MongoClientURI uri = new MongoClientURI(staff.getConfig().getString("database.mongodb.uri"));
    private final MongoClient mongoClient = new MongoClient(uri);
    private final MongoDatabase database = mongoClient.getDatabase("moderation");
    private final MongoCollection<Document> collection = database.getCollection("staffs");

    public void connection() {
        if (database.getCollection("staffs") == null)
            database.createCollection("staffs");

        Bukkit.getLogger().info("Successfully connected to the database!");
    }

    public void disconnect() {
        if (mongoClient != null)
            mongoClient.close();

        Bukkit.getLogger().info("Successfully disconnected to the database!");
    }

    public MongoClientURI getUri() {
        return uri;
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public MongoCollection<Document> getCollection() {
        return collection;
    }
}
