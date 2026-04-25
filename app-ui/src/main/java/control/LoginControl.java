package control;

import autorizacion.IAutorizacionService;
import panels.LogInPanel;

public class LoginControl {
    private final LogInPanel logInPanel;
    private final IAutorizacionService autorizacionService;
    private final NavegacionControl navegacionControl;

    public LoginControl(LogInPanel logInPanel, IAutorizacionService autorizacionService, NavegacionControl navegacionControl) {
        this.logInPanel = logInPanel;
        this.autorizacionService = autorizacionService;
        this.navegacionControl = navegacionControl;
    }
}
