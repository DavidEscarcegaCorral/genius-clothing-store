package control;

import frames.GlobalFrame;
import frames.LogInFrame;

public class NavegacionControl {
    private LogInFrame logInFrame;
    private GlobalFrame globalFrame;

    public NavegacionControl() {
        this.logInFrame = null;
        this.globalFrame = null;
    }

    public void setGlobalFrame(GlobalFrame globalFrame) {
        this.globalFrame = globalFrame;
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

    public void cerrarLoginFrame() {
        logInFrame.dispose();
        globalFrame.getHeader().actualizarUsuario();
    }

    public void irADetallePedido(String idProdcuto) {

    }
}
