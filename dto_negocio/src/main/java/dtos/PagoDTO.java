/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import enumeradores.MetodoPago;

/**
 *
 * @author Usuario
 */
public class PagoDTO {
    
    private Integer idPagoDTO;
    private MetodoPago metodo;

    public PagoDTO(Integer idPagoDTO, MetodoPago metodo) {
        this.idPagoDTO = idPagoDTO;
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

    public Integer getIdPagoDTO() {
        return idPagoDTO;
    }

    public void setIdPagoDTO(Integer idPago) {
        this.idPagoDTO = idPago;
    }
    
    
}
