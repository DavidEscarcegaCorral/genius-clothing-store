/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administracion;

import dto_response.ProductoDTO;
import enumeradores.EstadoProducto;
import excepcion.NegocioException;
import excepciones.PersistenciaException;
import objetosnegocio.ProductoBO;

import java.util.List;

/**
 *
 * @author Usuario
 */
public class ControlAdministrarProducto {

    private static ControlAdministrarProducto instancia;
    private ProductoBO bo;

    private ControlAdministrarProducto() {
        this.bo = new ProductoBO();
    }

    public static ControlAdministrarProducto getInstance() {
        if (instancia == null) {
            instancia = new ControlAdministrarProducto();
        }
        return instancia;
    }

    public ProductoDTO agregarProducto(dto_response.ProductoDTO producto) throws NegocioException {
        if (producto == null) {
            throw new NegocioException("El producto no puede estar vacio");
        }
        try {
            ProductoDTO regresarProducto = bo.agregarProducto(producto);
            return regresarProducto;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al intentar agregar el producto");
        }
    }

    public ProductoDTO editarProducto(String id, EstadoProducto estado) throws NegocioException {
        try {
            ProductoDTO regresarProducto = bo.editarProducto(id, estado);
            return regresarProducto;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al intentar editar el producto");
        }
    }

    public List<ProductoDTO> verProductos() throws NegocioException {
        try {
            List<ProductoDTO> productos = bo.verProductos();
            return productos;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al ver los productos");
        }
    }

    public ProductoDTO publicarProducto(String id) throws NegocioException {
        try {
            ProductoDTO productoPublicado = bo.publicarProducto(id);
            return productoPublicado;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al intentar publicar el producto");
        }

    }

    public ProductoDTO buscarPorId(String id) throws NegocioException {
        try {
            ProductoDTO buscar = bo.buscarPorId(id);
            return buscar;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al buscar por id");
        }
    }
}
