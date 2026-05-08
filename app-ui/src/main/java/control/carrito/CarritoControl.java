package control.carrito;

import catalago.ICatalagoFacade;
import componentes.ProductoCarritoCard;
import dtos.ProductoCardDTO;
import panels.CarritoPantalla;

import java.util.ArrayList;
import java.util.List;

public class CarritoControl {
    private CarritoPantalla carritoPantalla;
    private ICatalagoFacade catalagoService;
    private List<ProductoCarritoCard> productosEnCarrito;

    public CarritoControl(CarritoPantalla carritoPantalla, ICatalagoFacade catalagoService) {
        this.carritoPantalla = carritoPantalla;
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
        carritoPantalla.agregarProducto(card);
    }

    public void eliminarProducto(String productoId) {
        productosEnCarrito.removeIf(card -> card.getProductoId().equals(productoId));
    }
}