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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class ControlAdministrarProducto {

    private static ControlAdministrarProducto instancia;
    private ProductoBO bo;
    private static final Logger LOG = Logger.getLogger(ControlAdministrarProducto.class.getName());

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
            ProductoResponseDTO regresarProducto = bo.agregarProducto(producto);
            LOG.log(Level.INFO,"Producto agregado correctamente");
            ProductoDTO regresarProducto = bo.agregarProducto(producto);
            return regresarProducto;
        } catch (PersistenciaException ex) {
            LOG.log(Level.SEVERE,"Error al intentar agregar el producto");
            throw new NegocioException("Error al intentar agregar el producto");
        }
    }

    public ProductoDTO editarProducto(String id, EstadoProducto estado) throws NegocioException {
        try {
            ProductoResponseDTO regresarProducto = bo.editarProducto(id, estado);
            LOG.log(Level.INFO,"Producto editado correctamente");
             return regresarProducto;
            ProductoDTO regresarProducto = bo.editarProducto(id, estado);
            return regresarProducto;
        } catch (PersistenciaException ex) {
            LOG.log(Level.SEVERE,"Error al intentar editar el producto");
            throw new NegocioException("Error al intentar editar el producto");
        }
    }

    public List<ProductoDTO> verProductos() throws NegocioException {
        try {
            List<ProductoResponseDTO> productos =bo.verProductos();
            LOG.log(Level.INFO,"Productos cargados correctamente");
            List<ProductoDTO> productos = bo.verProductos();
            return productos;
        } catch (PersistenciaException ex) {
            LOG.log(Level.SEVERE,"Error al intentar cargar los productos");
            throw new NegocioException("Error al ver los productos");
        }
    }

    public ProductoDTO publicarProducto(String id) throws NegocioException {
        try {
            ProductoResponseDTO productoPublicado = bo.publicarProducto(id);
            LOG.log(Level.INFO,"Producto publicado correctamente");
            ProductoDTO productoPublicado = bo.publicarProducto(id);
            return productoPublicado;
        } catch (PersistenciaException ex) {
            LOG.log(Level.SEVERE,"Error al intentar publicar el producto");
            throw new NegocioException("Error al intentar publicar el producto");
        }  
    }
    
    public ProductoResponseDTO buscarPorId(String id) throws NegocioException{
        try{
            ProductoResponseDTO buscar = bo.buscarPorId(id);
            LOG.log(Level.INFO,"Producto encontrado correctamente");
            return buscar;
        }catch(PersistenciaException e){
            LOG.log(Level.SEVERE,"Error al intentar buscar el producto por id");
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
