package catalago;

import dominio.ProductoEntidad;
import dto_response.ProductoResponseDTO;
import dtos.ProductoCardDTO;
import mappers.ProductoMapper;
import repository.ProductosRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CatalagoFacade implements ICatalagoFacade {
    // implementar el control
    private ProductosRepository repository;

    public CatalagoFacade() {
        repository = new ProductosRepository();
    }

    @Override
    public List<ProductoCardDTO> obtenerCatalagoMainPage() {
        List<ProductoEntidad> entidades = repository.obtenerProductos();

        return entidades.stream()
                .map(ProductoMapper::entidadADTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductoResponseDTO obtenerProductoPorId(String id) {
        try {
            ProductoEntidad entidad = repository.buscarPorId(id);

            if (entidad != null) {
                return ProductoMapper.entidadADtoCompleto(entidad);
            }
        } catch (Exception e) {
            System.err.println("Error al obtener el detalle del producto: " + e.getMessage());
        }

        return null;
    }
}
