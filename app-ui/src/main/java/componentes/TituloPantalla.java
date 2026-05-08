package componentes;

import util.Estilo;
import util.FontLoader;

import javax.swing.*;
import java.awt.*;

public class TituloPantalla extends JComponent {
    private String texto;
    private int offsetSombra = 4;
    private final int TAMAÑO_TITULO = 60;
    private final Font FONT_TITULO = FontLoader.cargarFont(Estilo.FONT_PROGRAMME_NORMAL, TAMAÑO_TITULO);
    private final int ANCHO_FIJO = 500;
    private final int ALTO_FIJO = 80;

    public TituloPantalla(String texto) {
        this.texto = texto;
        setPreferredSize(new Dimension(ANCHO_FIJO, ALTO_FIJO));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setFont(FONT_TITULO);
        FontMetrics fm = g2.getFontMetrics();

        int x = offsetSombra;
        int y = fm.getAscent();

        // Sombra
        g2.setColor(Color.BLACK);
        g2.drawString(texto, x - offsetSombra, y + offsetSombra);

        // Texto
        g2.setColor(Estilo.AMARILLO_GENIUS);
        g2.drawString(texto, x, y);

        g2.dispose();
    }

    public void setText(String nuevoTexto) {
        this.texto = nuevoTexto;
        repaint();
    }

    public String getText() {
        return texto;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(ANCHO_FIJO, ALTO_FIJO);
    }

    @Override
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }

    @Override
    public Dimension getMaximumSize() {
        return getPreferredSize();
    }
}
