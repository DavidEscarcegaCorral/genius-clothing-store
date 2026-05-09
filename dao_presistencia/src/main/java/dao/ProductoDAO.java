/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import adapters.ProductoPersistenciaAdapter;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;
import com.mongodb.client.result.UpdateResult;
import conexion.MongoConection;
import dominio.ProductoEntidad;
import entidadesmongo.ProductoMongoEntidad;
import enumeradores.EstadoProducto;
import excepciones.PersistenciaException;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Usuario
 */
public class ProductoDAO implements IProductoDAO{
    
    private final MongoCollection<ProductoMongoEntidad> coleccionProductos;
    private final ProductoPersistenciaAdapter productoAdapter;

    public ProductoDAO() {
        this.coleccionProductos = MongoConection.obtenerColeccionProductos();
        this.productoAdapter = new ProductoPersistenciaAdapter();
    }

    @Override
    public ProductoEntidad agregarProducto(ProductoEntidad producto)throws PersistenciaException {
        
        if(producto == null){
            throw new PersistenciaException("El producto no puede ser nulo");
        }
        try{
            ProductoMongoEntidad mongoProducto = productoAdapter.convertirAMongo(producto);
            if(mongoProducto.getId()==null){
                mongoProducto.setId(new ObjectId());
            }
            coleccionProductos.insertOne(mongoProducto);            
            return productoAdapter.convertirADominio(mongoProducto);
            
        }catch(MongoException e){
            throw new PersistenciaException("Error al intentar guardar el producto",e);
        }
    }

    @Override
    public ProductoEntidad cambiarEstado(String id, EstadoProducto estado) throws PersistenciaException {
        
        ObjectId idObject = productoAdapter.convertirStringAObjectId(id);
        if(idObject == null){
            throw new PersistenciaException("El producto con ese id no existe");
        }
        try{
            //UpdateResult es por que update one lo regresa 
            //"estado" por que el campo del ProductoMongoEntidad se llama asi
            UpdateResult resultado = coleccionProductos.updateOne(eq("_id",idObject),set("estado",estado));
            
            ProductoMongoEntidad mongoProducto = coleccionProductos.find(eq("_id",idObject)).first();

            return productoAdapter.convertirADominio(mongoProducto);
        }catch(MongoException e){
            throw new PersistenciaException("Error al cambiar el estado del producto");
        }
    }

    @Override
    public ProductoEntidad publicarProducto(String id) throws PersistenciaException {
        ObjectId idObject = productoAdapter.convertirStringAObjectId(id);
        if(idObject == null){
            throw new PersistenciaException("El producto con ese id no existe");
        }
        try{
            UpdateResult resultado = coleccionProductos.updateOne(eq("_id",idObject),set("estado",EstadoProducto.PUBLICADO));
            ProductoMongoEntidad mongoProducto = coleccionProductos.find(eq("_id",idObject)).first();
            return productoAdapter.convertirADominio(mongoProducto);
        }catch(MongoException e){
            throw new PersistenciaException("Error al publicar el producto");
        }
        
    }

    @Override
    public ProductoEntidad buscarPorId(String id) throws PersistenciaException {
        ObjectId idObject = productoAdapter.convertirStringAObjectId(id);
        
        if(idObject == null){
            throw new PersistenciaException("El restaurante con ese id no existe");
        }
        try{
        ProductoMongoEntidad mongoProducto = coleccionProductos.find(eq("_id",idObject)).first();
        return productoAdapter.convertirADominio(mongoProducto);
        
        }catch(MongoException e){
            throw new PersistenciaException("Error al buscar el producto por id");
        }
    }

    @Override
    public List<ProductoEntidad> obtenerProductos() throws PersistenciaException {
        try{
            //Todos los resultados los convierte a una lista
            List<ProductoMongoEntidad> mongoProductoLista = coleccionProductos.find().into(new ArrayList<>());
            return productoAdapter.convertirListaADominio(mongoProductoLista);
        }catch(MongoException e){
            throw new PersistenciaException("Error al ver todos los productos");
        }
    }

}
