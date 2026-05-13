package adapters;

import dominio.CarritoEntidad;
import dominio.ItemCarrito;
import entidadesmongo.CarritoMongoEntidad;
import entidadesmongo.ItemCarritoMongoEntidad;
import java.util.ArrayList;
import java.util.List;

public class CarritoPersistenciaAdapter {

    public CarritoMongoEntidad convertirAMongo(CarritoEntidad carrito) {
        if (carrito == null) {
            return null;
        }

        CarritoMongoEntidad mongo = new CarritoMongoEntidad(carrito.getUsuarioId());
        mongo.setId(convertirStringAObjectId(carrito.getId()));

        List<ItemCarritoMongoEntidad> itemsMongo = new ArrayList<>();
        if (carrito.getItems() != null) {
            for (ItemCarrito item : carrito.getItems()) {
                itemsMongo.add(convertirItemAMongo(item));
            }
        }
        mongo.setItems(itemsMongo);

        return mongo;
    }

    public ItemCarritoMongoEntidad convertirItemAMongo(ItemCarrito item) {
        if (item == null) {
            return null;
        }

        ItemCarritoMongoEntidad mongo = new ItemCarritoMongoEntidad();
        mongo.setProductoId(item.getProductoId());
        mongo.setNombre(item.getNombre());
        mongo.setPrecio(item.getPrecio());
        mongo.setTallaSeleccionada(item.getTallaSeleccionada());
        mongo.setCantidad(item.getCantidad());
        mongo.setRutaImagen(item.getRutaImagen());

        return mongo;
    }

    public CarritoEntidad convertirADominio(CarritoMongoEntidad mongo) {
        if (mongo == null) {
            return null;
        }

        CarritoEntidad carrito = new CarritoEntidad();
        carrito.setId(convertirObjectIdAString(mongo.getId()));
        carrito.setUsuarioId(mongo.getUsuarioId());

        List<ItemCarrito> items = new ArrayList<>();
        if (mongo.getItems() != null) {
            for (ItemCarritoMongoEntidad itemMongo : mongo.getItems()) {
                items.add(convertirItemADominio(itemMongo));
            }
        }
        carrito.setItems(items);

        return carrito;
    }

    public ItemCarrito convertirItemADominio(ItemCarritoMongoEntidad mongo) {
        if (mongo == null) {
            return null;
        }

        ItemCarrito item = new ItemCarrito();
        item.setProductoId(mongo.getProductoId());
        item.setNombre(mongo.getNombre());
        item.setPrecio(mongo.getPrecio());
        item.setTallaSeleccionada(mongo.getTallaSeleccionada());
        item.setCantidad(mongo.getCantidad() != null ? mongo.getCantidad() : 1);
        item.setRutaImagen(mongo.getRutaImagen());

        return item;
    }

    public org.bson.types.ObjectId convertirStringAObjectId(String id) {
        if (id == null || id.isBlank()) {
            return null;
        }
        return new org.bson.types.ObjectId(id);
    }

    public String convertirObjectIdAString(org.bson.types.ObjectId id) {
        if (id == null) {
            return null;
        }
        return id.toHexString();
    }
}