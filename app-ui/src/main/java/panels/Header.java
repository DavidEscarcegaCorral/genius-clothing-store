package panels;

import componentes.LogoGenius;
import util.Estilo;

import javax.swing.*;
import java.awt.*;

public class Header extends JPanel {
    private LogoGenius homeButton;

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

        // Borde amarillo
        setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Estilo.AMARILLO_GENIUS));


    }


}
