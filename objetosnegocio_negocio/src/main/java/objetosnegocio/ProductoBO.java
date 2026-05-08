/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosnegocio;

import dtos.ProductoDTO;
import enumeradores.EstadoProducto;
import java.math.BigDecimal;

/**
 *
 * @author Usuario
 */
public class ProductoBO {
    
     public void validarProducto(ProductoDTO dto) {

        if (dto == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }

        // Nombre
        if (dto.getNombre() == null || dto.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }

        if (dto.getNombre().length() > 100) {
            throw new IllegalArgumentException("El nombre no puede exceder 100 caracteres");
        }

        // Descripción
        if (dto.getDescripcion() == null || dto.getDescripcion().trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción es obligatoria");
        }

        // Precio
        if (dto.getPrecio() == null) {
            throw new IllegalArgumentException("El precio es obligatorio");
        }

        if (dto.getPrecio().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0");
        }

        // Stock
        if (dto.getStock() == null) {
            throw new IllegalArgumentException("El stock es obligatorio");
        }

        if (dto.getStock() < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }

        // Estado
        if (dto.getEstado() == null) {
            throw new IllegalArgumentException("El estado es obligatorio");
        }

        // Categoría
        if (dto.getCategoria() == null) {
            throw new IllegalArgumentException("La categoría es obligatoria");
        }

        // Género
        if (dto.getGenero() == null) {
            throw new IllegalArgumentException("El género es obligatorio");
        }

        // Tallas
        if (dto.getTallas() == null || dto.getTallas().isEmpty()) {
            throw new IllegalArgumentException("Debe tener al menos una talla");
        }

        // Imagen
        if (dto.getRutaImagen() == null || dto.getRutaImagen().trim().isEmpty()) {
            throw new IllegalArgumentException("La imagen es obligatoria");
        }
    }
     
    public void validarPublicacion(ProductoDTO p) {
    if (p.getEstado() == EstadoProducto.PUBLICADO) {
        throw new IllegalArgumentException("El producto ya está publicado");
    }
  }
    
    public void validarEstado(EstadoProducto estado) {
    if (estado == null) {
        throw new IllegalArgumentException("Estado inválido");
    }
}
    
}
