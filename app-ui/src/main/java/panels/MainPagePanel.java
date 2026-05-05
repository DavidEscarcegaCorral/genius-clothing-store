package panels;

import componentes.ProductoCard;
import dtos.ProductoCardDTO;
import util.Estilo;
import util.FontLoader;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainPagePanel extends JPanel {
    private JPanel panelNovedades;
    private JPanel panelOfertas;
    private List<ProductoCard> cardsActuales = new ArrayList<>();

    public MainPagePanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setOpaque(true);
        setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        cargarSecciones();

    }

    public void cargarSecciones() {
        add(crearEtiquetaSeccion("Novedades"));

        // Primera seccion
        panelNovedades = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
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
        cardsActuales.clear();
        llenarPanel(panelNovedades, productos);
    }

    public void llenarPanel(JPanel panel, List<ProductoCardDTO> productos) {
        panel.removeAll();
        for (ProductoCardDTO productoCardDTO : productos) {
            ProductoCard card = new ProductoCard(productoCardDTO);

            cardsActuales.add(card);
            panel.add(card);
        }
        panel.revalidate();
        panel.repaint();
    }

    public List<ProductoCard> getCardsActuales() {
        return cardsActuales;
    }
}

