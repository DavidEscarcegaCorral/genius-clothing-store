/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import enumeradores.metodoPago;

/**
 *
 * @author Usuario
 */
public class PagoDTO {
    
    private Integer idPagoDTO;
    private metodoPago metodo;

    public PagoDTO(Integer idPagoDTO, metodoPago metodo) {
        this.idPagoDTO = idPagoDTO;
        this.metodo = metodo;
    }

    public PagoDTO(metodoPago metodo) {
        this.metodo = metodo;
    }

    public PagoDTO() {
    }
    

    public metodoPago getMetodo() {
        return metodo;
    }

    public void setMetodo(metodoPago metodo) {
        this.metodo = metodo;
    }

    public Integer getIdPagoDTO() {
        return idPagoDTO;
    }

    public void setIdPagoDTO(Integer idPago) {
        this.idPagoDTO = idPago;
    }
    
    
}
