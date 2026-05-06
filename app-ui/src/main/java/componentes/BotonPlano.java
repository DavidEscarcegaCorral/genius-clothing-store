package componentes;

import util.Estilo;
import util.FontLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

public class BotonPlano extends JButton {
    private final Color colorFondo = Estilo.AMARILLO_GENIUS;
    private final Color colorHover = Estilo.AMARILLO_GENIUS_HOVER;
    private final int offsetSombra = 6;
    private boolean isHovered = false;

    public BotonPlano(String texto) {
        super(texto);

        setFont(FontLoader.cargarFont(Estilo.FONT_PROGRAMME_NORMAL, 20));
        setForeground(Color.BLACK);
        setBorder(BorderFactory.createEmptyBorder(14, 19 + offsetSombra, 18, 19));
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                isHovered = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                isHovered = false;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();

        g2.setColor(Color.BLACK);
        g2.fillRect(offsetSombra, offsetSombra, w - offsetSombra, h - offsetSombra);

        if (getModel().isPressed()) {
            g2.translate(2, 2);
        }

        g2.setColor(colorFondo);
        g2.fillRect(0, 0, w - offsetSombra, h - offsetSombra);

        g2.setColor(Color.BLACK);
        FontMetrics fm = g2.getFontMetrics();
        Rectangle2D r = fm.getStringBounds(getText(), g2);

        int xTexto = 15;
        int yTexto = (h - offsetSombra + fm.getAscent()) / 2 - 2;
        g2.drawString(getText(), xTexto, yTexto);

        g2.setFont(new Font("Monospaced", Font.BOLD, 22));
        g2.drawString(">", w - offsetSombra - 30, yTexto);

        g2.dispose();
    }

    public Dimension getPreferredSize() {
        Dimension dim = super.getPreferredSize();
        return new Dimension(dim.width + offsetSombra, dim.height + offsetSombra);
    }
}
