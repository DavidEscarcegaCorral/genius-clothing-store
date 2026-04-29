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
        GlobalFrame globalFrame = new GlobalFrame();
        IAutorizacionService autorizacionService = new AutorizacionService();
        NavegacionControl navegacionControl = new NavegacionControl();

        LoginControl loginControl = new LoginControl(
                logInFrame.getLogInPanel(),
                globalFrame.getHeader(),
                autorizacionService,
                navegacionControl);

        navegacionControl.setGlobalFrame(globalFrame);
        navegacionControl.setLogInFrame(logInFrame);

        globalFrame.setVisible(true);


    }
}