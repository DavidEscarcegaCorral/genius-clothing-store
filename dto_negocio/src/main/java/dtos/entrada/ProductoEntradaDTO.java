/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos.entrada;

import enumeradores.CategoriaProducto;
import enumeradores.EstadoProducto;
import enumeradores.EtiquetaEstilo;
import enumeradores.EtiquetaGenero;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ProductoEntradaDTO {
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private String rutaImagen;
    private Integer stock;
    private CategoriaProducto categoria;
    private List<String> tallas;
    private EtiquetaGenero genero;
    private List<EtiquetaEstilo> estilos;

    public ProductoEntradaDTO() {
    }

    public ProductoEntradaDTO(
                       String nombre,
                       String descripcion,
                       BigDecimal precio,
                       String rutaImagen,
                       Integer stock,
                       CategoriaProducto categoria,
                       List<String> tallas,
                       EtiquetaGenero genero,
                       List<EtiquetaEstilo> estilos) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.rutaImagen = rutaImagen;
        this.stock = stock;
        this.categoria = categoria;
        this.tallas = tallas;
        this.genero = genero;
        this.estilos = estilos;
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

    public String getPrecioFormateado() {
        return "$" + precio.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
    }
}


