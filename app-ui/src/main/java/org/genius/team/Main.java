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

        globalFrame.setVisible(true);


    }
}