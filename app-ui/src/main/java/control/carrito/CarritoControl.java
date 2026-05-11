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

    private static final int ESPACIADO_VERTICAL = 15;

    public CarritoControl(CarritoPantalla carritoPantalla, ICatalagoFacade catalagoService) {
        this.carritoPantalla = carritoPantalla;
        this.catalagoService = catalagoService;
        this.productosEnCarrito = new ArrayList<>();

    }


    public void agregarProductoAlCarrito(ProductoCardDTO producto) {
        ProductoCarritoCard card = new ProductoCarritoCard(producto);
        card.iniciarComponentes();

        productosEnCarrito.add(card);
        carritoPantalla.agregarProducto(card);

        carritoPantalla.agregarEspacioVertical(ESPACIADO_VERTICAL);
    }

    public void eliminarProducto(String productoId) {
        productosEnCarrito.removeIf(card -> card.getProductoId().equals(productoId));
    }
}