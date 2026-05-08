package panels;

import componentes.TituloPantalla;

import javax.swing.*;
import java.awt.*;

public class PantallaBase extends JPanel {
    protected TituloPantalla tituloPantalla;
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
        tituloPantalla = new TituloPantalla(TITULO);
        tituloPantalla.setAlignmentX(Component.RIGHT_ALIGNMENT);
        add(tituloPantalla);
    }

}
