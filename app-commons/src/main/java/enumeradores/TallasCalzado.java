package enumeradores;

public enum TallasCalzado {
    TALLA_23("23"),
    TALLA_23_5("23.5"),
    TALLA_24("24"),
    TALLA_24_5("24.5"),
    TALLA_25("25"),
    TALLA_25_5("25.5"),
    TALLA_26("26"),
    TALLA_26_5("26.5"),
    TALLA_27("27"),
    TALLA_27_5("27.5"),
    TALLA_28("28"),
    TALLA_28_5("28.5"),
    TALLA_29("29"),
    TALLA_30("30");

    private final String valor;

    TallasCalzado(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return valor + " MX";
    }
}
