package compras;

import dao.CarritoDAO;
import dao.ProductoDAO;
import dominio.CarritoEntidad;
import dominio.ItemCarrito;
import dominio.ProductoEntidad;
import dto_response.ProductoResponseDTO;
import dtos.CarritoDTO;
import excepciones.PersistenciaException;

import java.util.ArrayList;
import java.util.List;

public class ComprasFacade implements IComprasFacade {

    private final CarritoDAO carritoDAO;
    private final ProductoDAO productoDAO;

    public ComprasFacade() {
        this.carritoDAO = new CarritoDAO();
        this.productoDAO = new ProductoDAO();
    }

    @Override
    public CarritoDTO obtenerCarrito(String usuarioId) {
        try {
            CarritoEntidad carritoEntidad = carritoDAO.obtenerCarritoPorUsuario(usuarioId);
            return mapearEntidadADTO(carritoEntidad);
        } catch (PersistenciaException e) {
            System.err.println("Error al obtener carrito: " + e.getMessage());
            return new CarritoDTO();
        }
    }

    @Override
    public CarritoDTO agregarProdcuto(String usuarioId, String productoId, int cantidad) {
        try {
            if (usuarioId == null || usuarioId.isBlank()) {
                throw new PersistenciaException(
                        "Debes iniciar sesión para agregar productos al carrito"
                );
            }

            if (cantidad <= 0) {
                throw new PersistenciaException("La cantidad debe ser mayor a 0");
            }

            ProductoEntidad producto = productoDAO.buscarPorId(productoId);

            if (producto == null) {
                throw new PersistenciaException("Producto no encontrado: " + productoId);
            }

            String talla = producto.getTallasDisponibles() != null && !producto.getTallasDisponibles().isEmpty()
                    ? producto.getTallasDisponibles().get(0)
                    : "Única";

            CarritoEntidad carritoActualizado = carritoDAO.agregarProducto(
                    usuarioId,
                    producto.getId(),
                    producto.getNombre(),
                    producto.getPrecio(),
                    talla,
                    cantidad,
                    producto.getRutaImagen()
            );

            return mapearEntidadADTO(carritoActualizado);
        } catch (PersistenciaException e) {
            System.err.println("Error al agregar producto al carrito: " + e.getMessage());
            return obtenerCarrito(usuarioId);
        }
    }

    @Override
    public CarritoDTO eliminarProducto(String usuarioId, String productoId) {
        try {
            CarritoEntidad carritoActualizado = carritoDAO.eliminarProducto(usuarioId, productoId);
            return mapearEntidadADTO(carritoActualizado);
        } catch (PersistenciaException e) {
            System.err.println("Error al eliminar producto del carrito: " + e.getMessage());
            return obtenerCarrito(usuarioId);
        }
    }

    @Override
    public void vaciarCarrito(String usuarioId) {
        try {
            carritoDAO.vaciarCarrito(usuarioId);
        } catch (PersistenciaException e) {
            System.err.println("Error al vaciar el carrito: " + e.getMessage());
        }
    }

    @Override
    public boolean validarUsuarioActivo(String usuarioId) {
        return usuarioId != null && !usuarioId.isBlank();
    }

    private CarritoDTO mapearEntidadADTO(CarritoEntidad entidad) {
        if (entidad == null) {
            return new CarritoDTO();
        }

        CarritoDTO dto = new CarritoDTO();

        List<ProductoResponseDTO> productos = new ArrayList<>();
        if (entidad.getItems() != null) {
            for (ItemCarrito item : entidad.getItems()) {
                ProductoResponseDTO productoDTO = new ProductoResponseDTO();
                productoDTO.setId(item.getProductoId());
                productoDTO.setNombre(item.getNombre());
                productoDTO.setPrecio(item.getPrecio());
                productoDTO.setRutaImagen(item.getRutaImagen());

                List<String> tallas = new ArrayList<>();
                if (item.getTallaSeleccionada() != null) {
                    tallas.add(item.getTallaSeleccionada());
                }
                productoDTO.setTallas(tallas);

                productos.add(productoDTO);
            }
        }

        dto.setProductos(productos);
        dto.setCantidadTotal(productos.size());

        return dto;
    }
}
