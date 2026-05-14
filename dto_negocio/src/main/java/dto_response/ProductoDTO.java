package dto_response;

import dtos.StockPorTalla;
import enumeradores.CategoriaProducto;
import enumeradores.EstadoProducto;
import enumeradores.EtiquetaEstilo;
import enumeradores.EtiquetaGenero;

import java.math.BigDecimal;
import java.util.List;

public class ProductoDTO {
    private String id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private String rutaImagen;
    private List<StockPorTalla> inventario;
    private EstadoProducto estado;
    private CategoriaProducto categoria;
    private List<String> tallas;
    private EtiquetaGenero genero;
    private List<EtiquetaEstilo> estilos;
    private Integer cantidad;

    public ProductoDTO() {
    }

    public ProductoDTO(String id,
                       String nombre,
                       String descripcion,
                       BigDecimal precio,
                       String rutaImagen,
                       List<StockPorTalla> inventario,
                       EstadoProducto estado,
                       CategoriaProducto categoria,
                       List<String> tallas,
                       EtiquetaGenero genero,
                       List<EtiquetaEstilo> estilos) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.rutaImagen = rutaImagen;
        this.inventario = inventario;
        this.estado = estado;
        this.categoria = categoria;
        this.tallas = tallas;
        this.genero = genero;
        this.estilos = estilos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public List<StockPorTalla> getInventario() {
        return inventario;
    }

    public void setInventario(List<StockPorTalla> inventario) {
        this.inventario = inventario;
    }

    public Integer getStockTotal() {
        if (inventario == null) return 0;
        return inventario.stream()
                .mapToInt(s -> s.getCantidad() != null ? s.getCantidad() : 0)
                .sum();
    }

    public EstadoProducto getEstado() {
        return estado;
    }

    public void setEstado(EstadoProducto estado) {
        this.estado = estado;
    }

    public CategoriaProducto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProducto categoria) {
        this.categoria = categoria;
    }

    public List<String> getTallas() {
        return tallas;
    }

    public void setTallas(List<String> tallas) {
        this.tallas = tallas;
    }

    public EtiquetaGenero getGenero() {
        return genero;
    }

    public void setGenero(EtiquetaGenero genero) {
        this.genero = genero;
    }

    public List<EtiquetaEstilo> getEstilos() {
        return estilos;
    }

    public void setEstilos(List<EtiquetaEstilo> estilos) {
        this.estilos = estilos;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
