package panels;

import componentes.LabelTitulo;

import javax.swing.*;

public class PantallaBase extends JPanel {
    protected LabelTitulo tituloPantalla;

    public PantallaBase() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setOpaque(false);
    }

}
