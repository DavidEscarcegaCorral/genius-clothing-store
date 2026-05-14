package adapters;

import dominio.ProductoEntidad;
import entidadesmongo.ProductoMongoEntidad;
import excepciones.PersistenciaException;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ProductoPersistenciaAdapter {

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
        entidadMongo.setInventario(convertirInventarioDominioAMongo(producto.getInventario()));
        entidadMongo.setEstado(producto.getEstado());
        entidadMongo.setCategoria(producto.getCategoria());
        entidadMongo.setGenero(producto.getGenero());
        entidadMongo.setEstilos(producto.getEstilos());

        return entidadMongo;
    }

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
        producto.setInventario(convertirInventarioMongoADominio(entidadMongo.getInventario()));
        producto.setEstado(entidadMongo.getEstado());
        producto.setCategoria(entidadMongo.getCategoria());
        producto.setGenero(entidadMongo.getGenero());
        producto.setEstilos(entidadMongo.getEstilos());

        return producto;
    }

    public List<ProductoEntidad> convertirListaADominio(List<ProductoMongoEntidad> entidadesMongo) {

        List<ProductoEntidad> productos = new ArrayList<>();

        if (entidadesMongo == null) {
            return productos;
        }

        for (ProductoMongoEntidad entidadMongo : entidadesMongo) {
            productos.add(convertirADominio(entidadMongo));
        }

        return productos;
    }

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

    public String convertirObjectIdAString(ObjectId id) {

        if (id == null) {
            return null;
        }

        return id.toHexString();
    }

    private List<entidadesmongo.StockPorTalla> convertirInventarioDominioAMongo(List<dominio.StockPorTalla> inventarioDominio) {
        if (inventarioDominio == null) return new ArrayList<>();
        List<entidadesmongo.StockPorTalla> inventarioMongo = new ArrayList<>();
        for (dominio.StockPorTalla item : inventarioDominio) {
            inventarioMongo.add(new entidadesmongo.StockPorTalla(item.getTalla(), item.getCantidad()));
        }
        return inventarioMongo;
    }

    private List<dominio.StockPorTalla> convertirInventarioMongoADominio(List<entidadesmongo.StockPorTalla> inventarioMongo) {
        if (inventarioMongo == null) return new ArrayList<>();
        List<dominio.StockPorTalla> inventarioDominio = new ArrayList<>();
        for (entidadesmongo.StockPorTalla item : inventarioMongo) {
            inventarioDominio.add(new dominio.StockPorTalla(item.getTalla(), item.getCantidad()));
        }
        return inventarioDominio;
    }

}

