package frames;

import panels.LogInPanel;
import util.Estilo;

import javax.swing.*;
import java.awt.*;

public class LogInFrame extends JFrame {
    public LogInPanel logInPanel;

    public LogInFrame() {
        // Configuracion del frame
        setTitle("Log In");
        getContentPane().setBackground(Estilo.AMARILLO_GENIUS);
        setMinimumSize(new Dimension(300, 200));
        setPreferredSize(new Dimension(1200, 800));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel principal del frame
        logInPanel = new LogInPanel();
        add(logInPanel);

        // Emapquetado del frame
        pack();
        setLocationRelativeTo(null);
    }

    public LogInPanel getLogInPanel() {
        return this.logInPanel;
    }
}
