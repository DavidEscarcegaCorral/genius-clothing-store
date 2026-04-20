package panels;

import componentes.LogoGenius;
import util.Estilo;

import javax.swing.*;
import java.awt.*;

public class Header extends JPanel {
    private JPanel panelSuperior;
    private LogoGenius homeButton;

    public Header(){
        setBackground(Color.BLACK);

        // Layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        panelSuperior = new JPanel();

        // Borde amarillo
        setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Estilo.AMARILLO_GENIUS));


    }


}
