/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

/**
 *
 * @author Usuario
 */
public class CarritoDTO {
    
    private Integer idCarritoDTO;
    private ProductoDTO producto;
    private Integer cantidad;

    public CarritoDTO(Integer idCarritoDTO, ProductoDTO producto, Integer cantidad) {
        this.idCarritoDTO = idCarritoDTO;
        this.producto = producto;
        this.cantidad = cantidad;
    }
    
    public CarritoDTO(ProductoDTO producto, Integer cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public CarritoDTO() {
    }

    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getIdCarritoDTO() {
        return idCarritoDTO;
    }

    public void setIdCarritoDTO(Integer idCarrito) {
        this.idCarritoDTO = idCarrito;
    }
    
    
    
}
