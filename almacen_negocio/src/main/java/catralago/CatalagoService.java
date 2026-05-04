package catralago;

import dominio.ProductoEntidad;
import dtos.ProductoCardDTO;
import dtos.ProductoDTO;
import mappers.ProductoMapper;
import org.bson.types.ObjectId;
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

    @Override
    public ProductoDTO obtenerProductoPorId(String id) {
        try {
            ObjectId objectId = new ObjectId(id);

            ProductoEntidad entidad = repository.busarPorId(objectId);

            if (entidad != null) {
                return ProductoMapper.entidadADtoCompleto(entidad);
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Formato de ID inválido: " + id);
        } catch (Exception e) {
            System.err.println("Error al obtener el detalle del producto: " + e.getMessage());
        }

        return null;
    }
}
