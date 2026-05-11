/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import dto_response.ProductoSalidaDTO;

/**
 *
 * @author Usuario
 */
public class CarritoDTO {

    private Integer idCarritoDTO;
    private ProductoSalidaDTO producto;
    private Integer cantidad;

    public CarritoDTO(Integer idCarritoDTO, ProductoSalidaDTO producto, Integer cantidad) {
        this.idCarritoDTO = idCarritoDTO;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public CarritoDTO(ProductoSalidaDTO producto, Integer cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public CarritoDTO() {
    }

    public ProductoSalidaDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoSalidaDTO producto) {
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
