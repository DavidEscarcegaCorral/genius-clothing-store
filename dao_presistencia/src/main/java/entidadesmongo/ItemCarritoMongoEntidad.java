package entidadesmongo;

import java.math.BigDecimal;

public class ItemCarritoMongoEntidad {

    private String productoId;
    private String nombre;
    private BigDecimal precio;
    private String tallaSeleccionada;
    private Integer cantidad;
    private String rutaImagen;

    public ItemCarritoMongoEntidad() {
    }

    public ItemCarritoMongoEntidad(String productoId, String nombre, BigDecimal precio, 
            String tallaSeleccionada, Integer cantidad, String rutaImagen) {
        this.productoId = productoId;
        this.nombre = nombre;
        this.precio = precio;
        this.tallaSeleccionada = tallaSeleccionada;
        this.cantidad = cantidad;
        this.rutaImagen = rutaImagen;
    }

    public String getProductoId() {
        return productoId;
    }

    public void setProductoId(String productoId) {
        this.productoId = productoId;
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

    public String getTallaSeleccionada() {
        return tallaSeleccionada;
    }

    public void setTallaSeleccionada(String tallaSeleccionada) {
        this.tallaSeleccionada = tallaSeleccionada;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }
}