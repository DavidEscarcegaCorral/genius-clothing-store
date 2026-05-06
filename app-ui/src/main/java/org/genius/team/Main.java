package org.genius.team;

import autorizacion.AutorizacionService;
import autorizacion.IAutorizacionService;
import catralago.CatalagoService;
import catralago.ICatalagoService;
import control.AlmacenControl;
import control.LoginControl;
import control.NavegacionControl;
import frames.GlobalFrame;
import frames.LogInFrame;

public class Main {
    public static void main(String[] args) {
        LogInFrame logInFrame = new LogInFrame();
        GlobalFrame globalFrame = new GlobalFrame();
        IAutorizacionService autorizacionService = new AutorizacionService();
        ICatalagoService catalagoService = new CatalagoService();
        NavegacionControl navegacionControl = new NavegacionControl();
        AdministracionProductoFrame adminFrame = new AdministracionProductoFrame();
        IAdministracionService adminService = new AdministracionService();
        AgregarProductoDialog agregarDialog = new AgregarProductoDialog();
        EditarProductoDialog editarDialog = new EditarProductoDialog();
        PublicarProductoDialog publicarDialog = new PublicarProductoDialog();

        LoginControl loginControl = new LoginControl(
                logInFrame.getLogInPanel(),
                globalFrame.getHeader(),
                autorizacionService,
                navegacionControl);

        CatalagoControl catalagoControl = new CatalagoControl(
                globalFrame.getMainPagePanel(),
                catalagoService,
                (Navegador) navegacionControl
        );

        navegacionControl.setGlobalFrame(globalFrame);
        navegacionControl.setLogInFrame(logInFrame);
        navegacionControl.setAdministracionProductoFrame(adminFrame);

            AdministracionProductosControl adminControl =
            new AdministracionProductosControl(
                    adminFrame.getAdministracionProductosPanel(),
                    globalFrame.getHeader(),
                    adminService,
                    navegacionControl,
                    agregarDialog,
                    editarDialog,
                    publicarDialog
            );
        adminFrame.setObserver(adminControl);
        globalFrame.setVisible(true);


    }
}