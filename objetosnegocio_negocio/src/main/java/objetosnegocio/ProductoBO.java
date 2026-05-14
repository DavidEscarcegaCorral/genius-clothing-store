/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosnegocio;

import adaptadores.ProductoNegocioAdapter;
import dao.ProductoDAO;
import dominio.ProductoEntidad;
import dto_response.ProductoDTO;
import enumeradores.EstadoProducto;
import excepciones.PersistenciaException;

import java.util.List;


/**
 * @author Usuario
 */
public class ProductoBO {

    private ProductoDAO dao;
    private ProductoNegocioAdapter adaptador;

    public ProductoBO() {
        this.dao = new ProductoDAO();
        this.adaptador = new ProductoNegocioAdapter();
    }

    public ProductoDTO agregarProducto(dto_response.ProductoDTO producto) throws PersistenciaException {
        ProductoEntidad entidad = adaptador.convertirEntradaAEntidad(producto);
        dao.agregarProducto(entidad);
        return adaptador.convertirEntidadASalida(entidad);
    }

    public ProductoDTO editarProducto(String id, EstadoProducto estado) throws PersistenciaException {
        ProductoEntidad entidad = dao.cambiarEstado(id, estado);
        return adaptador.convertirEntidadASalida(entidad);
    }

    public List<ProductoDTO> verProductos() throws PersistenciaException {
        List<ProductoEntidad> entidades = dao.obtenerProductos();
        return adaptador.convertirEntidadesASalidas(entidades);
    }

    public ProductoDTO publicarProducto(String id) throws PersistenciaException {
        ProductoEntidad publicar = dao.publicarProducto(id, EstadoProducto.PUBLICADO);
        return adaptador.convertirEntidadASalida(publicar);
    }

    public ProductoDTO buscarPorId(String id) throws PersistenciaException {
        ProductoEntidad buscar = dao.buscarPorId(id);
        return adaptador.convertirEntidadASalida(buscar);
    }
}
