package control.catalago;

import catalago.ICatalagoFacade;
import componentes.ProductoCard;
import control.carrito.CarritoControl;
import control.navegacion.INavegador;
import dto_response.ProductoDTO;
import dtos.ProductoCardDTO;
import panels.MainPagePantalla;
import panels.ProductoPantalla;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.stream.Collectors;

public class ProdcutosControl {
    private MainPagePantalla mainPagePantalla;
    private ICatalagoFacade catalagoService;
    private INavegador INavegador;
    private CarritoControl carritoControl;
    private ProductoPantalla prodcutoPantalla;

    public ProdcutosControl(MainPagePantalla mainPagePantalla,
                            ICatalagoFacade catalagoService,
                            INavegador INavegador,
                            CarritoControl carritoControl) {
        this.mainPagePantalla = mainPagePantalla;
        this.catalagoService = catalagoService;
        this.INavegador = INavegador;
        this.carritoControl = carritoControl;

        cargarCatalago();
    }

    public void cargarCatalago() {
        List<ProductoCardDTO> productos = catalagoService.cargarCategoria();
        List<ProductoCardDTO> novedades = productos.stream()
                .limit(5)
                .collect(Collectors.toList());

        mainPagePantalla.setNovedadesSeccion(novedades);
        List<ProductoCard> cards = mainPagePantalla.getCardsActuales();
        inicializarListeners(cards);
    }

    public void inicializarListeners(List<ProductoCard> cards) {
        for (ProductoCard card : cards) {
            card.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    abrirDetalle(card.getProductoId());
                }
            });
        }
    }

    private void abrirDetalle(String id) {
        ProductoDTO dto = catalagoService.obtenerProductoPorId(id);

        if (dto != null) {
            prodcutoPantalla = new ProductoPantalla();
            prodcutoPantalla.cargarDatosProducto(dto);
            prodcutoPantalla.setAgregarAlCarritoListener(e -> agregarAlCarrito());

            INavegador.navegarADetalleProdcuto(prodcutoPantalla);
        }
    }

    private void agregarAlCarrito() {
        if (prodcutoPantalla != null && carritoControl != null) {
            ProductoCardDTO producto = prodcutoPantalla.getProductoParaCarrito();
            String talla = prodcutoPantalla.getTallaSeleccionada();
            if (producto != null) {
                carritoControl.agregarProductoAlCarrito(producto, talla);
            }
        }
    }
}