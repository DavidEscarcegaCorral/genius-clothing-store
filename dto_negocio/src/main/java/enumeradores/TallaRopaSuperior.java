package enumeradores;

public enum TallaRopaSuperior {
    XCH("XCH"),
    CH("CH"),
    M("M"),
    G("G"),
    XG("XG"),
    XXG("XXG");

    private final String valor;

    TallaRopaSuperior(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return valor;
    }
}
