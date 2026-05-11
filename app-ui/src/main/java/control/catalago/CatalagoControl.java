package control.catalago;

import catalago.ICatalagoFacade;
import componentes.ProductoCard;
import control.carrito.CarritoControl;
import control.navegacion.INavegador;
import dto_response.ProductoResponseDTO;
import dtos.ProductoCardDTO;
import panels.MainPagePantalla;
import panels.ProductoPantalla;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.stream.Collectors;

public class CatalagoControl {
    private MainPagePantalla mainPagePantalla;
    private ICatalagoFacade catalagoService;
    private INavegador INavegador;
    private CarritoControl carritoControl;
    private ProductoPantalla panelDetalleActual;

    public CatalagoControl(MainPagePantalla mainPagePantalla,
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
        List<ProductoCardDTO> productos = catalagoService.obtenerCatalagoMainPage();
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
        ProductoResponseDTO dto = catalagoService.obtenerProductoPorId(id);

        if (dto != null) {
            panelDetalleActual = new ProductoPantalla();
            panelDetalleActual.cargarDatosProducto(dto);
            panelDetalleActual.setAgregarAlCarritoListener(e -> agregarAlCarrito());

            INavegador.navegarADetalleProdcuto(panelDetalleActual);
        }
    }

    private void agregarAlCarrito() {
        if (panelDetalleActual != null && carritoControl != null) {
            ProductoCardDTO producto = panelDetalleActual.getProductoParaCarrito();
            if (producto != null) {
                carritoControl.agregarProductoAlCarrito(producto);
            }
        }
    }
}