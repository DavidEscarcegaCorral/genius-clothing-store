/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dtos.ProductoDTO;
import enumeradores.EstadoProducto;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IProductoDAO {
    
    public ProductoDTO agregarProducto(ProductoDTO producto);
    public ProductoDTO cambiarEstado(String id,EstadoProducto estado);
    public ProductoDTO publicarProducto(String id);
    public ProductoDTO buscarPorId(String id);
    public List<ProductoDTO> obtenerProductos();
}
