package panels;

import util.Estilo;
import util.FontLoader;

import javax.swing.*;
import java.awt.*;

public class MainPagePanel extends JPanel {
    // Categorias MainPage
    private JLabel novedadesLbl;
    private JLabel ofertasLbl;
    private JLabel paraHombreLbl;
    private JLabel paraMujerLbl;

    private JPanel panelNovedades;
    private JPanel panelOfertas;

    public MainPagePanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setOpaque(true);
        setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        cargarSecciones();

    }

    public void cargarSecciones() {
        // Novedades
        novedadesLbl = new JLabel("Novedades");
        novedadesLbl.setForeground(Color.BLACK);
        novedadesLbl.setFont(FontLoader.cargarFont(Estilo.FONT_OPNS_COND_REGULAR, 45));
        add(novedadesLbl);
    }
}

