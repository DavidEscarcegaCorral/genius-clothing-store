package catalago;

import dto_response.ProductoResponseDTO;
import dtos.ProductoCardDTO;

import java.util.List;

public interface ICatalagoFacade {
    List<ProductoCardDTO> cargarCategoria();

    ProductoResponseDTO obtenerProductoPorId(String id);
}
