package componentes;

import util.Estilo;
import util.FontLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BotonIcono extends JButton {
    private boolean underLineOnHover;
    public boolean isHovered = false;

    // Valores por defecto
    private String fontNombre = Estilo.FONT_PROGRAMME_NORMAL;
    private int tamaño = 20;

    public BotonIcono(String texto) {
        this(texto, true);
    }

    public BotonIcono(String texto, boolean underLineOnHover) {
        super(texto);
        this.underLineOnHover = underLineOnHover;
        iniciarBoton();
    }

    public BotonIcono(Icon icon) {
        super(icon);
        this.underLineOnHover = false;
        iniciarBoton();
    }

    public void iniciarBoton() {
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setOpaque(false);
        setMargin(new Insets(0, 0, 0, 0));
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


        if (underLineOnHover) {
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
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (underLineOnHover && isHovered && getText() != null && !getText().isEmpty()) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setColor(getForeground());

            // Ajuste de posicon
            FontMetrics fm = g2.getFontMetrics(getFont());
            int textX = (getWidth() - fm.stringWidth(getText())) / 2;
            int textY = (getHeight() + fm.getAscent() - fm.getDescent()) / 2;

            if (getHorizontalAlignment() == SwingConstants.LEFT) {
                textX = getInsets().left;
            }

            g2.drawLine(textX, textY + 1,
                    textX + fm.stringWidth(getText()), textY + 1);
            g2.dispose();
        }
    }

    public void setUnderLineOnHover(boolean underLineOnHover) {
        this.underLineOnHover = underLineOnHover;
        repaint();
    }

    public void setFont(String fontNombre, int tamaño) {
        setFont(FontLoader.cargarFont(fontNombre, tamaño));
    }

}
