package util;

import javax.swing.*;
import java.awt.*;

public class MensajeUtil {

    public static void mostrarError(Component parentComponent, String mensaje){
        JOptionPane.showConfirmDialog(
                parentComponent,
                mensaje,
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }

    public static void mostrarMostrarExito(Component parentComponent, String mensaje){
        JOptionPane.showConfirmDialog(
                parentComponent,
                mensaje,
                "Exito",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void mostrarMostrarAdvertencia(Component parentComponent, String mensaje){
        JOptionPane.showConfirmDialog(
                parentComponent,
                mensaje,
                "Advertencia",
                JOptionPane.WARNING_MESSAGE
        );
    }


}
