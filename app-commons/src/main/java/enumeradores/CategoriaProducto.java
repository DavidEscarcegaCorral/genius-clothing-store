package enumeradores;

public enum CategoriaProducto {
    CALZADO("Calzado"),
    CAMISETA("Camiseta"),
    PANTALON("Pantalón"),
    CHAQUETA("Chaqueta"),
    SUDADERA("Sudadera"),
    ABRIGO("Abrigo"),
    SHORT("Short"),
    FALDA("Falda"),
    VESTIDO("Vestido"),
    ACCESORIOS("Accesorios");

    private String descripcion;

    CategoriaProducto(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
