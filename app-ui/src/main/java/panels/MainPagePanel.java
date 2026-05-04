package panels;

import componentes.ProductoCard;
import dtos.ProductoCardDTO;
import util.Estilo;
import util.FontLoader;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainPagePanel extends JPanel {
    private JPanel panelNovedades;
    private JPanel panelOfertas;

    public MainPagePanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setOpaque(true);
        setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        cargarSecciones();

    }

    public void cargarSecciones() {
        add(Box.createRigidArea(new Dimension(0, 15)));
        add(crearEtiquetaSeccion("Novedades"));
        add(Box.createRigidArea(new Dimension(0, 15)));
        // Primera seccion
        panelNovedades = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 15));
        add(panelNovedades);

        add(Box.createRigidArea(new Dimension(0, 30)));
    }

    public JLabel crearEtiquetaSeccion(String seccion) {
        JLabel label = new JLabel(seccion);
        label.setForeground(Color.black);
        label.setFont(FontLoader.cargarFont(Estilo.FONT_OPNS_COND_REGULAR, 45));
        return label;
    }

    public void setNovedadesSeccion(List<ProductoCardDTO> productos) {
        llenarPanel(panelNovedades, productos);
    }

    public void llenarPanel(JPanel panel, List<ProductoCardDTO> productos) {
        panel.removeAll();
        for (ProductoCardDTO productoCardDTO : productos) {
            panel.add(new ProductoCard(productoCardDTO));
        }
        panel.revalidate();
        panel.repaint();
    }
}

