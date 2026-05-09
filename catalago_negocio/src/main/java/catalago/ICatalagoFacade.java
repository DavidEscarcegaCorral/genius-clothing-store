package catalago;

import dtos.ProductoCardDTO;
import dtos.salida.ProductoSalidaDTO;

import java.util.List;

public interface ICatalagoFacade {
    List<ProductoCardDTO> obtenerCatalagoMainPage();

    ProductoSalidaDTO obtenerProductoPorId(String id);
}
