package dtos;

import enumeradores.MetodoPago;

public class PagoDTO {

    private Integer idPago;
    private MetodoPago metodo;

    public PagoDTO(Integer idPago, MetodoPago metodo) {
        this.idPago = idPago;
        this.metodo = metodo;
    }

    public PagoDTO(MetodoPago metodo) {
        this.metodo = metodo;
    }

    public PagoDTO() {
    }

    public MetodoPago getMetodo() {
        return metodo;
    }

    public void setMetodo(MetodoPago metodo) {
        this.metodo = metodo;
    }

    public Integer getIdPago() {
        return idPago;
    }

    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }


}
