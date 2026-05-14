package catalago;

import dao.ProductoDAO;
import dto_response.ProductoDTO;
import dtos.ProductoCardDTO;
import excepciones.PersistenciaException;

import java.util.ArrayList;
import java.util.List;

public class CatalagoFacade implements ICatalagoFacade {
    private final CatalagoControl catalagoControl;

    public CatalagoFacade() {
        this.catalagoControl = new CatalagoControl(new ProductoDAO());
    }

    @Override
    public List<ProductoCardDTO> cargarCategoria() {
        try {
            return catalagoControl.cargarProductosPublicados();
        } catch (PersistenciaException e) {
            System.err.println("Error al cargar productos: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public List<ProductoCardDTO> cargarTodosProductos() {
        try {
            return catalagoControl.cargarTodosProductos();
        } catch (PersistenciaException e) {
            System.err.println("Error al cargar todos los productos: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public ProductoDTO obtenerProductoPorId(String id) {
        try {
            return catalagoControl.obtenerProductoPorId(id);
        } catch (PersistenciaException e) {
            System.err.println("Error al obtener producto: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<ProductoCardDTO> buscarPorCategoria(String categoria) {
        try {
            return catalagoControl.buscarPorCategoria(categoria);
        } catch (PersistenciaException e) {
            System.err.println("Error al buscar por categoría: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public List<ProductoCardDTO> buscarPorGenero(String genero) {
        try {
            return catalagoControl.buscarPorGenero(genero);
        } catch (PersistenciaException e) {
            System.err.println("Error al buscar por género: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public List<ProductoCardDTO> buscarPorNombre(String nombre) {
        try {
            return catalagoControl.buscarPorNombre(nombre);
        } catch (PersistenciaException e) {
            System.err.println("Error al buscar por nombre: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}