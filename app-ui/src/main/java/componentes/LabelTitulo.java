package componentes;

import util.Estilo;

import javax.swing.*;
import java.awt.*;

public class LabelTitulo extends JLabel {
    private int offsetSombra = 6;

    public LabelTitulo(String texto) {
        super(texto);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        FontMetrics fm = g2.getFontMetrics();
        int x = 0;
        int y = fm.getAscent();

        // Sombra
        g2.setColor(Color.BLACK);
        g2.drawString(getText(), x + offsetSombra, y + offsetSombra);

        // Texto
        g2.setColor(Estilo.AMARILLO_GENIUS);
        g2.drawString(getText(), x, y);

        g2.dispose();
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension d = super.getPreferredSize();
        return new Dimension(d.width + offsetSombra, d.height + offsetSombra);
    }
}
