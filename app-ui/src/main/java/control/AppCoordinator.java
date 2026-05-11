package control;

import administracion.AdministracionFacade;
import administracion.IAdministracionFacade;
import autorizacion.AutorizacionService;
import autorizacion.IAutorizacionService;
import catalago.CatalagoFacade;
import catalago.ICatalagoFacade;
import control.auth.LoginControl;
import control.carrito.CarritoControl;
import control.catalago.CatalagoControl;
import control.gestor.AdministracionProductosControl;
import control.navegacion.NavegacionControl;
import dialogs.AgregarProductoDialog;
import dialogs.EditarProductoDialog;
import frames.AdministracionProductoFrame;
import frames.GlobalFrame;
import frames.LogInFrame;

public class AppCoordinator {
    private final LogInFrame logInFrame;
    private final GlobalFrame globalFrame;
    private final AdministracionProductoFrame adminFrame;

    private final IAutorizacionService autorizacionService;
    private final ICatalagoFacade catalagoFacade;
    private final IAdministracionFacade administracionService;

    private final NavegacionControl navegacionControl;
    private LoginControl loginControl;
    private CatalagoControl catalagoControl;
    private CarritoControl carritoControl;
    private AdministracionProductosControl adminControl;
    
    public AppCoordinator() {
        this.logInFrame = new LogInFrame();
        this.globalFrame = new GlobalFrame();
        this.adminFrame = new AdministracionProductoFrame();

        this.autorizacionService = new AutorizacionService();
        this.catalagoFacade = new CatalagoFacade();
        this.administracionService = new AdministracionFacade();

        this.navegacionControl = new NavegacionControl();
    }

    public void iniciar() {
        inicializarControles();
        configurarNavegacion();
        mostrarHome();
    }

    private void inicializarControles() {
        loginControl = new LoginControl(
                logInFrame.getLogInPanel(),
                globalFrame.getHeader(),
                autorizacionService,
                navegacionControl);

        catalagoControl = new CatalagoControl(
                globalFrame.getMainPagePanel(),
                catalagoFacade,
                navegacionControl);

        carritoControl = new CarritoControl(
                globalFrame.getCarritoPanel(),
                catalagoFacade);

        adminControl = new AdministracionProductosControl(
                adminFrame.getAdministracionProductosPanel(),
                globalFrame.getHeader(),
                administracionService,
                navegacionControl,
                new AgregarProductoDialog(),
                new EditarProductoDialog());

        adminFrame.setObserver(adminControl);
    }

    private void configurarNavegacion() {
        navegacionControl.setGlobalFrame(globalFrame);
        navegacionControl.setLogInFrame(logInFrame);
        navegacionControl.setAdministracionProductoFrame(adminFrame);
        navegacionControl.setDialogAgregarProducto(adminControl.getAgregarProductoDialog()); 
        navegacionControl.setDialogEditarProducto(adminControl.getEditarProductoDialog()); 
        globalFrame.getHeader().setCarritoAction(e -> navegacionControl.navegarACarrito());
    }

    private void mostrarHome() {
        globalFrame.setVisible(true);
    }

    public GlobalFrame getGlobalFrame() {
        return globalFrame;
    }

    public LogInFrame getLogInFrame() {
        return logInFrame;
    }

    public NavegacionControl getNavegacionControl() {
        return navegacionControl;
    }
}