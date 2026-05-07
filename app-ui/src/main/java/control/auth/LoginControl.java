package control.auth;

import autorizacion.IAutorizacionService;
import autorizacion.SesionService;
import control.navegacion.NavegacionControl;
import dtos.CredencialesDTO;
import objetosnegocio.UsuarioBO;
import panels.Header;
import panels.LogInPanel;
import util.ValidadorFormato;

import static util.MensajeUtil.mostrarError;

public class LoginControl {
    private final LogInPanel logInPanel;
    private final Header header;
    private final IAutorizacionService autorizacionService;
    private final NavegacionControl navegacionControl;

    public LoginControl(LogInPanel logInPanel,
                        Header header,
                        IAutorizacionService autorizacionService,
                        NavegacionControl navegacionControl) {
        this.logInPanel = logInPanel;
        this.header = header;
        this.autorizacionService = autorizacionService;
        this.navegacionControl = navegacionControl;
        iniciarlizarListeners();
    }

    public void iniciarlizarListeners() {
        header.getUsuarioBtn().addActionListener(e -> iniciarSesion());
        logInPanel.getIngresarBtn().addActionListener(e -> proceasrLogin());
    }

    public void iniciarSesion() {
        navegacionControl.abrirLoginFrame();
    }

    public void proceasrLogin() {
        // Capturar los datos
        String usuario = logInPanel.getUsuarioTxt().getText();
        String contraseña = logInPanel.getContrseñaTxt().getText();

        // Validacion de formato de usuario
        if (!ValidadorFormato.esUsuarioValido(usuario)) {
            mostrarError(logInPanel, "El nombre de usuario no puede contener espacios ni esar vacio.");
            return;
        }

        // Crear el DTO
        CredencialesDTO credencialesDTO = new CredencialesDTO(usuario, contraseña);

        // mejorar el manejo de excepciones
        try {
            UsuarioBO userLogeado = autorizacionService.verificarLogin(credencialesDTO);
            SesionService.iniciarSesion(userLogeado);
            navegacionControl.abrirGlobalFrame();
        } catch (Exception e) {
            mostrarError(logInPanel, e.getMessage());
        }
    }

    public void limpiarFormulario() {
        logInPanel.getUsuarioTxt().setText("");
        logInPanel.getContrseñaTxt().setText("");
    }
}
