package panels;

import util.Estilo;
import util.FontLoader;

import javax.swing.*;

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
        cargarSecciones();

    }

    public void cargarSecciones() {
        // Novedades
        novedadesLbl = new JLabel("Novedades");
        novedadesLbl.setFont(FontLoader.cargarFont(Estilo.FONT_OPNS_COND_REGULAR, 65));
        add(novedadesLbl);
    }
}

