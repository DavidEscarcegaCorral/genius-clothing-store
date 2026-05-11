package panels;

import componentes.ProductoCarritoCard;

import javax.swing.*;
import java.awt.*;

public class CarritoPantalla extends PantallaBase {
    private JPanel panelContenedor;
    private JPanel contenedorProductosPanel;
    private OpcionesCarritoPanel opcionesCarritoPanel;

    private final String TITULO_CARRITO = "Tu Carrito";

    public CarritoPantalla() {
        super("Tu Carrito", 70);
        iniciarComponentes();
        agregarComponentes();
    }

    private void iniciarComponentes() {
        panelContenedor = new JPanel(new FlowLayout(FlowLayout.LEFT, 100, 15));

        contenedorProductosPanel = new JPanel();
        contenedorProductosPanel.setOpaque(false);
        contenedorProductosPanel.setLayout(new BoxLayout(contenedorProductosPanel, BoxLayout.Y_AXIS));

        opcionesCarritoPanel = new OpcionesCarritoPanel();
    }

    public void agregarComponentes() {
        panelContenedor.add(contenedorProductosPanel);
        panelContenedor.add(opcionesCarritoPanel);
        add(panelContenedor);
    }

    public void agregarProducto(ProductoCarritoCard card) {
        contenedorProductosPanel.add(card);
        contenedorProductosPanel.revalidate();
        contenedorProductosPanel.repaint();
    }

    public void agregarEspacioVertical(int pixels) {
        contenedorProductosPanel.add(Box.createVerticalStrut(pixels));
        contenedorProductosPanel.revalidate();
        contenedorProductosPanel.repaint();
    }

    public void limpiarProductos() {
        contenedorProductosPanel.removeAll();
        contenedorProductosPanel.revalidate();
        contenedorProductosPanel.repaint();
    }
}
