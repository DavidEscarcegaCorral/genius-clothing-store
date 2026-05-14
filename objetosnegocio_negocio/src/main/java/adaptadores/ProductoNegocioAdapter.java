/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adaptadores;

import dominio.ProductoEntidad;
import dto_response.ProductoDTO;
import enumeradores.EstadoProducto;

import java.util.ArrayList;
import java.util.List;

/**
 * Adapter encargado de convertir DTOs de entrada
 * a entidades de dominio y entidades a DTOs de salida.
 */
public class ProductoNegocioAdapter {

    public ProductoEntidad convertirEntradaAEntidad(
            dto_response.ProductoDTO productoDTO) {

        if (productoDTO == null) {
            return null;
        }

        ProductoEntidad producto = new ProductoEntidad();

        producto.setNombre(productoDTO.getNombre());
        producto.setDescrpcionProducto(productoDTO.getDescripcion());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setRutaImagen(productoDTO.getRutaImagen());
        producto.setInventario(convertirInventarioDtoADominio(productoDTO.getInventario()));

        producto.setEstado(EstadoProducto.BORRADOR);

        producto.setCategoria(productoDTO.getCategoria());
        producto.setTallasDisponibles(productoDTO.getTallas());
        producto.setGenero(productoDTO.getGenero());
        producto.setEstilos(productoDTO.getEstilos());

        return producto;
    }

    public ProductoDTO convertirEntidadASalida(
            ProductoEntidad producto) {

        if (producto == null) {
            return null;
        }

        return new ProductoDTO(
                producto.getId(),
                producto.getNombre(),
                producto.getDescrpcionProducto(),
                producto.getPrecio(),
                producto.getRutaImagen(),
                convertirInventarioDominioADto(producto.getInventario()),
                producto.getEstado(),
                producto.getCategoria(),
                producto.getTallasDisponibles(),
                producto.getGenero(),
                producto.getEstilos()
        );
    }

    public List<ProductoDTO> convertirEntidadesASalidas(
            List<ProductoEntidad> productos) {

        List<ProductoDTO> productosDTO = new ArrayList<>();

        if (productos == null) {
            return productosDTO;
        }

        for (ProductoEntidad producto : productos) {

            ProductoDTO productoDTO =
                    convertirEntidadASalida(producto);

            if (productoDTO != null) {
                productosDTO.add(productoDTO);
            }
        }

        return productosDTO;
    }

    private List<dominio.StockPorTalla> convertirInventarioDtoADominio(List<dtos.StockPorTalla> inventarioDto) {
        if (inventarioDto == null) return new ArrayList<>();
        List<dominio.StockPorTalla> inventarioDominio = new ArrayList<>();
        for (dtos.StockPorTalla item : inventarioDto) {
            inventarioDominio.add(new dominio.StockPorTalla(item.getTalla(), item.getCantidad()));
        }
        return inventarioDominio;
    }

    private List<dtos.StockPorTalla> convertirInventarioDominioADto(List<dominio.StockPorTalla> inventarioDominio) {
        if (inventarioDominio == null) return new ArrayList<>();
        List<dtos.StockPorTalla> inventarioDto = new ArrayList<>();
        for (dominio.StockPorTalla item : inventarioDominio) {
            inventarioDto.add(new dtos.StockPorTalla(item.getTalla(), item.getCantidad()));
        }
        return inventarioDto;
    }
}
