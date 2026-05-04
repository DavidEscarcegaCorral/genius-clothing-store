package control;

import catralago.ICatalagoService;
import dtos.ProductoCardDTO;
import panels.MainPagePanel;

import java.util.List;
import java.util.stream.Collectors;

public class AlmacenControl {
    private MainPagePanel mainPagePanel;
    private ICatalagoService catalagoService;
    private NavegacionControl navegacionControl;

    public AlmacenControl(MainPagePanel mainPagePanel,
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
}
