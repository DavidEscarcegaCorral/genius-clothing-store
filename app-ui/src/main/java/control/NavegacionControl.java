package control;

import frames.GlobalFrame;
import frames.LogInFrame;
import panels.ProductoDetallePanel;

public class NavegacionControl {
    private LogInFrame logInFrame;
    private GlobalFrame globalFrame;

    public static final String SCREEN_MAIN_PAGE = "MAIN_PAGE";
    public static final String SCREEN_DETALLE_PRODUCTO = "DETALLE_PRODUCTO";
    public static final String SCREEN_LOGIN = "LOGIN";

    private String pantallaActual;

    public NavegacionControl() {
        this.logInFrame = null;
        this.globalFrame = null;
        this.pantallaActual = null;
    }

    public void setGlobalFrame(GlobalFrame globalFrame) {
        if (globalFrame == null) {
            throw new IllegalArgumentException("El globalFrame es null");
        }
        this.globalFrame = globalFrame;
        this.globalFrame.getHeader().setHomeAction(e -> irAHome());
    }

    public void setLogInFrame(LogInFrame logInFrame) {
        if (logInFrame == null) {
            throw new IllegalArgumentException("LogInFrame no puede ser null");
        }
        this.logInFrame = logInFrame;
    }

    public void abrirGlobalFrame() {
        validarGlobalFrame();

        if (logInFrame != null) {
            logInFrame.dispose();
        }

        globalFrame.getHeader().actualizarUsuario();
        globalFrame.setVisible(true);
        pantallaActual = SCREEN_MAIN_PAGE;
    }

    public void abrirLoginFrame() {
        validarLogInFrame();

        if (globalFrame != null) {
            globalFrame.dispose();
        }

        logInFrame.setVisible(true);
        pantallaActual = SCREEN_LOGIN;
    }

    public void mostrarDetalleProducto(ProductoDetallePanel detallePanel) {
        validarGlobalFrame();

        if (detallePanel == null) {
            throw new IllegalArgumentException("ProductoDetallePanel no puede ser null");
        }

        globalFrame.cambiarPantallaDetalle(detallePanel);
        globalFrame.mostrarPantalla(SCREEN_DETALLE_PRODUCTO);
        pantallaActual = SCREEN_DETALLE_PRODUCTO;
    }

    public void irAHome() {
        validarGlobalFrame();
        globalFrame.mostrarPantalla(SCREEN_MAIN_PAGE);
        pantallaActual = SCREEN_MAIN_PAGE;
    }

    private void validarGlobalFrame() {
        if (globalFrame == null) {
            throw new IllegalStateException("GlobalFrame no ha sido inicializado");
        }
    }

    private void validarLogInFrame() {
        if (logInFrame == null) {
            throw new IllegalStateException("LogInFrame no ha sido inicializado");
        }
    }
}
