package control;

import administracion.AdministracionService;
import administracion.IAdministracionService;
import autorizacion.AutorizacionService;
import autorizacion.IAutorizacionService;
import catalago.CatalagoService;
import catalago.ICatalagoService;
import dialogs.AgregarProductoDialog;
import dialogs.EditarProductoDialog;
import dialogs.PublicarProductoDialog;
import frames.AdministracionProductoFrame;
import frames.GlobalFrame;
import frames.LogInFrame;

public class AppCoordinator {
    private final LogInFrame logInFrame;
    private final GlobalFrame globalFrame;
    private final AdministracionProductoFrame adminFrame;
    
    private final IAutorizacionService autorizacionService;
    private final ICatalagoService catalagoService;
    private final IAdministracionService administracionService;
    
    private final NavegacionControl navegacionControl;
    private LoginControl loginControl;
    private CatalagoControl catalagoControl;
    private AdministracionProductosControl adminControl;

    public AppCoordinator() {
        this.logInFrame = new LogInFrame();
        this.globalFrame = new GlobalFrame();
        this.adminFrame = new AdministracionProductoFrame();
        
        this.autorizacionService = new AutorizacionService();
        this.catalagoService = new CatalagoService();
        this.administracionService = new AdministracionService();
        
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
                catalagoService,
                navegacionControl);

        adminControl = new AdministracionProductosControl(
                adminFrame.getAdministracionProductosPanel(),
                globalFrame.getHeader(),
                administracionService,
                navegacionControl,
                new AgregarProductoDialog(),
                new EditarProductoDialog(),
                new PublicarProductoDialog());

        adminFrame.setObserver(adminControl);
    }

    private void configurarNavegacion() {
        navegacionControl.setGlobalFrame(globalFrame);
        navegacionControl.setLogInFrame(logInFrame);
        navegacionControl.setAdministracionProductoFrame(adminFrame);
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