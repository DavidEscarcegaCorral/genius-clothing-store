package control;

import administracion.AdministracionFacade;
import administracion.IAdministracionFacade;
import autorizacion.AutorizacionFacade;
import autorizacion.IAutorizacionFacade;
import catalago.CatalagoFacade;
import catalago.ICatalagoFacade;
import compras.ComprasFacade;
import compras.IComprasFacade;
import conexion.DatabaseSeeder;
import control.auth.LoginControl;
import control.carrito.CarritoControl;
import control.catalago.ProdcutosControl;
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

    private final IAutorizacionFacade autorizacionService;
    private final ICatalagoFacade catalagoFacade;
    private final IAdministracionFacade administracionService;
    private final IComprasFacade comprasFacade;

    private final NavegacionControl navegacionControl;
    private LoginControl loginControl;
    private ProdcutosControl prodcutosControl;
    private CarritoControl carritoControl;
    private AdministracionProductosControl adminControl;

    public AppCoordinator() {
        this.logInFrame = new LogInFrame();
        this.globalFrame = new GlobalFrame();
        this.adminFrame = new AdministracionProductoFrame();

        this.autorizacionService = new AutorizacionFacade();
        this.catalagoFacade = new CatalagoFacade();
        this.administracionService = new AdministracionFacade();
        this.comprasFacade = new ComprasFacade();

        this.navegacionControl = new NavegacionControl();
    }

    public void iniciar() {
//        inicializarBaseDeDatos();
        inicializarControles();
        configurarNavegacion();
        mostrarHome();
    }

    private void inicializarBaseDeDatos() {
        DatabaseSeeder.inicializarProductosSiEstaVacio();
    }

    private void inicializarControles() {
        loginControl = new LoginControl(
                logInFrame.getLogInPanel(),
                globalFrame.getHeader(),
                autorizacionService,
                navegacionControl);

        carritoControl = new CarritoControl(
                globalFrame.getCarritoPanel(),
                catalagoFacade,
                comprasFacade);

        prodcutosControl = new ProdcutosControl(
                globalFrame.getMainPagePanel(),
                catalagoFacade,
                navegacionControl,
                carritoControl);

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
        navegacionControl.setCarritoControl(carritoControl);
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