/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administracion;

import adaptadores.ProductoNegocioAdapter;
import dao.IProductoDAO;
import dao.ProductoDAO;
import dominio.ProductoEntidad;
import dto_request.ProductoRequestDTO;
import dto_response.ProductoResponseDTO;
import enumeradores.EstadoProducto;
import excepcion.NegocioException;
import excepciones.PersistenciaException;
import objetosnegocio.ProductoBO;
import repository.ProductosRepository;

import java.util.List;

/**
 *
 * @author Usuario
 */
public class AdministracionFacade implements IAdministracionFacade {
    private ProductosRepository repository;
    private final ProductoBO bo;
    private final ProductoNegocioAdapter productoAdapter;
    private final IProductoDAO productoDAO;

    public AdministracionFacade() {
        this.productoAdapter = new ProductoNegocioAdapter();
        this.productoDAO = new ProductoDAO();
        this.bo = new ProductoBO();
    }

    public AdministracionFacade(IProductoDAO ProductoDAO) {
        this.productoDAO = ProductoDAO;
        this.productoAdapter = new ProductoNegocioAdapter();
        this.bo = new ProductoBO();

    }

    @Override
    public List<ProductoResponseDTO> obtenerProductos() throws NegocioException {
        try {
            List<ProductoEntidad> entidades = productoDAO.obtenerProductos();
            return productoAdapter.convertirEntidadesASalidas(entidades);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al intentar ver todos los productos");
        }
    }

    @Override
    public ProductoResponseDTO agregarProducto(ProductoRequestDTO producto) throws NegocioException {
        bo.validarProducto(producto);
        try {
            //Convertir a entidad
            ProductoEntidad entidad = productoAdapter.convertirEntradaAEntidad(producto);
            //Llamar al dao
            ProductoEntidad entidadGuardada = productoDAO.agregarProducto(entidad);
            //Regresar el dto
            return productoAdapter.convertirEntidadASalida(entidadGuardada);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al intentar agregar el producto");
        }
    }

    @Override
    public ProductoResponseDTO publicarProducto(String id) throws NegocioException {
        bo.validarId(id);
        try {
            //Buscamos el producto por el id
            ProductoEntidad entidad = productoDAO.buscarPorId(id);
            bo.validarPublicacion(entidad);
            bo.validarExistencia(entidad);
            //Lo mandamos a la dao
            ProductoEntidad productoPublicado = productoDAO.publicarProducto(id, EstadoProducto.PUBLICADO);
            //Regresamos el producto como dto de salida
            return productoAdapter.convertirEntidadASalida(productoPublicado);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al intentar publicar el producto", ex);
        }
    }

    @Override
    public ProductoResponseDTO actualizarProducto(String id, EstadoProducto estado) throws NegocioException {
        //Validar que no sean nulo
        bo.validarId(id);
        bo.validarEstado(estado);
        try {
            ProductoEntidad entidad = productoDAO.buscarPorId(id);
            bo.validarExistencia(entidad);
            ProductoEntidad entidadActualizada = productoDAO.cambiarEstado(id, estado);
            return productoAdapter.convertirEntidadASalida(entidadActualizada);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al intentar actualizar el producto", ex);
        }
    }
}

