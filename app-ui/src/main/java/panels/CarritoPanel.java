package panels;

import componentes.LabelTitulo;
import componentes.ProductoCarritoCard;

import javax.swing.*;

public class CarritoPanel extends JPanel {
    private LabelTitulo tituloEstilo;
    private JPanel contenedorProductosPanel;
    private OpcionesCarritoPanel opcionesCarritoPanel;

    private final String TITULO_CARRITO = "Tu Carrito";

    public CarritoPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        iniciarComponentes();
        iniciarTitulo();
        agregarComponentes();
    }

    private void iniciarComponentes() {
        contenedorProductosPanel = new JPanel();
        contenedorProductosPanel.setOpaque(false);
        contenedorProductosPanel.setLayout(new BoxLayout(contenedorProductosPanel, BoxLayout.Y_AXIS));

        opcionesCarritoPanel = new OpcionesCarritoPanel();
    }

    public void iniciarTitulo() {
        tituloEstilo = new LabelTitulo(TITULO_CARRITO);
    }

    public void agregarComponentes() {
        add(tituloEstilo);
        add(contenedorProductosPanel);
        add(opcionesCarritoPanel);
    }

    public void agregarProducto(ProductoCarritoCard card) {
        contenedorProductosPanel.add(card);
        contenedorProductosPanel.revalidate();
        contenedorProductosPanel.repaint();
    }
}
