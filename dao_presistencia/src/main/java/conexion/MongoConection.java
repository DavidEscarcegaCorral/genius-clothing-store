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
import entidadesmongo.ProductoMongoEntidad;
import org.bson.codecs.configuration.CodecProvider;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author Usuario
 */
public class MongoConection {
    
    private static final String URL = "mongodb://localhost:27017";
    private static final String NOMBRE_BASE_DATOS = "genius_clothing_store";
    private static final String COLECCION_PRODUCTOS = "productos";
    private static MongoClient cliente;

    private MongoConection() {
    }

    public static MongoClient obtenerCliente() {

        //El uso de if (cliente == null) asegura que los recursos de red y memoria solo se utilicen cuando se solicita la conexión por primera vez.
        if (cliente == null) {

            CodecProvider proveedorPojo = PojoCodecProvider.builder()
                    .automatic(true) // Esto permite que MongoDB Java Driver convierta automáticamente tus clases de Java a documentos BSON y viceversa, sin necesidad de escribir mapeadores manuales.
                    .build();

            CodecRegistry registroCodecs = fromRegistries( // Combina el registro de codecs por defecto de MongoDB con el nuevo proveedor de POJOs
                    MongoClientSettings.getDefaultCodecRegistry(),
                    fromProviders(proveedorPojo)
            );

            // Se utiliza MongoClientSettings para encapsular la cadena de conexión (URL) y el registro de codecs, permitiendo una creación de cliente limpia y centralizada.
            MongoClientSettings configuracion = MongoClientSettings.builder()
                    .applyConnectionString(new ConnectionString(URL)) // a veces se lo pueden encontrar como URI lo cual e sun identificador unico de acceso a un recurso
                    .codecRegistry(registroCodecs)
                    .build();
            // Crea la instancia única del cliente
            cliente = MongoClients.create(configuracion);
        }

        return cliente;
    }

    public static MongoDatabase obtenerBaseDatos() {
        return obtenerCliente().getDatabase(NOMBRE_BASE_DATOS); //manejamos la misma bd para to2 el sistema
    }

    //Centralizar el acceso a las colecciones de productos
    public static MongoCollection<ProductoMongoEntidad> obtenerColeccionProductos() {
        //Obtenemos la base de datos
        return obtenerBaseDatos()
                //Obtenemos la coleccion y se convertiran a producto mongo entidad
                //Y se creara la colección de productos
                .getCollection(COLECCION_PRODUCTOS, ProductoMongoEntidad.class);
    }
    
}
