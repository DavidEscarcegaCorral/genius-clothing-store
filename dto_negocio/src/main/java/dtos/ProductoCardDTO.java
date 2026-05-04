package dtos;

import enumeradores.EtiquetaGenero;

import java.math.BigDecimal;

public class ProductoCardDTO {
    private String prodcutoId;
    private String nombreProdcto;
    private BigDecimal precioProducto;
    private EtiquetaGenero generoProcuto;
    private String rutaImg;

    public ProductoCardDTO() {
    }

    public ProductoCardDTO(String prodcutoId, String nombreProdcto, BigDecimal precioProducto, EtiquetaGenero generoProcuto, String rutaImg) {
        this.prodcutoId = prodcutoId;
        this.nombreProdcto = nombreProdcto;
        this.precioProducto = precioProducto;
        this.generoProcuto = generoProcuto;
        this.rutaImg = rutaImg;
    }

    public String getProdcutoId() {
        return prodcutoId;
    }

    public void setProdcutoId(String prodcutoId) {
        this.prodcutoId = prodcutoId;
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

    public String getPrecioFormateado() {
        return "$" + precioProducto.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
    }
}
