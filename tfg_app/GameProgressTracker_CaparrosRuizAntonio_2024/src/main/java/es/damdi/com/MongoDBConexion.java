package es.damdi.com;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBConexion {
    private static final String HOST = "localhost";
    private static final int PORT = 27017;
    private static final String DATABASE_NAME = "GameProgressTracker";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "secret";  // Asegúrate de usar la contraseña correcta

    private MongoClient mongoClient;
    private MongoDatabase database;

    public MongoDBConexion() {
        // Configurar la dirección del servidor
        String connectionString = "mongodb://" + USERNAME + ":" + PASSWORD + "@" + HOST + ":" + PORT + "/" + DATABASE_NAME + "?authSource=admin";

        // Configurar las opciones del cliente
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .build();

        // Crear el cliente de MongoDB
        mongoClient = MongoClients.create(settings);

        // Obtener la base de datos
        database = mongoClient.getDatabase(DATABASE_NAME);
        System.out.println("Conectado a la BD");
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
            System.out.println("Desconectado de la BD");
        }
    }
}
