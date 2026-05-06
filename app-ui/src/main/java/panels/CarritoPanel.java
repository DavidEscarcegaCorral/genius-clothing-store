package panels;

import componentes.LabelTitulo;

import javax.swing.*;

public class CarritoPanel extends JPanel {
    private LabelTitulo tituloEstilo;
    private JPanel contenedorProductosPanel;
    private OpcionesCarritoPanel opcionesCarritoPanel;

    private final String TITULO_CARRITO = "Tu Carrito";

    public CarritoPanel() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        iniciarComponentes();
        iniciarTitulo();
        agregarComponentes();
    }

    private void iniciarComponentes() {
        // Panel para apilar los prodcutos
        contenedorProductosPanel = new JPanel();
        contenedorProductosPanel.setOpaque(false);
        contenedorProductosPanel.setLayout(new BoxLayout(contenedorProductosPanel, BoxLayout.Y_AXIS));

        // Panel con las opciones del carrito
        opcionesCarritoPanel = new OpcionesCarritoPanel();

    }

    public void iniciarTitulo() {
        tituloEstilo = new LabelTitulo(TITULO_CARRITO);
    }

    public void agregarComponentes() {
        add(contenedorProductosPanel);
        add(opcionesCarritoPanel);
    }
}
