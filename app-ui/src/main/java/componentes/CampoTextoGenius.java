package componentes;

import util.FontLoader;
import util.RoundBorder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class CampoTextoGenius extends JTextField {
    private String textoPH;
    private float cornerRadius;
    private Color colorFondo;
    private Color colorTexto;
    private int ancho = 240;
    private int alto = 35;

    private final String fontName = "programme_normal.ttf";
    private final int fontSize = 16;

    public CampoTextoGenius(String textoPH, float cornerRadius, Color colorFondo, Color colorTexto) {
        this.textoPH = textoPH;
        this.cornerRadius = cornerRadius;
        this.colorFondo = colorFondo;
        this.colorTexto = colorTexto;
        setBackground(this.colorFondo);
        setForeground(this.colorTexto);
        setPreferredSize(new Dimension(ancho, alto));

        setFont(FontLoader.cargarFont(fontName, fontSize));
        setBorder(new EmptyBorder(0, 10, 0, 10));
        setBorder(new RoundBorder(0, Color.black));

    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(colorTexto);
        g2.setFont(FontLoader.cargarFont(fontName, fontSize));

        if (getText().isEmpty()) {
            FontMetrics fm = g2.getFontMetrics();
            int cHeight = getSize().height;
            Insets insets = getInsets();

            int x = insets.left;
            int y = (cHeight - fm.getHeight()) / 2 + fm.getAscent();

            g2.drawString(textoPH, x, y);
            g2.dispose();

        }
    }
}
