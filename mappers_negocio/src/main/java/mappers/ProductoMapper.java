package mappers;

import dominio.ProductoEntidad;
import dtos.ProductoCardDTO;
import dtos.ProductoDTO;

public class ProductoMapper {
    public static ProductoCardDTO entidadADTO(ProductoEntidad entidad) {
        return new ProductoCardDTO(
                entidad.getId().toHexString(),
                entidad.getNombre(),
                entidad.getPrecio(),
                entidad.getGenero(),
                entidad.getRutaImagen()
        );
    }

    public static ProductoDTO entidadADtoCompleto(ProductoEntidad entidad) {
        return new ProductoDTO(
                entidad.getId().toHexString(),
                entidad.getNombre(),
                entidad.getDescrpcionProducto(),
                entidad.getPrecio(),
                entidad.getRutaImagen(),
                entidad.getStock(),
                entidad.getEstado(),
                entidad.getCategoria(),
                entidad.getTallasDisponibles(),
                entidad.getGenero(),
                entidad.getEstilos()
        );
    }
}
