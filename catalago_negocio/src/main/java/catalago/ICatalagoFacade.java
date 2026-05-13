package catalago;

import dto_response.ProductoResponseDTO;
import dtos.ProductoCardDTO;

import java.util.List;

public interface ICatalagoFacade {
    List<ProductoCardDTO> obtenerCatalagoMainPage();

    ProductoResponseDTO obtenerProductoPorId(String id);
}
