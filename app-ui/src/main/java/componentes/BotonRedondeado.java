package componentes;

import util.Estilo;
import util.FontLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BotonRedondeado extends JButton {
    private final int radio = 6;
    private final Color colorFondo = Estilo.AMARILLO_GENIUS;
    private Color colorHover = new Color(244, 244, 95);
    private boolean isHovered = false;

    public BotonRedondeado(String texto) {
        super(texto);

        setFont(FontLoader.cargarFont(Estilo.FONT_NORMAL, 16));
        setForeground(Color.BLACK);

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

        if (isHovered){
            g2.setColor(colorHover);
        }else{
            g2.setColor(colorFondo);
        }

        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radio, radio);
        g2.dispose();

        super.paintComponent(g);
    }
}
