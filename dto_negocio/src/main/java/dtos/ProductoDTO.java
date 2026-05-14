/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto_request;

import dtos.StockPorTalla;
import enumeradores.CategoriaProducto;
import enumeradores.EtiquetaEstilo;
import enumeradores.EtiquetaGenero;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ProductoDTO {
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private String rutaImagen;
    private List<StockPorTalla> inventario;
    private CategoriaProducto categoria;
    private List<String> tallas;
    private EtiquetaGenero genero;
    private List<EtiquetaEstilo> estilos;

    public ProductoDTO() {
    }

    public ProductoDTO(
            String nombre,
            String descripcion,
            BigDecimal precio,
            String rutaImagen,
            List<StockPorTalla> inventario,
            CategoriaProducto categoria,
            EtiquetaGenero genero,
            List<EtiquetaEstilo> estilos) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.rutaImagen = rutaImagen;
        this.inventario = inventario;
        this.categoria = categoria;
        this.genero = genero;
        this.estilos = estilos;
    }

    public ProductoDTO(String nombre, String descripcion, BigDecimal precio, String rutaImagen, CategoriaProducto categoria, List<String> tallas, EtiquetaGenero genero, List<EtiquetaEstilo> estilos) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.rutaImagen = rutaImagen;
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
}


