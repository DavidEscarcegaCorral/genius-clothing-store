package enumeradores;

public enum EtiquetaEstilo {
    DEPORTE("Deporte"),
    CASUAL("Casual"),
    FORMAL("Formal"),
    URBANO("Urbano"),
    ELEGANTE("Elegante"),
    DEPORTIVO("Deportivo"),
    CLASICO("Clásico");

    private String valor;

    EtiquetaEstilo(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
