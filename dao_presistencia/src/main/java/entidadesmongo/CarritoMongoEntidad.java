package entidadesmongo;

import java.util.ArrayList;
import java.util.List;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

public class CarritoMongoEntidad {

    @BsonId
    private ObjectId id;

    private String usuarioId;

    private List<ItemCarritoMongoEntidad> items;

    public CarritoMongoEntidad() {
        this.items = new ArrayList<>();
    }

    public CarritoMongoEntidad(String usuarioId) {
        this.usuarioId = usuarioId;
        this.items = new ArrayList<>();
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public List<ItemCarritoMongoEntidad> getItems() {
        return items;
    }

    public void setItems(List<ItemCarritoMongoEntidad> items) {
        this.items = items;
    }

    public String getIdComoTexto() {
        if (id == null) {
            return null;
        }
        return id.toHexString();
    }
}