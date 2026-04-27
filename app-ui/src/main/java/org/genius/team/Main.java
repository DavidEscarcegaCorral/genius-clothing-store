package org.genius.team;

import autorizacion.AutorizacionService;
import autorizacion.IAutorizacionService;
import control.LoginControl;
import control.NavegacionControl;
import frames.GlobalFrame;
import frames.LogInFrame;

public class Main {
    public static void main(String[] args) {
        LogInFrame logInFrame = new LogInFrame();
        IAutorizacionService autorizacionService = new AutorizacionService();
        NavegacionControl navegacionControl = new NavegacionControl();

        LoginControl loginControl = new LoginControl(
                logInFrame.getLogInPanel(),
                autorizacionService,
                navegacionControl);

        navegacionControl.setLogInFrame(logInFrame);

        logInFrame.setVisible(true);

//        GlobalFrame globalFrame = new GlobalFrame();
//        globalFrame.setVisible(true);


    }
}