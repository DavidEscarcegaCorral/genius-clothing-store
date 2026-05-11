package mappers;
import dominio.CarritoEntidad;
import dominio.ItemCarrito;
import dtos.CarritoDTO;
import dto_response.ProductoResponseDTO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
/**
 * Mapper para convertir CarritoEntidad a CarritoDTO y viceversa
 */
public class CarritoMapper {
    /**
     * Convierte CarritoEntidad a CarritoDTO completo
     */
    public static CarritoDTO entidadADTOCompleto(CarritoEntidad carrito) {
        if (carrito == null) {
            return new CarritoDTO();
        }
        CarritoDTO dto = new CarritoDTO();
        List<ProductoResponseDTO> productos = new ArrayList<>();
        if (carrito.getItems() != null && !carrito.getItems().isEmpty()) {
            for (ItemCarrito item : carrito.getItems()) {
                ProductoResponseDTO productoDTO = new ProductoResponseDTO();
                productoDTO.setId(item.getProductoId());
                productoDTO.setNombre(item.getNombre());
                productoDTO.setPrecio(item.getPrecio());
                productoDTO.setRutaImagen(item.getRutaImagen());
                if (item.getTallaSeleccionada() != null) {
                    productoDTO.setTallas(new ArrayList<>(List.of(item.getTallaSeleccionada())));
                }
                productos.add(productoDTO);
            }
        }
        dto.setProductos(productos);
        dto.setCantidadTotal(productos.size());
        return dto;
    }
    /**
     * Obtiene la cantidad total de items en el carrito (sumando cantidades)
     */
    public static Integer obtenerCantidadTotal(CarritoEntidad carrito) {
        if (carrito == null || carrito.getItems() == null) {
            return 0;
        }
        return carrito.getItems().stream()
                .mapToInt(item -> item.getCantidad() != null ? item.getCantidad() : 1)
                .sum();
    }
    /**
     * Obtiene el subtotal del carrito (suma de precio * cantidad)
     */
    public static BigDecimal obtenerSubtotal(CarritoEntidad carrito) {
        if (carrito == null || carrito.getItems() == null) {
            return BigDecimal.ZERO;
        }
        return carrito.getItems().stream()
                .map(item -> {
                    BigDecimal cantidad = BigDecimal.valueOf(
                            item.getCantidad() != null ? item.getCantidad() : 1
                    );
                    return item.getPrecio() != null ? item.getPrecio().multiply(cantidad) : BigDecimal.ZERO;
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    /**
     * Obtiene la cantidad de productos diferentes en el carrito
     */
    public static Integer obtenerCantidadProductosDiferentes(CarritoEntidad carrito) {
        if (carrito == null || carrito.getItems() == null) {
            return 0;
        }
        return carrito.getItems().size();
    }
}