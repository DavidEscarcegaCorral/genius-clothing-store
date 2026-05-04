package dominio;

import enumeradores.CategoriaProdcuto;
import enumeradores.EstadoProducto;
import enumeradores.EtiquetaEstilo;
import enumeradores.EtiquetaGenero;
import org.bson.types.ObjectId;

import java.math.BigDecimal;
import java.util.List;

public class ProductoEntidad {
    private ObjectId id;
    private String nombre;
    private String descrpcionProducto;
    private BigDecimal precio;
    private String rutaImagen;
    private Integer stock;
    private EstadoProducto estado;
    private CategoriaProdcuto categoria;
    private List<String> tallasDisponibles;
    private EtiquetaGenero genero;
    private List<EtiquetaEstilo> estilos;

    public ProductoEntidad() {

    }

    public ProductoEntidad(ObjectId id, String nombre, String descrpcionProducto,
                           BigDecimal precio, String rutaImagen, Integer stock,
                           EstadoProducto estado, CategoriaProdcuto categoria,
                           List<String> tallasDisponibles, EtiquetaGenero genero,
                           List<EtiquetaEstilo> estilos) {
        this.id = id;
        this.nombre = nombre;
        this.descrpcionProducto = descrpcionProducto;
        this.precio = precio;
        this.rutaImagen = rutaImagen;
        this.stock = stock;
        this.estado = estado;
        this.categoria = categoria;
        this.tallasDisponibles = tallasDisponibles;
        this.genero = genero;
        this.estilos = estilos;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
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

    public CategoriaProdcuto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProdcuto categoria) {
        this.categoria = categoria;
    }

    public List<String> getTallasDisponibles() {
        return tallasDisponibles;
    }

    public void setTallasDisponibles(List<String> tallasDisponibles) {
        this.tallasDisponibles = tallasDisponibles;
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

    

