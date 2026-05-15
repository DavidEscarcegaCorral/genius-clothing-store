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
public class AdministracionFacade implements IAdministracionFacade {

    private ControlAdministrarProducto administrar;
    private ControlValidarProducto validar;

    public AdministracionFacade() {
        this.administrar = ControlAdministrarProducto.getInstance();
        this.validar = new ControlValidarProducto();
    }

    @Override
    public List<ProductoDTO> obtenerProductos() throws NegocioException {
        return administrar.verProductos();
    }

    @Override
    public ProductoDTO agregarProducto(dto_response.ProductoDTO producto) throws NegocioException {
        validar.validarProducto(producto);
        return administrar.agregarProducto(producto);

    }

    @Override
    public ProductoDTO publicarProducto(String id) throws NegocioException {
        validar.validarId(id);
        ProductoDTO buscar = administrar.buscarPorId(id);
        validar.validarPublicacion(buscar);
        return administrar.publicarProducto(id);
    }

    @Override
    public ProductoDTO actualizarProducto(String id, EstadoProducto estadoNuevo) throws NegocioException {
        validar.validarId(id);
        ProductoDTO producto = administrar.buscarPorId(id);
        validar.validarEstado(producto.getEstado(), estadoNuevo);
        return administrar.editarProducto(id, estadoNuevo);

    }
}

