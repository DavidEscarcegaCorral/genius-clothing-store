package componentes;

import util.FontLoader;
import util.RoundBorder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class CampoContrseñaGenius extends JPasswordField {
    private String textoPH;
    private float cornerRadius;

    public CampoContrseñaGenius(String textoPH, float cornerRadius, Color colorFondo, Color colorTexto){
        this.textoPH = textoPH;
        this.cornerRadius = cornerRadius;
        setBackground(colorFondo);
        setForeground(colorTexto);

        setFont(FontLoader.cargarFont("programme_normal.ttf", 16));
        setBorder(new EmptyBorder(0, 10, 0, 10));
        setBorder(new RoundBorder(0, Color.black));
        setText(this.textoPH);

        // Borrar texto al darle click
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (getText().equals(textoPH)) {
                    setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().isEmpty()) {
                    setText(textoPH);
                }
            }
        });
    }
}
