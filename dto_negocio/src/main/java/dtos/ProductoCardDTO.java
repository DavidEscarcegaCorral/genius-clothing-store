package dtos;

public class ProductoCardDTO {
    private String nombreProdcto;
    private String precioProducto;
    private String generoProcuto;
    private String rutaImg;

    public ProductoCardDTO() {
    }

    public ProductoCardDTO(String nombreProdcto, String precioProducto, String generoProcuto, String rutaImg) {
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

    public String getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(String precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getGeneroProcuto() {
        return generoProcuto;
    }

    public void setGeneroProcuto(String generoProcuto) {
        this.generoProcuto = generoProcuto;
    }

    public String getRutaImg() {
        return rutaImg;
    }

    public void setRutaImg(String rutaImg) {
        this.rutaImg = rutaImg;
    }
}
