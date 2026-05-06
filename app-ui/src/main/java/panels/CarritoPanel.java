package panels;

import javax.swing.*;

public class CarritoPanel extends JPanel {
    private JLabel titutloLBl;
    private JPanel contenedorProductosPanel;
    private JPanel opcionesCarritoPanel;

    private final String TITULO_CARRITO = "Tu Carrito";

    public CarritoPanel() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    }

    private void iniciarComponentes() {
        // Panel para apilar los prodcutos
        contenedorProductosPanel = new JPanel();
        contenedorProductosPanel.setOpaque(false);
        contenedorProductosPanel.setLayout(new BoxLayout(contenedorProductosPanel, BoxLayout.Y_AXIS));

        opcionesCarritoPanel = new JPanel();
        opcionesCarritoPanel.setOpaque(false);
    }


}
