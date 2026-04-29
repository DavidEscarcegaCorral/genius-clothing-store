/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

/**
 *
 * @author Usuario
 *    
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
public class OpinionDTO {
    
    private Integer idOpinion;
    private String opinion;

    public OpinionDTO(Integer idOpinion, String opinion) {
        this.idOpinion = idOpinion;
        this.opinion = opinion;
    }

    public OpinionDTO(String opinion) {
        this.opinion = opinion;
    }

    public Integer getIdOpinion() {
        return idOpinion;
    }

    public void setIdOpinion(Integer idOpinion) {
        this.idOpinion = idOpinion;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }
    
    
}
