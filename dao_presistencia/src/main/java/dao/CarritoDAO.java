package dao;

import adapters.CarritoPersistenciaAdapter;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.UpdateResult;
import conexion.ConexionMongoDB;
import dominio.CarritoEntidad;
import dominio.ItemCarrito;
import entidadesmongo.CarritoMongoEntidad;
import entidadesmongo.ItemCarritoMongoEntidad;
import excepciones.PersistenciaException;
import org.bson.types.ObjectId;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class CarritoDAO implements ICarritoDAO {

    private final MongoCollection<CarritoMongoEntidad> coleccionCarritos;
    private final CarritoPersistenciaAdapter carritoAdapter;

    public CarritoDAO() {
        this.coleccionCarritos = ConexionMongoDB.getInstance()
                .getCollection("carritos", CarritoMongoEntidad.class);
        this.carritoAdapter = new CarritoPersistenciaAdapter();
    }

    @Override
    public CarritoEntidad obtenerCarritoPorUsuario(String usuarioId) throws PersistenciaException {
        if (usuarioId == null || usuarioId.isBlank()) {
            throw new PersistenciaException("El ID de usuario no puede ser nulo o vacío");
        }

        try {
            CarritoMongoEntidad mongoCarrito = coleccionCarritos.find(eq("usuarioId", usuarioId)).first();
            
            if (mongoCarrito == null) {
                CarritoEntidad nuevoCarrito = new CarritoEntidad();
                nuevoCarrito.setUsuarioId(usuarioId);
                nuevoCarrito.setItems(new ArrayList<>());
                return nuevoCarrito;
            }
            
            return carritoAdapter.convertirADominio(mongoCarrito);
        } catch (MongoException e) {
            throw new PersistenciaException("Error al obtener el carrito del usuario", e);
        }
    }

    @Override
    public CarritoEntidad agregarProducto(String usuarioId, String productoId, String nombre, 
            BigDecimal precio, String talla, Integer cantidad, String rutaImagen) throws PersistenciaException {
        
        if (usuarioId == null || usuarioId.isBlank()) {
            throw new PersistenciaException("El ID de usuario no puede ser nulo o vacío");
        }
        
        try {
            CarritoMongoEntidad mongoCarrito = coleccionCarritos.find(eq("usuarioId", usuarioId)).first();
            
            if (mongoCarrito == null) {
                mongoCarrito = new CarritoMongoEntidad(usuarioId);
            }
            
            if (mongoCarrito.getItems() == null) {
                mongoCarrito.setItems(new ArrayList<>());
            }
            
            boolean productoExiste = false;
            for (ItemCarritoMongoEntidad item : mongoCarrito.getItems()) {
                if (item.getProductoId().equals(productoId) && 
                    (talla == null || talla.equals(item.getTallaSeleccionada()))) {
                    item.setCantidad(item.getCantidad() + cantidad);
                    productoExiste = true;
                    break;
                }
            }
            
            if (!productoExiste) {
                ItemCarritoMongoEntidad nuevoItem = new ItemCarritoMongoEntidad(
                    productoId, nombre, precio, talla, cantidad, rutaImagen
                );
                mongoCarrito.getItems().add(nuevoItem);
            }
            
            if (mongoCarrito.getId() == null) {
                coleccionCarritos.insertOne(mongoCarrito);
            } else {
                coleccionCarritos.replaceOne(eq("usuarioId", usuarioId), mongoCarrito);
            }
            
            return carritoAdapter.convertirADominio(mongoCarrito);
        } catch (MongoException e) {
            throw new PersistenciaException("Error al agregar producto al carrito", e);
        }
    }

    @Override
    public CarritoEntidad eliminarProducto(String usuarioId, String productoId) throws PersistenciaException {
        if (usuarioId == null || usuarioId.isBlank()) {
            throw new PersistenciaException("El ID de usuario no puede ser nulo o vacío");
        }
        
        try {
            CarritoMongoEntidad mongoCarrito = coleccionCarritos.find(eq("usuarioId", usuarioId)).first();
            
            if (mongoCarrito == null) {
                CarritoEntidad nuevoCarrito = new CarritoEntidad();
                nuevoCarrito.setUsuarioId(usuarioId);
                nuevoCarrito.setItems(new ArrayList<>());
                return nuevoCarrito;
            }
            
            if (mongoCarrito.getItems() != null) {
                mongoCarrito.getItems().removeIf(item -> item.getProductoId().equals(productoId));
            }
            
            coleccionCarritos.replaceOne(eq("usuarioId", usuarioId), mongoCarrito);
            
            return carritoAdapter.convertirADominio(mongoCarrito);
        } catch (MongoException e) {
            throw new PersistenciaException("Error al eliminar producto del carrito", e);
        }
    }

    @Override
    public void vaciarCarrito(String usuarioId) throws PersistenciaException {
        if (usuarioId == null || usuarioId.isBlank()) {
            throw new PersistenciaException("El ID de usuario no puede ser nulo o vacío");
        }
        
        try {
            CarritoMongoEntidad mongoCarrito = new CarritoMongoEntidad(usuarioId);
            mongoCarrito.setItems(new ArrayList<>());
            coleccionCarritos.replaceOne(eq("usuarioId", usuarioId), mongoCarrito);
        } catch (MongoException e) {
            throw new PersistenciaException("Error al vaciar el carrito", e);
        }
    }
}