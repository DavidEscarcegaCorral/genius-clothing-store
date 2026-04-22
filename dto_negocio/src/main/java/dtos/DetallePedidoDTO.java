/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

/**
 *
 * @author Usuario
 */
public class DetallePedidoDTO {
    
    private Integer idDetallePedidoDTO;
    private ProductoDTO producto;
    private Integer cantidad;
    private Double precioUnitario;
    private Double subtotal;
    private Double descuento;

    public DetallePedidoDTO(Integer idDetallePedidoDTO, ProductoDTO producto, Integer cantidad, Double precioUnitario, Double subtotal, Double descuento) {
        this.idDetallePedidoDTO = idDetallePedidoDTO;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
        this.descuento = descuento;
    }

    public DetallePedidoDTO(ProductoDTO producto, Integer cantidad, Double precioUnitario, Double subtotal, Double descuento) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
        this.descuento = descuento;
    }

    public Integer getIdDetallePedidoDTO() {
        return idDetallePedidoDTO;
    }

    public void setIdDetallePedidoDTO(Integer idDetallePedidoDTO) {
        this.idDetallePedidoDTO = idDetallePedidoDTO;
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

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getSubtotal() {
        return cantidad * precioUnitario;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }
    
    
}
