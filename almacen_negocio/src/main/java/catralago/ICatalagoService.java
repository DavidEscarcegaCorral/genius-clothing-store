package catralago;

import dtos.ProductoCardDTO;

import java.util.List;

public interface ICatalagoService {
    List<ProductoCardDTO> obtenerCatalagoMainPage();
}
