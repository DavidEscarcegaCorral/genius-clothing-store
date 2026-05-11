/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administracion;

import dto_request.ProductoRequestDTO;
import dto_response.ProductoResponseDTO;
import enumeradores.EstadoProducto;
import excepcion.NegocioException;

import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IAdministracionFacade {
    public List<ProductoResponseDTO> obtenerProductos() throws NegocioException;

    public ProductoResponseDTO agregarProducto(ProductoRequestDTO producto) throws NegocioException;

    public ProductoResponseDTO publicarProducto(String id) throws NegocioException;

    public ProductoResponseDTO actualizarProducto(String id, EstadoProducto estado) throws NegocioException;
}
