/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adapters;

import dominio.ProductoEntidad;
import entidadesmongo.ProductoMongoEntidad;
import excepciones.PersistenciaException;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Usuario
 */
public class ProductoPersistenciaAdapter {
    
/**
 * Adapter encargado de convertir objetos del dominio limpio
 * a entidades MongoDB y viceversa.
 */

    /**
     * Convierte un producto del dominio limpio
     * a una entidad MongoDB.
     *
     * @param producto producto del dominio.
     * @return entidad MongoDB.
     * @throws PersistenciaException si el id no es válido.
     */
    public ProductoMongoEntidad convertirAMongo(ProductoEntidad producto)
            throws PersistenciaException {

        if (producto == null) {
            return null;
        }

        ProductoMongoEntidad entidadMongo = new ProductoMongoEntidad();

        entidadMongo.setId(convertirStringAObjectId(producto.getId()));
        entidadMongo.setNombre(producto.getNombre());
        entidadMongo.setDescripcion(producto.getDescrpcionProducto());
        entidadMongo.setPrecio(producto.getPrecio());
        entidadMongo.setRutaImagen(producto.getRutaImagen());
        entidadMongo.setStock(producto.getStock());
        entidadMongo.setEstado(producto.getEstado());
        entidadMongo.setCategoria(producto.getCategoria());
        entidadMongo.setTallas(producto.getTallasDisponibles());
        entidadMongo.setGenero(producto.getGenero());
        entidadMongo.setEstilos(producto.getEstilos());

        return entidadMongo;
    }

    /**
     * Convierte una entidad MongoDB
     * a un producto del dominio limpio.
     *
     * @param entidadMongo entidad recuperada de MongoDB.
     * @return producto limpio.
     */
    public ProductoEntidad convertirADominio(
            ProductoMongoEntidad entidadMongo) {

        if (entidadMongo == null) {
            return null;
        }

        ProductoEntidad producto = new ProductoEntidad();

        producto.setId(convertirObjectIdAString(entidadMongo.getId()));
        producto.setNombre(entidadMongo.getNombre());
        producto.setDescrpcionProducto(entidadMongo.getDescripcion());
        producto.setPrecio(entidadMongo.getPrecio());
        producto.setRutaImagen(entidadMongo.getRutaImagen());
        producto.setStock(entidadMongo.getStock());
        producto.setEstado(entidadMongo.getEstado());
        producto.setCategoria(entidadMongo.getCategoria());
        producto.setTallasDisponibles(entidadMongo.getTallas());
        producto.setGenero(entidadMongo.getGenero());
        producto.setEstilos(entidadMongo.getEstilos());

        return producto;
    }

    /**
     * Convierte una lista de entidades MongoDB
     * a productos del dominio limpio.
     *
     * @param entidadesMongo lista MongoDB.
     * @return lista de productos limpios.
     */
    public List<ProductoEntidad> convertirListaADominio(
            List<ProductoMongoEntidad> entidadesMongo) {

        List<ProductoEntidad> productos = new ArrayList<>();

        if (entidadesMongo == null) {
            return productos;
        }

        for (ProductoMongoEntidad entidadMongo : entidadesMongo) {
            productos.add(convertirADominio(entidadMongo));
        }

        return productos;
    }

    /**
     * Convierte String a ObjectId.
     *
     * Si viene null o vacío, Mongo generará el id.
     *
     * @param id identificador como texto.
     * @return ObjectId.
     * @throws PersistenciaException si el formato no es válido.
     */
    public ObjectId convertirStringAObjectId(String id)
            throws PersistenciaException {

        if (id == null || id.isBlank()) {
            return null;
        }

        if (!ObjectId.isValid(id)) {
            throw new PersistenciaException(
                    "El id recibido no tiene formato válido de ObjectId."
            );
        }

        return new ObjectId(id);
    }

    /**
     * Convierte ObjectId a String.
     *
     * @param id ObjectId.
     * @return id como texto.
     */
    public String convertirObjectIdAString(ObjectId id) {

        if (id == null) {
            return null;
        }

        return id.toHexString();
    }
    
}

