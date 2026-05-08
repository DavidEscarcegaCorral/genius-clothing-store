/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidadesmongo;

import enumeradores.CategoriaProducto;
import enumeradores.EstadoProducto;
import enumeradores.EtiquetaEstilo;
import enumeradores.EtiquetaGenero;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

/**
 *
 * @author Usuario
 */
public class ProductoMongoEntidad {
    
    @BsonId
    private ObjectId id;

    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private String rutaImagen;
    private Integer stock;
    private EstadoProducto estado;
    private CategoriaProducto categoria;
    private List<String> tallas;
    private EtiquetaGenero genero;
    private List<EtiquetaEstilo> estilos;

    //para evitar errores y que se cree vacia 
    public ProductoMongoEntidad() {
        this.tallas = new ArrayList<>();
        this.estilos = new ArrayList<>();
    }

    public ProductoMongoEntidad(String nombre, String descripcion,
            BigDecimal precio, String rutaImagen, Integer stock,
            EstadoProducto estado, CategoriaProducto categoria,
            List<String> tallas, EtiquetaGenero genero,
            List<EtiquetaEstilo> estilos) {

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

    public ProductoMongoEntidad(ObjectId id, String nombre,
            String descripcion, BigDecimal precio,
            String rutaImagen, Integer stock,
            EstadoProducto estado, CategoriaProducto categoria,
            List<String> tallas, EtiquetaGenero genero,
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

    public ObjectId getId() {
        return id;
    }

    /**
     * Permite asignar el identificador principal del documento.
     *
     * Este atributo corresponde al campo _id en MongoDB.
     *
     * @param id identificador ObjectId del producto.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Convierte el ObjectId a texto.
     *
     * Método de apoyo para adapters y persistencia.
     *
     * @return id como texto o null.
     */
    public String getIdComoTexto() {

        if (id == null) {
            return null;
        }

        return id.toHexString();
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

    @Override
    public String toString() {
        return "ProductoMongoEntidad{"
                + "id=" + getIdComoTexto()
                + ", nombre='" + nombre + '\''
                + ", descripcion='" + descripcion + '\''
                + ", precio=" + precio
                + ", rutaImagen='" + rutaImagen + '\''
                + ", stock=" + stock
                + ", estado=" + estado
                + ", categoria=" + categoria
                + ", tallas=" + tallas
                + ", genero=" + genero
                + ", estilos=" + estilos
                + '}';
    }
}
    

