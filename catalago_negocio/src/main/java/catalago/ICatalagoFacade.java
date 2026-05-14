package catalago;

import dto_response.ProductoDTO;
import dtos.ProductoCardDTO;

import java.util.List;

public interface ICatalagoFacade {
    List<ProductoCardDTO> cargarCategoria();

    List<ProductoCardDTO> cargarTodosProductos();

    ProductoDTO obtenerProductoPorId(String id);

    List<ProductoCardDTO> buscarPorCategoria(String categoria);

    List<ProductoCardDTO> buscarPorGenero(String genero);

    List<ProductoCardDTO> buscarPorNombre(String nombre);
}