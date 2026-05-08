/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administracion;

import dtos.ProductoDTO;
import enumeradores.EstadoProducto;

import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IAdministracionFacade {
    public List<ProductoDTO> obtenerProductos();

    public ProductoDTO agregarProducto(ProductoDTO producto);

    public ProductoDTO publicarProducto(String id);

    public ProductoDTO actualizarProducto(String id, EstadoProducto estado);
}
