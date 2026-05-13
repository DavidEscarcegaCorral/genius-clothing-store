package dtos;

import dto_response.ProductoResponseDTO;

import java.util.ArrayList;
import java.util.List;

public class CarritoDTO {

    private Integer idCarrito;
    private List<ProductoResponseDTO> productos;
    private Integer cantidadTotal;

    public CarritoDTO(Integer idCarrito, List<ProductoResponseDTO> productos, Integer cantidadTotal) {
        this.idCarrito = idCarrito;
        this.productos = productos;
        this.cantidadTotal = cantidadTotal;
    }

    public CarritoDTO(List<ProductoResponseDTO> productos, Integer cantidadTotal) {
        this.productos = productos;
        this.cantidadTotal = cantidadTotal;
    }

    public CarritoDTO() {
        this.productos = new ArrayList<>();
    }

    public List<ProductoResponseDTO> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoResponseDTO> productos) {
        this.productos = productos;
    }

    public Integer getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(Integer cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

    public Integer getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(Integer idCarrito) {
        this.idCarrito = idCarrito;
    }

    public void agregarProducto(ProductoResponseDTO producto) {
        if (this.productos == null) {
            this.productos = new ArrayList<>();
        }
        this.productos.add(producto);
    }
}