package componentes;

import util.Estilo;

import javax.swing.*;
import java.awt.*;

public class LogoGenius extends JButton {
    public LogoGenius() {
        super("Genius");

        // Visual
        setFont(Estilo.FONT_LOGO);
        setForeground(Estilo.AMARILLO_GENIUS);

        // Estilizacion
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setOpaque(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Alineacion
        setHorizontalAlignment(SwingConstants.LEFT);
        setMargin(new Insets(0, 0, 0, 0));

    }
}
