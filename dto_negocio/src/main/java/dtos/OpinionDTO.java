/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

/**
 *
 * @author Usuario
 *
 */
public class OpinionDTO {

    private Integer idOpinion;
    private String contenido;

    public OpinionDTO(Integer idOpinion, String contenido) {
        this.idOpinion = idOpinion;
        this.contenido = contenido;
    }

    public OpinionDTO(String contenido) {
        this.contenido = contenido;
    }

    public Integer getIdOpinion() {
        return idOpinion;
    }

    public void setIdOpinion(Integer idOpinion) {
        this.idOpinion = idOpinion;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }


}
