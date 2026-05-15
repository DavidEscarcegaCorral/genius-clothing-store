package dtos;

import dto_response.ProductoDTO;

import java.util.ArrayList;
import java.util.List;

public class CarritoDTO {

    private Integer idCarrito;
    private List<ProductoDTO> productos;
    private Integer cantidadTotal;

    public CarritoDTO(Integer idCarrito, List<ProductoDTO> productos, Integer cantidadTotal) {
        this.idCarrito = idCarrito;
        this.productos = productos;
        this.cantidadTotal = cantidadTotal;
    }

    public CarritoDTO(List<ProductoDTO> productos, Integer cantidadTotal) {
        this.productos = productos;
        this.cantidadTotal = cantidadTotal;
    }

    public CarritoDTO() {
        this.productos = new ArrayList<>();
    }

    public List<ProductoDTO> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoDTO> productos) {
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

    public void agregarProducto(ProductoDTO producto) {
        if (this.productos == null) {
            this.productos = new ArrayList<>();
        }
        this.productos.add(producto);
    }
}