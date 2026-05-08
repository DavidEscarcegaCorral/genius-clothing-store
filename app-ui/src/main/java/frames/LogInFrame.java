package frames;

import panels.LogInPantalla;
import util.Estilo;

import javax.swing.*;
import java.awt.*;

public class LogInFrame extends JFrame {
    public LogInPantalla logInPantalla;

    public LogInFrame() {
        // Configuracion del frame
        setTitle("Log In");
        getContentPane().setBackground(Estilo.AMARILLO_GENIUS);
        setMinimumSize(new Dimension(300, 200));
        setPreferredSize(new Dimension(1200, 800));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel principal del frame
        logInPantalla = new LogInPantalla();
        add(logInPantalla);

        // Emapquetado del frame
        pack();
        setLocationRelativeTo(null);
    }

    public LogInPantalla getLogInPanel() {
        return this.logInPantalla;
    }
}
