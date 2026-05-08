package dominio;

import java.util.ArrayList;
import java.util.List;

public class CarritoEntidad {
    private String id;
    private String usuarioid;
    private List<ItemCarrito> items;

    public CarritoEntidad() {
        this.items = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(String usuarioid) {
        this.usuarioid = usuarioid;
    }

    public List<ItemCarrito> getItems() {
        return items;
    }

    public void setItems(List<ItemCarrito> items) {
        this.items = items;
    }
}
