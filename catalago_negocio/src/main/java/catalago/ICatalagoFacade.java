package catalago;

import dtos.ProductoCardDTO;
import dtos.ProductoDTO;

import java.util.List;

public interface ICatalagoFacade {
    List<ProductoCardDTO> obtenerCatalagoMainPage();

    ProductoDTO obtenerProductoPorId(String id);
}
