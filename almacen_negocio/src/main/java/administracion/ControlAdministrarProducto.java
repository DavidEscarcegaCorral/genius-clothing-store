/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administracion;

import dto_request.ProductoDTO;
import dto_response.ProductoResponseDTO;
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

    public ProductoResponseDTO agregarProducto(ProductoDTO producto) throws NegocioException {
        if (producto == null) {
            throw new NegocioException("El producto no puede estar vacio");
        }
        try {
            ProductoResponseDTO regresarProducto = bo.agregarProducto(producto);
            return regresarProducto;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al intentar agregar el producto");
        }
    }

    public ProductoResponseDTO editarProducto(String id, EstadoProducto estado) throws NegocioException {
        try {
            ProductoResponseDTO regresarProducto = bo.editarProducto(id, estado);
            return regresarProducto;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al intentar editar el producto");
        }
    }

    public List<ProductoResponseDTO> verProductos() throws NegocioException {
        try {
            List<ProductoResponseDTO> productos = bo.verProductos();
            return productos;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al ver los productos");
        }
    }

    public ProductoResponseDTO publicarProducto(String id) throws NegocioException {
        try {
            ProductoResponseDTO productoPublicado = bo.publicarProducto(id);
            return productoPublicado;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al intentar publicar el producto");
        }

    }
    
    public ProductoResponseDTO buscarPorId(String id) throws NegocioException{
        try{
            ProductoResponseDTO buscar = bo.buscarPorId(id);
            return buscar;
        }catch(PersistenciaException e){
            throw new NegocioException("Error al buscar por id");
        }
    }
}
