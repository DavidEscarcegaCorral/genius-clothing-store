package dtos;

import enumeradores.EstadoProducto;
import java.math.BigDecimal;

public class ProductoDTO {
    private String sku;
    private String nombre;
    private String descrpcionProducto;
    //Posible enum de Tallas
    private BigDecimal precio;
    private String rutaImagen;
    private EstadoProducto estado;

    public ProductoDTO(){

    }

    public ProductoDTO(String sku, String nombre, String descrpcionProducto, BigDecimal precio, String rutaImagen, EstadoProducto estado) {
        this.sku = sku;
        this.nombre = nombre;
        this.descrpcionProducto = descrpcionProducto;
        this.precio = precio;
        this.rutaImagen = rutaImagen;
        this.estado = estado;
    }

    public EstadoProducto getEstado() {
        return estado;
    }

    public void setEstado(EstadoProducto estado) {
        this.estado = estado;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescrpcionProducto() {
        return descrpcionProducto;
    }

    public void setDescrpcionProducto(String descrpcionProducto) {
        this.descrpcionProducto = descrpcionProducto;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }
}
