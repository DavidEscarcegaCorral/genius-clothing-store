/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administracion;

import dtos.entrada.ProductoEntradaDTO;
import dtos.salida.ProductoSalidaDTO;
import enumeradores.EstadoProducto;
import excepcion.NegocioException;

import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IAdministracionFacade {
    public List<ProductoSalidaDTO> obtenerProductos() throws NegocioException;

    public ProductoSalidaDTO agregarProducto(ProductoEntradaDTO producto) throws NegocioException;

    public ProductoSalidaDTO publicarProducto(String id) throws NegocioException;

    public ProductoSalidaDTO actualizarProducto(String id, EstadoProducto estado) throws NegocioException;
}
