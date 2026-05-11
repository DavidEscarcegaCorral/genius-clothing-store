/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosnegocio;

import dominio.ProductoEntidad;
import dtos.entrada.ProductoEntradaDTO;
import dtos.salida.ProductoSalidaDTO;
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
public class ProductoBO {
    
        public void validarProducto(ProductoEntradaDTO dto)
            throws NegocioException {
        if (dto == null) {
            throw new NegocioException(
                    "El producto no puede ser nulo"
            );
        }
        validarNombre(dto.getNombre());
        validarDescripcion(dto.getDescripcion());
        validarPrecio(dto.getPrecio());
        validarRutaImagen(dto.getRutaImagen());
        validarStock(dto.getStock());
        validarCategoria(dto.getCategoria());
        validarGenero(dto.getGenero());
        validarTallas(dto.getTallas());
        validarEstilos(dto.getEstilos());
    }

    public void validarId(String id)throws NegocioException {
        if (id == null || id.trim().isEmpty()) {

            throw new NegocioException(
                    "El id del producto es obligatorio"
            );
        }
    }

    public void validarEstado(EstadoProducto estado)throws NegocioException {
        if (estado == null) {
            throw new NegocioException(
                    "El estado es obligatorio"
            );
        }
    }

    public void validarExistencia(ProductoEntidad entidad)throws NegocioException {
        if (entidad == null) {
            throw new NegocioException(
                    "El producto no existe"
            );
        }
    }

    public void validarPublicacion(ProductoEntidad entidad)throws NegocioException {
        validarExistencia(entidad);
        if (entidad.getEstado() == EstadoProducto.PUBLICADO) {
            throw new NegocioException(
                    "El producto ya está publicado"
            );
        }
    }

    private void validarNombre(String nombre)throws NegocioException {
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

    private void validarDescripcion(String descripcion)throws NegocioException {
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

    private void validarPrecio(BigDecimal precio)throws NegocioException {
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

    private void validarRutaImagen(String rutaImagen)throws NegocioException {
        if (rutaImagen == null ||
                rutaImagen.trim().isEmpty()) {
            throw new NegocioException(
                    "La imagen es obligatoria"
            );
        }
    }

    private void validarStock(Integer stock)throws NegocioException {
        if (stock == null) {
            throw new NegocioException(
                    "El stock es obligatorio"
            );
        }
        if (stock < 0) {
            throw new NegocioException(
                    "El stock no puede ser negativo"
            );
        }
    }

    private void validarCategoria(CategoriaProducto categoria)throws NegocioException {
        if (categoria == null) {
            throw new NegocioException(
                    "La categoría es obligatoria"
            );
        }
    }

    private void validarGenero(EtiquetaGenero genero)throws NegocioException {
        if (genero == null) {
            throw new NegocioException(
                    "El género es obligatorio"
            );
        }
    }

    private void validarTallas(List<String> tallas)throws NegocioException {
        if (tallas == null || tallas.isEmpty()) {
            throw new NegocioException(
                    "Debe existir al menos una talla"
            );
        }
    }

    private void validarEstilos(List<EtiquetaEstilo> estilos)throws NegocioException {
        if (estilos == null || estilos.isEmpty()) {
            throw new NegocioException(
                    "Debe existir al menos un estilo"
            );
        }
    }
}
