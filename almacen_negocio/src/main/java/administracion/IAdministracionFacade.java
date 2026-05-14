/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administracion;

import dto_response.ProductoDTO;
import enumeradores.EstadoProducto;
import excepcion.NegocioException;

import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IAdministracionFacade {
    public List<ProductoDTO> obtenerProductos() throws NegocioException;

    public ProductoDTO agregarProducto(dto_response.ProductoDTO producto) throws NegocioException;

    public ProductoDTO publicarProducto(String id) throws NegocioException;

    public ProductoDTO actualizarProducto(String id, EstadoProducto estado) throws NegocioException;
}
