package dominio;

import java.math.BigDecimal;
import java.util.UUID;

public class ItemCarrito {
    private String instanciaId;
    private String productoId;
    private String nombre;
    private BigDecimal precio;
    private String tallaSeleccionada;

    public ItemCarrito() {
        this.instanciaId = UUID.randomUUID().toString();
    }

    public ItemCarrito(String productoId, String nombre, BigDecimal precio, String tallaSeleccionada) {
        this();
        this.productoId = productoId;
        this.nombre = nombre;
        this.precio = precio;
        this.tallaSeleccionada = tallaSeleccionada;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getInstanciaId() {
        return instanciaId;
    }

    public void setInstanciaId(String instanciaId) {
        this.instanciaId = instanciaId;
    }

    public String getProductoId() {
        return productoId;
    }

    public void setProductoId(String productoId) {
        this.productoId = productoId;
    }

    public String getTallaSeleccionada() {
        return tallaSeleccionada;
    }

    public void setTallaSeleccionada(String tallaSeleccionada) {
        this.tallaSeleccionada = tallaSeleccionada;
    }
}
