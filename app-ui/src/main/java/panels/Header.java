package panels;

import componentes.LogoGenius;
import util.Estilo;

import javax.swing.*;
import java.awt.*;

public class Header extends JPanel {
    private LogoGenius homeButton;
    private BuscadorGenius buscadorGenius;

    public Header() {
        setBackground(Color.BLACK);

        // Layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Primera seccion
        homeButton = new LogoGenius();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 25, 5, 0);
        add(homeButton, gbc);

        // Segunda seccion
        buscadorGenius = new BuscadorGenius();
        gbc.gridx = 1;
        gbc.weightx = 0.9;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(buscadorGenius, gbc);

        // Borde amarillo
        setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Estilo.AMARILLO_GENIUS));


    }


}
