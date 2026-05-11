package dominio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CarritoEntidad {
    private String id;
    private String usuarioId;
    private List<ItemCarrito> items;

    public CarritoEntidad() {
        this.items = new ArrayList<>();
    }

    public BigDecimal calcularSubtotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (ItemCarrito item : items) {
            if (item.getPrecio() != null) {
                total = total.add(item.getPrecio());
            }
        }
        return total;
    }

    public void agregarItem(ItemCarrito item) {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }
        this.items.add(item);
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public List<ItemCarrito> getItems() {
        return items;
    }

    public void setItems(List<ItemCarrito> items) {
        this.items = items;
    }
}
