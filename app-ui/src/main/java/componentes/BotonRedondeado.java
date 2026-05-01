package componentes;

import util.Estilo;
import util.FontLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BotonRedondeado extends JButton {
    private final int radio = 26;
    private final Color colorFondo = Estilo.AMARILLO_GENIUS;
    private final Color colorHover = Estilo.AMARILLO_GENIUS_HOVER;
    private final int grosorBorde = 2;
    private final int offsetSombra = 6;
    private boolean isHovered = false;

    public BotonRedondeado(String texto) {
        super(texto);

        setFont(FontLoader.cargarFont(Estilo.FONT_PROGRAMME_NORMAL, 24));
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

        int x = grosorBorde + offsetSombra;
        int y = grosorBorde;
        int ancho = getWidth() - (grosorBorde * 2) - (offsetSombra * 2);
        int alto = getHeight() - (grosorBorde * 2) - offsetSombra;

        g2.setColor(Color.BLACK);
        g2.fillRoundRect(x - offsetSombra, y + offsetSombra, ancho, alto, radio, radio);

        g2.setColor(isHovered ? colorHover : colorFondo);
        g2.fillRoundRect(x, y, ancho, alto, radio, radio);

        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(grosorBorde, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2.drawRoundRect(x, y, ancho, alto, radio, radio);
        g2.dispose();

        super.paintComponent(g);
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension dim = super.getPreferredSize();
        return new Dimension(dim.width + offsetSombra, dim.height + offsetSombra);
    }
}
