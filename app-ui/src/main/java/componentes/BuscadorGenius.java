package componentes;

import javax.swing.*;

public class BuscadorGenius extends JPanel {
    private CampoTextoGenius campoTextoGenius;

    public BuscadorGenius(){
        setOpaque(false);

        // Campo de texto de busqueda
        campoTextoGenius = new CampoTextoGenius("Buscar", 0);

        // Añadir componentes
        add(campoTextoGenius);
    }

}
