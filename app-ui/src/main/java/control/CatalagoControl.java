package control;

import catalago.ICatalagoService;
import componentes.ProductoCard;
import dtos.ProductoCardDTO;
import dtos.ProductoDTO;
import panels.MainPagePanel;
import panels.ProductoDetallePanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.stream.Collectors;

public class CatalagoControl {
    private MainPagePanel mainPagePanel;
    private ICatalagoService catalagoService;
    private INavegador INavegador;

    public CatalagoControl(MainPagePanel mainPagePanel,
                           ICatalagoService catalagoService,
                           INavegador INavegador) {
        this.mainPagePanel = mainPagePanel;
        this.catalagoService = catalagoService;
        this.INavegador = INavegador;

        cargarCatalago();
    }

    public void cargarCatalago() {
        List<ProductoCardDTO> productos = catalagoService.obtenerCatalagoMainPage();
        List<ProductoCardDTO> novedades = productos.stream()
                .limit(5)
                .collect(Collectors.toList());

        mainPagePanel.setNovedadesSeccion(novedades);
        List<ProductoCard> cards = mainPagePanel.getCardsActuales();
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
            ProductoDetallePanel panelDetalle = new ProductoDetallePanel();
            panelDetalle.cargarDatosProducto(dto);

            INavegador.navegarADetalle(panelDetalle);
        }
    }
}
