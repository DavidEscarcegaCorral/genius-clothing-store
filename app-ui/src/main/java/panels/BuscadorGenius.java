package panels;

import componentes.CampoTextoGenius;

import javax.swing.*;
import java.awt.*;

public class BuscadorGenius extends JPanel {
    private CampoTextoGenius campoTextoGenius;

    public BuscadorGenius(){
        setOpaque(false);

        // Campo de texto de busqueda
        campoTextoGenius = new CampoTextoGenius("Buscar", 0, Color.white);

        // Añadir componentes
        add(campoTextoGenius);
    }

}
