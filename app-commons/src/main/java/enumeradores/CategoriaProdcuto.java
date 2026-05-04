package enumeradores;

public enum CategoriaProdcuto {
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

    CategoriaProdcuto(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
