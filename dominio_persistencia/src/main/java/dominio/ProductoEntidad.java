package dominio;

import enumeradores.CategoriaProducto;
import enumeradores.EstadoProducto;
import enumeradores.EtiquetaEstilo;
import enumeradores.EtiquetaGenero;

import java.math.BigDecimal;
import java.util.List;

public class ProductoEntidad {
    private String id;
    private String nombre;
    private String descrpcionProducto;
    private BigDecimal precio;
    private String rutaImagen;
    private List<StockPorTalla> inventario;
    private EstadoProducto estado;
    private CategoriaProducto categoria;
    private List<String> tallasDisponibles;
    private EtiquetaGenero genero;
    private List<EtiquetaEstilo> estilos;

    public ProductoEntidad() {

    }

    public ProductoEntidad(String id, String nombre, String descrpcionProducto,
                           BigDecimal precio, String rutaImagen, List<StockPorTalla> inventario,
                           EstadoProducto estado, CategoriaProducto categoria,
                           List<String> tallasDisponibles, EtiquetaGenero genero,
                           List<EtiquetaEstilo> estilos) {
        this.id = id;
        this.nombre = nombre;
        this.descrpcionProducto = descrpcionProducto;
        this.precio = precio;
        this.rutaImagen = rutaImagen;
        this.inventario = inventario;
        this.estado = estado;
        this.categoria = categoria;
        this.tallasDisponibles = tallasDisponibles;
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

    

