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
    
    private ControlAdministrarProducto administrar;
    private ControlValidarProducto validar;
    
    
    
    public AdministracionFacade() {
        this.administrar = ControlAdministrarProducto.getInstance();
        this.validar = new ControlValidarProducto();
    }
    
    @Override
    public List<ProductoResponseDTO> obtenerProductos() throws NegocioException {
        return administrar.verProductos();
    }

    @Override
    public ProductoResponseDTO agregarProducto(ProductoRequestDTO producto) throws NegocioException {
        validar.validarProducto(producto);
        return administrar.agregarProducto(producto);

    }

    @Override
    public ProductoResponseDTO publicarProducto(String id) throws NegocioException {
        validar.validarId(id);
        ProductoResponseDTO buscar = administrar.buscarPorId(id);
        validar.validarPublicacion(buscar);
        return administrar.publicarProducto(id);
    }

    @Override
    public ProductoResponseDTO actualizarProducto(String id, EstadoProducto estado) throws NegocioException {
        validar.validarId(id);
        validar.validarEstado(estado);
        return administrar.editarProducto(id, estado);

    }
}

