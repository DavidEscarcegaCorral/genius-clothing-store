package frames;

import panels.Header;
import panels.MainPagePanel;
import panels.ProductoDetallePanel;

import javax.swing.*;
import java.awt.*;

public class GlobalFrame extends JFrame {
    private JPanel panelPrincipal;
    private JPanel panelContenido;
    private CardLayout cardLayout;

    private Header header;

    // Paneles
    private MainPagePanel mainPage;
    private ProductoDetallePanel productoDetallePanel;

    public GlobalFrame() {
        // Configuraciones del frame
        setTitle("Global Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);
        setMinimumSize(new Dimension(300, 200));
        setPreferredSize(new Dimension(1200, 800));

        // Panel principal del frame
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.setOpaque(false);
        header = new Header();

        // CardLayout del frame
        cardLayout = new CardLayout();

        // Agregar componentes al panel principal
        panelPrincipal.add(header, BorderLayout.NORTH);

        // Panel Cards
        mainPage = new MainPagePanel();
        productoDetallePanel = new ProductoDetallePanel();

        // Panel para el contenido
        panelContenido = new JPanel(cardLayout);
        panelContenido.add(mainPage, "MAIN_PAGE");
        panelContenido.add(productoDetallePanel, "DETALLE_PRODCUTO");

        panelPrincipal.add(panelContenido, BorderLayout.CENTER);
        pack();

        // Agregar componentes al frame principal
        add(panelPrincipal);

        // Emapquetado del frame
        pack();
        setLocationRelativeTo(null);
    }

    public Header getHeader() {
        return header;
    }

    public MainPagePanel getMainPage() {
        return mainPage;
    }

    public ProductoDetallePanel getProductoDetallePanel() {
        return productoDetallePanel;
    }
}
