/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import enumeradores.EstadoProducto;
import java.math.BigDecimal;
import org.bson.types.ObjectId;

/**
 *
 * @author Usuario
 */
public class ProductoEntidad {
    
    private ObjectId id;
    private String nombre;
    private String descrpcionProducto;
    //Posible enum de Tallas
    private BigDecimal precio;
    private String rutaImagen;
    private Integer stock;
    private EstadoProducto estado;

    public ProductoEntidad(){

    }

    public ProductoEntidad(ObjectId id, String nombre, String descrpcionProducto, BigDecimal precio, String rutaImagen, EstadoProducto estado) {
        this.id = id;
        this.nombre = nombre;
        this.descrpcionProducto = descrpcionProducto;
        this.precio = precio;
        this.rutaImagen = rutaImagen;
        this.estado = estado;
    }

    public ProductoEntidad(ObjectId id, String nombre, String descrpcionProducto, BigDecimal precio, String rutaImagen, Integer stock, EstadoProducto estado) {
        this.id = id;
        this.nombre = nombre;
        this.descrpcionProducto = descrpcionProducto;
        this.precio = precio;
        this.rutaImagen = rutaImagen;
        this.stock = stock;
        this.estado = estado;
    }
    public EstadoProducto getEstado() {
        return estado;
    }

    public void setEstado(EstadoProducto estado) {
        this.estado = estado;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescrpcionProducto() {
        return descrpcionProducto;
    }

    public void setDescrpcionProducto(String descrpcionProducto) {
        this.descrpcionProducto = descrpcionProducto;
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
}

    

