package dtos;

import dto_response.ProductoResponseDTO;

public class DetallePedidoDTO {

    private Integer idDetallePedido;
    private ProductoResponseDTO producto;
    private Integer cantidad;
    private Double precioUnitario;
    private Double subtotal;
    private Double descuento;

    public DetallePedidoDTO() {
    }

    public DetallePedidoDTO(Integer idDetallePedido, ProductoResponseDTO producto, Integer cantidad, Double precioUnitario, Double subtotal, Double descuento) {
        this.idDetallePedido = idDetallePedido;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
        this.descuento = descuento;
    }

    public DetallePedidoDTO(ProductoResponseDTO producto, Integer cantidad, Double precioUnitario, Double subtotal, Double descuento) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
        this.descuento = descuento;
    }


    public Integer getIdDetallePedido() {
        return idDetallePedido;
    }

    public void setIdDetallePedido(Integer idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
    }

    public ProductoResponseDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoResponseDTO producto) {
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
        return subtotal;
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
