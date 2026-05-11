package catalago;

import dto_response.ProductoSalidaDTO;
import dtos.ProductoCardDTO;

import java.util.List;

public interface ICatalagoFacade {
    List<ProductoCardDTO> obtenerCatalagoMainPage();

    ProductoSalidaDTO obtenerProductoPorId(String id);
}
