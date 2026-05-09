/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

/**
 *
 * @author Usuario
 */
public class ConexionMongoDB {
    private static ConexionMongoDB instancia;
    private MongoClient mongoClient;
    private MongoDatabase database;

    private ConexionMongoDB() {
        CodecProvider pojoProvider = PojoCodecProvider.builder()
                .automatic(true)
                .build();

        CodecRegistry codecRegistry = fromRegistries(
                MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(pojoProvider)
        );

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString("mongodb://localhost:27017"))
                .codecRegistry(codecRegistry)
                .build();

        this.mongoClient = MongoClients.create(settings);
        this.database = mongoClient.getDatabase("genius_clothing_store");
    }

    public static synchronized ConexionMongoDB getInstance() {
        if (instancia == null) {
            instancia = new ConexionMongoDB();
        }
        return instancia;
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public <T> MongoCollection<T> getCollection(String nombre, Class<T> entidad) {
        return database.getCollection(nombre, entidad);
    }

    public void cerrarConexion() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }

}
