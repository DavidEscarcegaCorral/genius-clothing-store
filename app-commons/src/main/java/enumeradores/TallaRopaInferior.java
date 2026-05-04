package enumeradores;

public enum TallaRopaInferior {
    TALLA_28("28"),
    TALLA_30("30"),
    TALLA_32("32"),
    TALLA_34("34"),
    TALLA_36("36"),
    TALLA_38("38"),
    TALLA_40("40");

    private final String valor;

    TallaRopaInferior(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Talla " + valor;
    }
}
