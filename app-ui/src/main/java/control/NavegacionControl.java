package control;

import frames.GlobalFrame;
import frames.LogInFrame;
import panels.ProductoDetallePanel;

public class NavegacionControl {
    private LogInFrame logInFrame;
    private GlobalFrame globalFrame;

    public NavegacionControl() {
        this.logInFrame = null;
        this.globalFrame = null;

    }

    public void setGlobalFrame(GlobalFrame globalFrame) {
        this.globalFrame = globalFrame;
        if (this.globalFrame != null) {
            this.globalFrame.getHeader().setHomeAction(e -> irAHome());
        }
    }

    public void setLogInFrame(LogInFrame logInFrame) {
        this.logInFrame = logInFrame;
    }

    public void abrirGlobalFrame() {
        if (logInFrame != null) {
            logInFrame.dispose();
        }

        globalFrame.getHeader().actualizarUsuario();
        globalFrame.setVisible(true);

    }

    public void abrirLoginFrame() {
        globalFrame.dispose();
        logInFrame.setVisible(true);
    }

    public void mostrarDetalleProducto(ProductoDetallePanel detallePanel) {
        if (globalFrame != null) {
            globalFrame.cambiarPantallaDetalle(detallePanel);
            globalFrame.mostrarPantalla("DETALLE_PRODCUTO");
        }
    }

    public void irAHome() {
        globalFrame.mostrarPantalla("MAIN_PAGE");
    }
}
