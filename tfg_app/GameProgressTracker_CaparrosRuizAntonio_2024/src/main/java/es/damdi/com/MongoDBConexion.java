package es.damdi.com;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

/**
 * El tipo de conexión Mongo db.
 *
 * @author Antonio Caparros Ruiz
 */
public class MongoDBConexion {
    private static final String HOST = "localhost";
    private static final int PORT = 27017;
    private static final String DATABASE_NAME = "GameProgressTracker";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "secret";

    private MongoClient mongoClient;
    private MongoDatabase database;

    /**
     * Crea una instancia de una nueva conexión de base de datos Mongo.
     */
    public MongoDBConexion() {
        // Configuramos la dirección del servidor
        String connectionString = "mongodb://" + USERNAME + ":" + PASSWORD + "@" + HOST + ":" + PORT + "/" + DATABASE_NAME + "?authSource=admin";

        // Configuramos las opciones del cliente
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .build();

        // Creamos el cliente de MongoDB
        mongoClient = MongoClients.create(settings);

        // Obtenemos la base de datos
        database = mongoClient.getDatabase(DATABASE_NAME);
        System.out.println("Conectado a la BD");
    }

    /**
     * Obtiene la base de datos.
     *
     * @return la base de datos
     */
    public MongoDatabase getDatabase() {
        return database;
    }

    /**
     * Metodo para cerrar la base de datos.
     */
    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
            System.out.println("Desconectado de la BD");
        }
    }
}
