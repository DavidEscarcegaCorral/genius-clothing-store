package control;

import autorizacion.IAutorizacionService;
import dtos.CredencialesDTO;
import panels.LogInPanel;
import util.MensajeUtil;
import util.ValidadorFormato;

public class LoginControl {
    private final LogInPanel logInPanel;
    private final IAutorizacionService autorizacionService;
    private final NavegacionControl navegacionControl;

    public LoginControl(LogInPanel logInPanel, IAutorizacionService autorizacionService, NavegacionControl navegacionControl) {
        this.logInPanel = logInPanel;
        this.autorizacionService = autorizacionService;
        this.navegacionControl = navegacionControl;
        iniciarlizarListeners();
    }

    public void iniciarlizarListeners() {
        logInPanel.getIngresarBtn().addActionListener(e -> proceasrLogin());

    }

    public void proceasrLogin() {
        // Capturar los datos
        String usuario = logInPanel.getUsuarioTxt().getText();
        String contraseña = logInPanel.getContrseñaTxt().getText();

        // Validacion de formato de usuario
        if (!ValidadorFormato.esUsuarioValido(usuario)){
            MensajeUtil.mostrarError(logInPanel, "El nombre de usuario no puede contener espacios ni esar vacio.");
            return;
        }

        // Crear el DTO
        CredencialesDTO credencialesDTO = new CredencialesDTO(usuario, contraseña);
        boolean loginExitoso = autorizacionService.verificarLogin(credencialesDTO);

        if (loginExitoso){
            navegacionControl.abrirGlobalFrame();
            limpiarFormulario();
        }else{
            MensajeUtil.mostrarError(logInPanel, "Usuario o contraseña invalidos.");
        }
    }

    public void limpiarFormulario() {
        logInPanel.getUsuarioTxt().setText("");
        logInPanel.getContrseñaTxt().setText("");
    }
}
