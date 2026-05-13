/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administracion;

import dominio.ProductoEntidad;
import dto_request.ProductoRequestDTO;
import dtos.StockPorTalla;
import enumeradores.CategoriaProducto;
import enumeradores.EstadoProducto;
import enumeradores.EtiquetaEstilo;
import enumeradores.EtiquetaGenero;
import excepcion.NegocioException;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ControlValidarProducto {

    public void validarProducto(ProductoDTO dto) throws NegocioException {
        if (dto == null) {
            throw new NegocioException(
                    "El producto no puede ser nulo"
            );
        }
        validarNombre(dto.getNombre());
        validarDescripcion(dto.getDescripcion());
        validarPrecio(dto.getPrecio());
        validarRutaImagen(dto.getRutaImagen());
        validarInventario(dto.getInventario());
        validarCategoria(dto.getCategoria());
        validarGenero(dto.getGenero());
        validarEstilos(dto.getEstilos());
    }

    public void validarId(String id) throws NegocioException {
        if (id == null || id.trim().isEmpty()) {

            throw new NegocioException(
                    "El id del producto es obligatorio"
            );
        }
    }

    public void validarEstado(EstadoProducto actual,EstadoProducto nuevo) throws NegocioException {
        if (nuevo == null) {
            throw new NegocioException("El estado es obligatorio");
        }
        if (actual == nuevo) {
        throw new NegocioException("El estado nuevo no puede ser igual al actual");
        }
    }



    public void validarExistencia(ProductoResponseDTO dto)throws NegocioException {

        if (dto == null) {
            throw new NegocioException(
                    "El producto no existe"
            );
        }
    }

    public void validarPublicacion(ProductoResponseDTO dto)throws NegocioException {
          validarExistencia(dto);
        if (dto.getEstado() == EstadoProducto.PUBLICADO) {
        throw new NegocioException(
                "El producto ya está publicado"
        );
    }
    }

    private void validarNombre(String nombre) throws NegocioException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new NegocioException(
                    "El nombre es obligatorio"
            );
        }
        if (nombre.length() < 3) {
            throw new NegocioException(
                    "El nombre debe tener mínimo 3 caracteres"
            );
        }
        if (nombre.length() > 100) {
            throw new NegocioException(
                    "El nombre no puede exceder 100 caracteres"
            );
        }
        if (!nombre.matches(".*[a-zA-ZáéíóúÁÉÍÓÚñÑ].*")) {
            throw new NegocioException("El nombre debe contener al menos una letra");
        }
    }

    private void validarDescripcion(String descripcion) throws NegocioException {
        if (descripcion == null ||
                descripcion.trim().isEmpty()) {
            throw new NegocioException(
                    "La descripción es obligatoria"
            );
        }
        if (descripcion.length() < 10) {
            throw new NegocioException(
                    "La descripción debe tener mínimo 10 caracteres"
            );
        }
        if (!descripcion.matches(".*[a-zA-ZáéíóúÁÉÍÓÚñÑ].*")) {
            throw new NegocioException("La descripción debe contener al menos una letra");
        }
    }

    private void validarPrecio(BigDecimal precio) throws NegocioException {
        if (precio == null) {
            throw new NegocioException(
                    "El precio es obligatorio"
            );
        }
        if (precio.compareTo(BigDecimal.ZERO) <= 0) {
            throw new NegocioException(
                    "El precio debe ser mayor a 0"
            );
        }
    }

    private void validarRutaImagen(String rutaImagen) throws NegocioException {
        if (rutaImagen == null ||
                rutaImagen.trim().isEmpty()) {
            throw new NegocioException(
                    "La imagen es obligatoria"
            );
        }
    }

        private void validarInventario(List<StockPorTalla> inventario) throws NegocioException {
    if (inventario == null || inventario.isEmpty()) {
        throw new NegocioException(
                "El inventario es obligatorio"
        );
    }
    boolean existeTallaDisponible = false;
    for (StockPorTalla stock : inventario) {
        if (stock.getTalla() == null ||
                stock.getTalla().trim().isEmpty()) {
            throw new NegocioException(
                    "La talla es obligatoria"
            );
        }
        if (stock.getCantidad() == null ||
                stock.getCantidad() < 0) {
            throw new NegocioException(
                    "La cantidad no puede ser negativa"
            );
        }
        if (stock.getCantidad() > 0) {
            existeTallaDisponible = true;
        }
        }
    if (!existeTallaDisponible) {
        throw new NegocioException(
                "Debe existir al menos una talla con stock"
          );
        }
    }

    private void validarCategoria(CategoriaProducto categoria) throws NegocioException {
        if (categoria == null) {
            throw new NegocioException(
                    "La categoría es obligatoria"
            );
        }
    }

    private void validarGenero(EtiquetaGenero genero) throws NegocioException {
        if (genero == null) {
            throw new NegocioException(
                    "El género es obligatorio"
            );
        }
    }

    private void validarTallas(List<String> tallas) throws NegocioException {
        if (tallas == null || tallas.isEmpty()) {
            throw new NegocioException(
                    "Debe existir al menos una talla"
            );
        }
    }

    private void validarEstilos(List<EtiquetaEstilo> estilos) throws NegocioException {
        if (estilos == null || estilos.isEmpty()) {
            throw new NegocioException(
                    "Debe existir al menos un estilo"
            );
        }
    }
    
}
