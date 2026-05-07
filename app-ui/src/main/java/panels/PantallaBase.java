package panels;

import componentes.LabelTitulo;

import javax.swing.*;
import java.awt.*;

public class PantallaBase extends JPanel {
    protected LabelTitulo tituloPantalla;
    private final String TITULO;

    public PantallaBase(String titulo) {
        this(titulo, 30);
    }

    public PantallaBase(String titulo, int tamañoTitulo) {
        TITULO = titulo;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setOpaque(false);
        iniciarTitulo(tamañoTitulo);
    }

    public void iniciarTitulo(int tamañoFuente) {
        tituloPantalla = new LabelTitulo(TITULO);
        tituloPantalla.setAlignmentX(Component.RIGHT_ALIGNMENT);
        add(tituloPantalla);
    }

}
