package dtos;

import dto_response.ProductoResponseDTO;

/**
 *
 * @author Usuario
 */
public class CarritoDTO {

    private Integer idCarritoDTO;
    private ProductoResponseDTO producto;
    private Integer cantidad;

    public CarritoDTO(Integer idCarritoDTO, ProductoResponseDTO producto, Integer cantidad) {
        this.idCarritoDTO = idCarritoDTO;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public CarritoDTO(ProductoResponseDTO producto, Integer cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public CarritoDTO() {
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

    public Integer getIdCarritoDTO() {
        return idCarritoDTO;
    }

    public void setIdCarritoDTO(Integer idCarrito) {
        this.idCarritoDTO = idCarrito;
    }


}
