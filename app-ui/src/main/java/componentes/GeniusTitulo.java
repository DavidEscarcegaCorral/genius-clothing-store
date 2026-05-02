package componentes;

import util.Estilo;

import javax.swing.*;
import java.awt.*;

public class GeniusTitulo extends JComponent {
    private static final String NOMBRE = "GENIUS";
    private static final Font FONT = Estilo.FONT_LOGO_LABEL;

    public GeniusTitulo() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2d.setFont(FONT);
        FontMetrics fm = g2d.getFontMetrics();
        int x = (getWidth() - fm.stringWidth(NOMBRE)) / 2;
        int y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();

        // Sombre
        g2d.setColor(Color.BLACK);
        g2d.drawString(NOMBRE, x - 4, y + 4);

        // Texto
        g2d.setColor(Estilo.AMARILLO_GENIUS);
        g2d.drawString(NOMBRE, x, y);

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 150);
    }
}
