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

}
