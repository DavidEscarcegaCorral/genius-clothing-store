package control.carrito;

import autorizacion.SesionService;
import catalago.ICatalagoFacade;
import componentes.ProductoCarritoCard;
import compras.IComprasFacade;
import dtos.CarritoDTO;
import dtos.ProductoCardDTO;
import panels.CarritoPantalla;

import java.util.ArrayList;
import java.util.List;

import static util.MensajeUtil.mostrarError;

public class CarritoControl {
    private CarritoPantalla carritoPantalla;
    private ICatalagoFacade catalagoService;
    private IComprasFacade comprasFacade;
    private List<ProductoCarritoCard> productosEnCarrito;

    private static final int ESPACIADO_VERTICAL = 15;

    public CarritoControl(CarritoPantalla carritoPantalla, ICatalagoFacade catalagoService, IComprasFacade comprasFacade) {
        this.carritoPantalla = carritoPantalla;
        this.catalagoService = catalagoService;
        this.comprasFacade = comprasFacade;
        this.productosEnCarrito = new ArrayList<>();
    }

    public void cargarCarritoDesdeBD() {
        if (SesionService.getUsuarioActual() == null) {
            return;
        }

        try {
            String usuarioId = SesionService.getUsuarioActual().getId();
            CarritoDTO carrito = comprasFacade.obtenerCarrito(usuarioId);

            productosEnCarrito.clear();
            carritoPantalla.limpiarProductos();

            if (carrito != null && carrito.getProductos() != null) {
                for (dto_response.ProductoResponseDTO prod : carrito.getProductos()) {
                    dtos.ProductoCardDTO cardDTO = new dtos.ProductoCardDTO();
                    cardDTO.setProductoId(prod.getId());
                    cardDTO.setNombreProducto(prod.getNombre());
                    cardDTO.setPrecio(prod.getPrecio());
                    cardDTO.setRutaImagen(prod.getRutaImagen());

                    ProductoCarritoCard card = new ProductoCarritoCard(cardDTO);
                    card.iniciarComponentes();
                    productosEnCarrito.add(card);
                    carritoPantalla.agregarProducto(card);
                    carritoPantalla.agregarEspacioVertical(ESPACIADO_VERTICAL);
                }
            }
        } catch (Exception e) {
            System.err.println("Error al cargar carrito desde BD: " + e.getMessage());
        }
    }

    public void agregarProductoAlCarrito(ProductoCardDTO producto) {
        try {
            if (SesionService.getUsuarioActual() == null) {
                mostrarError(carritoPantalla, "Debes iniciar sesión para agregar productos al carrito");
                return;
            }

            String usuarioId = SesionService.getUsuarioActual().getId();

            CarritoDTO carritoActualizado = comprasFacade.agregarProdcuto(
                    usuarioId,
                    producto.getProductoId(),
                    1
            );

            if (carritoActualizado != null) {
                ProductoCarritoCard card = new ProductoCarritoCard(producto);
                card.iniciarComponentes();
                productosEnCarrito.add(card);
                carritoPantalla.agregarProducto(card);
                carritoPantalla.agregarEspacioVertical(ESPACIADO_VERTICAL);
            }

        } catch (Exception e) {
            mostrarError(carritoPantalla, "Error al agregar producto: " + e.getMessage());
        }
    }

    /**
     * Elimina producto del carrito
     */
    public void eliminarProducto(String productoId) {
        try {
            if (SesionService.getUsuarioActual() == null) {
                mostrarError(carritoPantalla, "Debes iniciar sesión");
                return;
            }

            String usuarioId = SesionService.getUsuarioActual().getId();
            comprasFacade.eliminarProducto(usuarioId, productoId);

            productosEnCarrito.removeIf(card -> card.getProductoId().equals(productoId));
        } catch (Exception e) {
            mostrarError(carritoPantalla, "Error al eliminar producto: " + e.getMessage());
        }
    }

    /**
     * Obtiene carrito actualizado desde BD
     */
    public CarritoDTO obtenerCarritoActualizado() {
        try {
            if (SesionService.getUsuarioActual() == null) {
                return new CarritoDTO();
            }

            return comprasFacade.obtenerCarrito(SesionService.getUsuarioActual().getId());
        } catch (Exception e) {
            System.err.println("Error al obtener carrito: " + e.getMessage());
            return new CarritoDTO();
        }
    }

    /**
     * Vacía el carrito del usuario
     */
    public void vaciarCarrito() {
        try {
            if (SesionService.getUsuarioActual() == null) {
                mostrarError(carritoPantalla, "Debes iniciar sesión");
                return;
            }

            String usuarioId = SesionService.getUsuarioActual().getId();
            comprasFacade.vaciarCarrito(usuarioId);
            productosEnCarrito.clear();
        } catch (Exception e) {
            mostrarError(carritoPantalla, "Error al vaciar carrito: " + e.getMessage());
        }
    }

    public List<ProductoCarritoCard> getProductosEnCarrito() {
        return productosEnCarrito;
    }
}