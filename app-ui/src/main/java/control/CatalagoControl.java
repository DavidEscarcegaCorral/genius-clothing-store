package control;

import catralago.ICatalagoService;
import componentes.ProductoCard;
import dtos.ProductoCardDTO;
import panels.MainPagePanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.stream.Collectors;

public class CatalagoControl {
    private MainPagePanel mainPagePanel;
    private ICatalagoService catalagoService;
    private NavegacionControl navegacionControl;

    public CatalagoControl(MainPagePanel mainPagePanel,
                           ICatalagoService catalagoService,
                           NavegacionControl navegacionControl) {
        this.mainPagePanel = mainPagePanel;
        this.catalagoService = catalagoService;
        this.navegacionControl = navegacionControl;

        cargarCatalago();

    }

    public void cargarCatalago() {
        List<ProductoCardDTO> productos = catalagoService.obtenerCatalagoMainPage();
        List<ProductoCardDTO> novedades = productos.stream()
                .limit(5)
                .collect(Collectors.toList());

        mainPagePanel.setNovedadesSeccion(novedades);
    }

    public void iniciarlizarListeners(List<ProductoCard> cards) {
        for (ProductoCard card : cards) {
            card.addAncestorListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    String id = card.getProductoId();
                    navegacionControl.irADetalleProducto(id);
                }
            });
        }
    }
}
