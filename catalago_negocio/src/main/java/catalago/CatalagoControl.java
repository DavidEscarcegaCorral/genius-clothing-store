package catalago;

import dao.IProductoDAO;
import dominio.ProductoEntidad;
import dto_response.ProductoDTO;
import dtos.ProductoCardDTO;
import excepciones.PersistenciaException;
import mappers.ProductoMapper;

import java.util.ArrayList;
import java.util.List;

public class CatalagoControl {
    private final IProductoDAO productoDAO;

    public CatalagoControl(IProductoDAO productoDAO) {
        this.productoDAO = productoDAO;
    }

    public List<ProductoCardDTO> cargarProductosPublicados() throws PersistenciaException {
        List<ProductoEntidad> entidades = productoDAO.obtenerProductosPublicados();
        List<ProductoCardDTO> productos = new ArrayList<>();
        for (ProductoEntidad entidad : entidades) {
            productos.add(ProductoMapper.entidadADTO(entidad));
        }
        return productos;
    }

    public List<ProductoCardDTO> cargarTodosProductos() throws PersistenciaException {
        List<ProductoEntidad> entidades = productoDAO.obtenerProductos();
        List<ProductoCardDTO> productos = new ArrayList<>();
        for (ProductoEntidad entidad : entidades) {
            productos.add(ProductoMapper.entidadADTO(entidad));
        }
        return productos;
    }

    public ProductoDTO obtenerProductoPorId(String id) throws PersistenciaException {
        ProductoEntidad entidad = productoDAO.buscarPorId(id);
        if (entidad == null) {
            return null;
        }
        return ProductoMapper.entidadADtoCompleto(entidad);
    }

    public List<ProductoCardDTO> buscarPorCategoria(String categoria) throws PersistenciaException {
        List<ProductoEntidad> entidades = productoDAO.obtenerProductosPublicados();
        List<ProductoCardDTO> productos = new ArrayList<>();
        for (ProductoEntidad entidad : entidades) {
            if (entidad.getCategoria() != null &&
                    entidad.getCategoria().name().equalsIgnoreCase(categoria)) {
                productos.add(ProductoMapper.entidadADTO(entidad));
            }
        }
        return productos;
    }

    public List<ProductoCardDTO> buscarPorGenero(String genero) throws PersistenciaException {
        List<ProductoEntidad> entidades = productoDAO.obtenerProductosPublicados();
        List<ProductoCardDTO> productos = new ArrayList<>();
        for (ProductoEntidad entidad : entidades) {
            if (entidad.getGenero() != null &&
                    entidad.getGenero().name().equalsIgnoreCase(genero)) {
                productos.add(ProductoMapper.entidadADTO(entidad));
            }
        }
        return productos;
    }

    public List<ProductoCardDTO> buscarPorNombre(String nombre) throws PersistenciaException {
        List<ProductoEntidad> entidades = productoDAO.obtenerProductosPublicados();
        List<ProductoCardDTO> productos = new ArrayList<>();
        for (ProductoEntidad entidad : entidades) {
            if (entidad.getNombre() != null &&
                    entidad.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                productos.add(ProductoMapper.entidadADTO(entidad));
            }
        }
        return productos;
    }
}