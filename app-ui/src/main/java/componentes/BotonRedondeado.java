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
    private boolean isHovered = false;

    public BotonRedondeado(String texto) {
        super(texto);

        setFont(FontLoader.cargarFont(Estilo.FONT_NORMAL, 18));
        setForeground(Color.BLACK);
        setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Hover
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

        // Definir coordenadas para el borde
        int grosorBorde = 3;
        int x = grosorBorde / 2;
        int y = grosorBorde / 2;
        int ancho = getWidth() - grosorBorde;
        int alto = getHeight() - grosorBorde;

        if (isHovered){
            g2.setColor(colorHover);
        }else{
            g2.setColor(colorFondo);
        }

        // Borde
        g2.fillRoundRect(x, y, ancho, alto, radio, radio);
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(3));
        g2.drawRoundRect(x, y, ancho, alto, radio, radio);
        g2.dispose();

        super.paintComponent(g);
    }
}
