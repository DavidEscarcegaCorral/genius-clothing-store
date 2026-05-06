package frames;

import panels.CarritoPanel;
import panels.Header;
import panels.MainPagePanel;
import panels.ProductoDetallePanel;

import javax.swing.*;
import java.awt.*;

public class GlobalFrame extends JFrame {

    // Constantes de las pantallas
    public static final String SCREEN_MAIN_PAGE = "MAIN_PAGE";
    public static final String SCREEN_DETALLE_PRODUCTO = "DETALLE_PRODUCTO";
    public static final String SCREEN_CARRITO = "CARRITO";

    private JPanel panelPrincipal;
    private JPanel panelContenido;
    private CardLayout cardLayout;

    private Header header;

    // Paneles
    private MainPagePanel mainPagePanel;
    private ProductoDetallePanel productoDetallePanel;
    private CarritoPanel carritoPanel;

    private String pantallActual;

    public GlobalFrame() {
        setTitle("Genius Clothing Store");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);
        setMinimumSize(new Dimension(300, 200));
        setPreferredSize(new Dimension(1200, 800));

        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.setOpaque(false);

        header = new Header();
        panelPrincipal.add(header, BorderLayout.NORTH);

        // Inicializar CardLayout y paneles
        cardLayout = new CardLayout();
        panelContenido = new JPanel(cardLayout);

        inicializarPantallas();

        panelPrincipal.add(panelContenido, BorderLayout.CENTER);
        add(panelPrincipal);

        pack();
        setLocationRelativeTo(null);
    }

    private void inicializarPantallas() {
        mainPagePanel = new MainPagePanel();
        productoDetallePanel = new ProductoDetallePanel();
        carritoPanel = new CarritoPanel();

        panelContenido.add(mainPagePanel, SCREEN_MAIN_PAGE);
        panelContenido.add(productoDetallePanel, SCREEN_DETALLE_PRODUCTO);
        panelContenido.add(carritoPanel, SCREEN_CARRITO);

        pantallActual = SCREEN_MAIN_PAGE;
    }

    public void cambiarPantallaDetalle(ProductoDetallePanel nuevoPanel) {
        panelContenido.add(nuevoPanel, "DETALLE_PRODCUTO");
        panelContenido.revalidate();
        panelContenido.repaint();
    }

    public void mostrarPantalla(String nombrePantalla) {
        cardLayout.show(panelContenido, nombrePantalla);
    }

    public String getPantallaActual() {
        return pantallActual;
    }

    public Header getHeader() {
        return header;
    }

    public MainPagePanel getMainPagePanel() {
        return mainPagePanel;
    }

    public ProductoDetallePanel getProductoDetallePanel() {
        return productoDetallePanel;
    }
}
