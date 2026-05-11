package mappers;

import dominio.ProductoEntidad;
import dto_response.ProductoSalidaDTO;
import dtos.ProductoCardDTO;

public class ProductoMapper {
    public static ProductoCardDTO entidadADTO(ProductoEntidad entidad) {
        return new ProductoCardDTO(
                entidad.getId(),
                entidad.getNombre(),
                entidad.getPrecio(),
                entidad.getGenero(),
                entidad.getRutaImagen()
        );
    }

    public static ProductoSalidaDTO entidadADtoCompleto(ProductoEntidad entidad) {
        return new ProductoSalidaDTO(
                entidad.getId(),
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
