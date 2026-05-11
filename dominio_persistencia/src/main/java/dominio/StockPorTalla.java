package dominio;

public class StockPorTalla {
    private String talla;
    private Integer cantidad;

    public StockPorTalla() {
    }

    public StockPorTalla(String talla, Integer cantidad) {
        this.talla = talla;
        this.cantidad = cantidad;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getStockTotal() {
        return cantidad != null ? cantidad : 0;
    }
}