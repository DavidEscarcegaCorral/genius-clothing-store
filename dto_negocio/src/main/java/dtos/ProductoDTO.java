package dtos;

import enumeradores.*;

import java.math.BigDecimal;
import java.util.List;

public class ProductoDTO {
    private String id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private String rutaImagen;
    private Integer stock;
    private EstadoProducto estado;
    private CategoriaProducto categoria;
    private List<TallasCalzado> tallas;
    private EtiquetaGenero genero;
    private List<EtiquetaEstilo> estilos;

    public ProductoDTO() {
    }

    public ProductoDTO(String id,
                       String nombre,
                       String descripcion,
                       BigDecimal precio,
                       String rutaImagen,
                       Integer stock,
                       EstadoProducto estado,
                       CategoriaProducto categoria,
                       List<TallasCalzado> tallas,
                       EtiquetaGenero genero,
                       List<EtiquetaEstilo> estilos) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.rutaImagen = rutaImagen;
        this.stock = stock;
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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
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

    public List<TallasCalzado> getTallas() {
        return tallas;
    }

    public void setTallas(List<TallasCalzado> tallas) {
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

    public String getPrecioFormateado() {
        return "$" + precio.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
    }
}
