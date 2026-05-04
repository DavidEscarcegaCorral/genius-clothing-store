package enumeradores;

public enum EtiquetaGenero {
    HOMBRE("hombre"),
    MUJER("Mujer"),
    UNISEX("Unisex");

    private String valor;

    EtiquetaGenero(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

}
