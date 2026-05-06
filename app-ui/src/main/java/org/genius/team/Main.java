package org.genius.team;

import administracion.AdministracionService;
import administracion.IAdministracionService;
import autorizacion.AutorizacionService;
import autorizacion.IAutorizacionService;
import catralago.CatalagoService;
import catralago.ICatalagoService;
import control.AdministracionProductosControl;
import control.AlmacenControl;
import control.LoginControl;
import control.NavegacionControl;
import dialogs.AgregarProductoDialog;
import dialogs.EditarProductoDialog;
import dialogs.PublicarProductoDialog;
import frames.AdministracionProductoFrame;
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

        AlmacenControl almacenControl = new AlmacenControl(
                globalFrame.getMainPage(),
                catalagoService,
                navegacionControl
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

}}