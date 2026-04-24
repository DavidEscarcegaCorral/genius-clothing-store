package panels;

import componentes.CampoTextoGenius;

import javax.swing.*;
import java.awt.*;

public class BuscadorGenius extends JPanel {
    private CampoTextoGenius campoTextoGenius;
    private JButton buscarBtn;

    public BuscadorGenius() {
        setOpaque(false);

        // Campo de texto de busqueda
        campoTextoGenius = new CampoTextoGenius("Buscar", 0, Color.white, Color.BLACK, 240, 30);

        // Añadir componentes
        add(campoTextoGenius);
    }
}
