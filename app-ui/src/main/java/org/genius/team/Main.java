package org.genius.team;

import autorizacion.AutorizacionService;
import autorizacion.IAutorizacionService;
import catalago.CatalagoService;
import catalago.ICatalagoService;
import control.CatalagoControl;
import control.LoginControl;
import control.NavegacionControl;
import control.Navegador;
import frames.GlobalFrame;
import frames.LogInFrame;

public class Main {
    public static void main(String[] args) {
        LogInFrame logInFrame = new LogInFrame();
        GlobalFrame globalFrame = new GlobalFrame();
        IAutorizacionService autorizacionService = new AutorizacionService();
        ICatalagoService catalagoService = new CatalagoService();
        NavegacionControl navegacionControl = new NavegacionControl();

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

        globalFrame.setVisible(true);


    }
}