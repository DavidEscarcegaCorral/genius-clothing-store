package catalago;

import dto_response.ProductoResponseDTO;
import dtos.ProductoCardDTO;

import java.util.List;

public class CatalagoFacade implements ICatalagoFacade {
    private CatalagoControl catalagoControl;

    public CatalagoFacade() {
    }

    @Override
    public List<ProductoCardDTO> cargarCategoria() {

    }

    @Override
    public ProductoResponseDTO obtenerProductoPorId(String id) {

        return null;
    }
}
