package control.auth;

import autorizacion.IAutorizacionFacade;
import autorizacion.SesionService;
import control.navegacion.NavegacionControl;
import dto_request.UsuarioLoginDTO;
import objetosnegocio.UsuarioBO;
import panels.Header;
import panels.LogInPantalla;
import util.ValidadorFormato;

import static util.MensajeUtil.mostrarError;

public class LoginControl {
    private final LogInPantalla logInPantalla;
    private final Header header;
    private final IAutorizacionFacade autorizacionService;
    private final NavegacionControl navegacionControl;

    public LoginControl(LogInPantalla logInPantalla,
                        Header header,
                        IAutorizacionFacade autorizacionService,
                        NavegacionControl navegacionControl) {
        this.logInPantalla = logInPantalla;
        this.header = header;
        this.autorizacionService = autorizacionService;
        this.navegacionControl = navegacionControl;
        iniciarlizarListeners();
    }

    public void iniciarlizarListeners() {
        header.getUsuarioBtn().addActionListener(e -> iniciarSesion());
        logInPantalla.getIngresarBtn().addActionListener(e -> proceasrLogin());
    }

    public void iniciarSesion() {
        navegacionControl.abrirLoginFrame();
    }

    public void proceasrLogin() {
        // Capturar los datos
        String usuario = logInPantalla.getUsuarioTxt().getText();
        String contraseña = logInPantalla.getContrseñaTxt().getText();

        // Validacion de formato de usuario
        if (!ValidadorFormato.esUsuarioValido(usuario)) {
            mostrarError(logInPantalla, "El nombre de usuario no puede contener espacios ni esar vacio.");
            return;
        }

        // Crear el DTO
        UsuarioLoginDTO usuarioLoginDTO = new UsuarioLoginDTO(usuario, contraseña);

        // mejorar el manejo de excepciones
        try {
            UsuarioBO userLogeado = autorizacionService.verificarLogin(usuarioLoginDTO);
            SesionService.iniciarSesion(userLogeado);
            navegacionControl.abrirGlobalFrame();
        } catch (Exception e) {
            mostrarError(logInPantalla, e.getMessage());
        }
    }

    public void limpiarFormulario() {
        logInPantalla.getUsuarioTxt().setText("");
        logInPantalla.getContrseñaTxt().setText("");
    }
}
