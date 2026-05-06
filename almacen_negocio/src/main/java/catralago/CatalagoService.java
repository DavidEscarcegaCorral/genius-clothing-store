package catralago;

import dominio.ProductoEntidad;
import dtos.ProductoCardDTO;
import mappers.ProductoMapper;
import repository.ProductosRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CatalagoService implements ICatalagoService {
    private ProductosRepository repository;

    public CatalagoService() {
        repository = new ProductosRepository();
    }

    @Override
    public List<ProductoCardDTO> obtenerCatalagoMainPage() {
        List<ProductoEntidad> entidades = repository.obtenerProductos();

        return entidades.stream()
                .map(ProductoMapper::entidadADTO)
                .collect(Collectors.toList());
    }
}
