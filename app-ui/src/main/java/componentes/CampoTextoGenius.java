package componentes;

import util.FontLoader;
import util.RoundBorder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CampoTextoGenius extends JTextField {
    private String textoPH;
    private int cornerRadius;
    private Color colorFondo;
    private Color colorTexto;
    private int ancho;
    private int alto;

    private final String fontName = "programme_normal.ttf";
    private final int fontSize = 16;

    public CampoTextoGenius(String textoPH, int cornerRadius, Color colorFondo, Color colorTexto, int ancho, int alto) {
        this.textoPH = textoPH;
        this.cornerRadius = cornerRadius;
        this.colorFondo = colorFondo;
        this.colorTexto = colorTexto;
        this.ancho = ancho;
        this.alto = alto;

        setBackground(this.colorFondo);
        setForeground(this.colorTexto);
        setPreferredSize(new Dimension(this.ancho, this.alto));
        setOpaque(false);
        setFont(FontLoader.cargarFont(fontName, fontSize));
        setCaretColor(this.colorTexto);

        setBorder(BorderFactory.createCompoundBorder(
                new RoundBorder(this.cornerRadius, Color.black),
                new EmptyBorder(0, 10, 0, 10)
        ));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);

        // Capa de te
        super.paintComponent(g);
        g2.setColor(colorTexto);
        g2.setFont(FontLoader.cargarFont(fontName, fontSize));

        if (getText().isEmpty()) {
            FontMetrics fm = g2.getFontMetrics();
            int cHeight = getSize().height;
            Insets insets = getInsets();

            int x = insets.left;
            int y = (cHeight - fm.getHeight()) / 2 + fm.getAscent();

            g2.drawString(textoPH, x, y);

        }
        g2.dispose();
    }

    @Override
    public Dimension getMinimumSize() {
        return new Dimension(ancho, alto);
    }
}
