package mappers;

import dominio.ProductoEntidad;
import dto_response.ProductoResponseDTO;
import dtos.ProductoCardDTO;
import dtos.StockPorTalla;

import java.util.ArrayList;
import java.util.List;

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

    public static ProductoResponseDTO entidadADtoCompleto(ProductoEntidad entidad) {
        return new ProductoResponseDTO(
                entidad.getId(),
                entidad.getNombre(),
                entidad.getDescrpcionProducto(),
                entidad.getPrecio(),
                entidad.getRutaImagen(),
                convertirInventario(entidad.getInventario()),
                entidad.getEstado(),
                entidad.getCategoria(),
                entidad.getTallasDisponibles(),
                entidad.getGenero(),
                entidad.getEstilos()
        );
    }

    private static List<StockPorTalla> convertirInventario(List<dominio.StockPorTalla> inventarioDominio) {
        if (inventarioDominio == null) return new ArrayList<>();
        List<StockPorTalla> inventarioDto = new ArrayList<>();
        for (dominio.StockPorTalla item : inventarioDominio) {
            inventarioDto.add(new StockPorTalla(item.getTalla(), item.getCantidad()));
        }
        return inventarioDto;
    }
}
