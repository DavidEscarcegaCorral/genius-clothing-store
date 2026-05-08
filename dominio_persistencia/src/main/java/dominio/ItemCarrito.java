package dominio;

import java.util.UUID;

public class ItemCarrito {
    private String instanciaId;
    private String prodcutoId;
    private String tallaSeleccionada;

    public ItemCarrito() {

    }

    public ItemCarrito(String tallaSeleccionada, String instanciaId) {
        this.instanciaId = UUID.randomUUID().toString();
        this.tallaSeleccionada = tallaSeleccionada;
        this.instanciaId = instanciaId;
    }

    public String getInstanciaId() {
        return instanciaId;
    }

    public void setInstanciaId(String instanciaId) {
        this.instanciaId = instanciaId;
    }

    public String getProdcutoId() {
        return prodcutoId;
    }

    public void setProdcutoId(String prodcutoId) {
        this.prodcutoId = prodcutoId;
    }

    public String getTallaSeleccionada() {
        return tallaSeleccionada;
    }

    public void setTallaSeleccionada(String tallaSeleccionada) {
        this.tallaSeleccionada = tallaSeleccionada;
    }
}
