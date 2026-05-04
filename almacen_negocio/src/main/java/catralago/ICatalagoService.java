package catralago;

import dtos.ProductoCardDTO;
import dtos.ProductoDTO;

import java.util.List;

public interface ICatalagoService {
    List<ProductoCardDTO> obtenerCatalagoMainPage();

    ProductoDTO obtenerProductoPorId(String id);

}
