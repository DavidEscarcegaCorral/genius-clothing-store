package control;

import catalago.ICatalagoService;
import componentes.ProductoCarritoCard;
import dtos.ProductoCardDTO;
import panels.CarritoPanel;

import java.util.ArrayList;
import java.util.List;

public class CarritoControl {
    private CarritoPanel carritoPanel;
    private ICatalagoService catalagoService;
    private List<ProductoCarritoCard> productosEnCarrito;

    public CarritoControl(CarritoPanel carritoPanel, ICatalagoService catalagoService) {
        this.carritoPanel = carritoPanel;
        this.catalagoService = catalagoService;
        this.productosEnCarrito = new ArrayList<>();

        cargarProductosDemo();
    }

    // Metodo para porbar como se ve el panel
    private void cargarProductosDemo() {
        List<ProductoCardDTO> productos = catalagoService.obtenerCatalagoMainPage();

        for (ProductoCardDTO producto : productos) {
            agregarProductoAlCarrito(producto);
        }
    }

    public void agregarProductoAlCarrito(ProductoCardDTO producto) {
        ProductoCarritoCard card = new ProductoCarritoCard(producto);
        card.iniciarComponentes();

        productosEnCarrito.add(card);
        carritoPanel.agregarProducto(card);
    }

    public void eliminarProducto(String productoId) {
        productosEnCarrito.removeIf(card -> card.getProductoId().equals(productoId));
    }
}