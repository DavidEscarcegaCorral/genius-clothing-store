package componentes;

import util.Estilo;
import util.FontLoader;

import javax.swing.*;
import java.awt.*;

public class LabelTitulo extends JLabel {
    private int offsetSombra = 4;
    private final int TAMAÑO_TITULO = 60;
    private final Font FONT_TITULO = FontLoader.cargarFont(Estilo.FONT_PROGRAMME_NORMAL, TAMAÑO_TITULO);

    public LabelTitulo(String texto) {
        super(texto);
        setFont(FONT_TITULO);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        FontMetrics fm = g2.getFontMetrics(getFont());
        int x = offsetSombra;
        int y = fm.getAscent();

        g2.setColor(Color.BLACK);
        g2.drawString(getText(), x - offsetSombra, y + offsetSombra);

        g2.setColor(Estilo.AMARILLO_GENIUS);
        g2.drawString(getText(), x, y);

        g2.dispose();
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension d = super.getPreferredSize();
        return new Dimension(d.width + offsetSombra * 2, d.height + offsetSombra);
    }
}
