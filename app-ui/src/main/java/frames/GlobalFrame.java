package frames;

import componentes.scroll.ScrollPaneCustom;
import panels.CarritoPantalla;
import panels.Header;
import panels.MainPagePantalla;
import panels.ProductoPantalla;

import javax.swing.*;
import java.awt.*;

import static util.Constants.Pantallas.*;

public class GlobalFrame extends JFrame {
    private JPanel panelPrincipal;
    private JPanel panelContenido;
    private CardLayout cardLayout;
    private JScrollPane scrollPane;

    private Header header;

    private MainPagePantalla mainPagePantalla;
    private ProductoPantalla productoPantalla;
    private CarritoPantalla carritoPantalla;

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

        cardLayout = new CardLayout();
        panelContenido = new JPanel(cardLayout);

        scrollPane = new ScrollPaneCustom(panelContenido);

        inicializarPantallas();

        panelPrincipal.add(scrollPane, BorderLayout.CENTER);
        add(panelPrincipal);

        pack();
        setLocationRelativeTo(null);
    }

    private void inicializarPantallas() {
        mainPagePantalla = new MainPagePantalla();
        productoPantalla = new ProductoPantalla();
        carritoPantalla = new CarritoPantalla();

        panelContenido.add(mainPagePantalla, MAIN_PAGE);
        panelContenido.add(productoPantalla, DETALLE_PRODUCTO);
        panelContenido.add(carritoPantalla, CARRITO);

        pantallActual = MAIN_PAGE;
    }

    public void cambiarPantallaDetalle(ProductoPantalla nuevoPanel) {
        panelContenido.add(nuevoPanel, DETALLE_PRODUCTO);
        panelContenido.revalidate();
        panelContenido.repaint();
    }

    public void mostrarPantalla(String nombrePantalla) {
        cardLayout.show(panelContenido, nombrePantalla);
    }

    public String getPantallaActual() {
        return pantallActual;
    }

    public void setPantallaActual(String pantallaActual) {
        this.pantallActual = pantallaActual;
    }

    public Header getHeader() {
        return header;
    }

    public MainPagePantalla getMainPagePanel() {
        return mainPagePantalla;
    }

    public ProductoPantalla getProductoDetallePanel() {
        return productoPantalla;
    }

    public CarritoPantalla getCarritoPanel() {
        return carritoPantalla;
    }
}
