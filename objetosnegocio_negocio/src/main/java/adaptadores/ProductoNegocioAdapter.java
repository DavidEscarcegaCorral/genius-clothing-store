/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adaptadores;

import dominio.ProductoEntidad;
import dto_request.ProductoRequestDTO;
import dto_response.ProductoSalidaDTO;
import enumeradores.EstadoProducto;

import java.util.ArrayList;
import java.util.List;

/**
 * Adapter encargado de convertir DTOs de entrada
 * a entidades de dominio y entidades a DTOs de salida.
 */
public class ProductoNegocioAdapter {

    /**
     * Convierte un ProductoEntradaDTO a ProductoEntidad
     */
    public ProductoEntidad convertirEntradaAEntidad(
            ProductoRequestDTO productoDTO) {

        if (productoDTO == null) {
            return null;
        }

        ProductoEntidad producto = new ProductoEntidad();

        producto.setNombre(productoDTO.getNombre());
        producto.setDescrpcionProducto(productoDTO.getDescripcion());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setRutaImagen(productoDTO.getRutaImagen());
        producto.setStock(productoDTO.getStock());

        // Estado inicial por defecto
        producto.setEstado(EstadoProducto.BORRADOR);

        producto.setCategoria(productoDTO.getCategoria());
        producto.setTallasDisponibles(productoDTO.getTallas());
        producto.setGenero(productoDTO.getGenero());
        producto.setEstilos(productoDTO.getEstilos());

        return producto;
    }

    /**
     * Convierte una entidad a DTO de salida
     */
    public ProductoSalidaDTO convertirEntidadASalida(
            ProductoEntidad producto) {

        if (producto == null) {
            return null;
        }

        return new ProductoSalidaDTO(
                producto.getId(),
                producto.getNombre(),
                producto.getDescrpcionProducto(),
                producto.getPrecio(),
                producto.getRutaImagen(),
                producto.getStock(),
                producto.getEstado(),
                producto.getCategoria(),
                producto.getTallasDisponibles(),
                producto.getGenero(),
                producto.getEstilos()
        );
    }

    /**
     * Convierte lista de entidades a lista de DTOs de salida
     */
    public List<ProductoSalidaDTO> convertirEntidadesASalidas(
            List<ProductoEntidad> productos) {

        List<ProductoSalidaDTO> productosDTO = new ArrayList<>();

        if (productos == null) {
            return productosDTO;
        }

        for (ProductoEntidad producto : productos) {

            ProductoSalidaDTO productoDTO =
                    convertirEntidadASalida(producto);

            if (productoDTO != null) {
                productosDTO.add(productoDTO);
            }
        }

        return productosDTO;
    }
}
