/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author Usuario
 */
public class MongoConection {
    
    //URL
    private static final String URL = "mongodb://localhost:27017";
    //Base de datos
    private static final String BASE_DATOS = "genius-clothing-store";
    
    private static MongoClient cliente;
    private MongoConection(){
        
    }
    //Singleton que recibe el cliente si existe y si no la crea junto con la conexion de Mongo
    //Crea la conexion con la base de datos
    private static MongoClient obtenerCliente(){
        if(cliente == null){
            cliente = MongoClients.create(URL);
        }
        return cliente;
    }
    
    //Obtiene la base de datos
    public static MongoDatabase obtenerBaseDatos(){
        return obtenerCliente().getDatabase(BASE_DATOS);
    }
    
    
}
