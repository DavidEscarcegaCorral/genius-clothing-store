package dtos;

import enumeradores.EtiquetaGenero;

import java.math.BigDecimal;

public class ProductoCardDTO {
    private String productoId;
    private String nombreProducto;
    private BigDecimal precio;
    private EtiquetaGenero genero;
    private String rutaImagen;

    public ProductoCardDTO() {
    }

    public ProductoCardDTO(String productoId, String nombreProducto, BigDecimal precio, EtiquetaGenero genero, String rutaImagen) {
        this.productoId = productoId;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.genero = genero;
        this.rutaImagen = rutaImagen;
    }

    public String getProductoId() {
        return productoId;
    }

    public void setProductoId(String productoId) {
        this.productoId = productoId;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public EtiquetaGenero getGenero() {
        return genero;
    }

    public void setGenero(EtiquetaGenero genero) {
        this.genero = genero;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }
}
