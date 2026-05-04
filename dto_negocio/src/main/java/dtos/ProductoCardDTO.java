package dtos;

import enumeradores.EtiquetaGenero;

import java.math.BigDecimal;

public class ProductoCardDTO {
    private String nombreProdcto;
    private BigDecimal precioProducto;
    private EtiquetaGenero generoProcuto;
    private String rutaImg;

    public ProductoCardDTO() {
    }

    public ProductoCardDTO(String nombreProdcto, BigDecimal precioProducto, EtiquetaGenero generoProcuto, String rutaImg) {
        this.nombreProdcto = nombreProdcto;
        this.precioProducto = precioProducto;
        this.generoProcuto = generoProcuto;
        this.rutaImg = rutaImg;
    }

    public String getNombreProdcto() {
        return nombreProdcto;
    }

    public void setNombreProdcto(String nombreProdcto) {
        this.nombreProdcto = nombreProdcto;
    }

    public BigDecimal getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(BigDecimal precioProducto) {
        this.precioProducto = precioProducto;
    }

    public EtiquetaGenero getGeneroProcuto() {
        return generoProcuto;
    }

    public void setGeneroProcuto(EtiquetaGenero generoProcuto) {
        this.generoProcuto = generoProcuto;
    }

    public String getRutaImg() {
        return rutaImg;
    }

    public void setRutaImg(String rutaImg) {
        this.rutaImg = rutaImg;
    }
}
