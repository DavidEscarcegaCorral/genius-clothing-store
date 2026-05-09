package componentes;

import dtos.ProductoCardDTO;
import panels.ProductoPanelBase;
import util.FontLoader;

import javax.swing.*;
import java.awt.*;

public class ProductoCarritoCard extends ProductoPanelBase {
    private ProductoCardDTO productoCardDTO;
    private JLabel tallaLbl;
    private JLabel cantidadLbl;
    private BotonIcono eliminarBtn;
    private JPanel panelBotones;

    private static final int ANCHO = 450;
    private static final int ALTO = 180;

    public ProductoCarritoCard(ProductoCardDTO producto) {
        configurarLayoutHorizontal();
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 3),
                BorderFactory.createEmptyBorder(0, 0, 0, 0)
        ));
        setPreferredSize(new Dimension(ANCHO, ALTO));
        setMaximumSize(new Dimension(ANCHO, ALTO));
        setMinimumSize(new Dimension(ANCHO, ALTO));

        this.productoCardDTO = producto;
    }

    public void iniciarComponentes() {
        cargarImagen(productoCardDTO.getRutaImg(), 170, 170);

        configurarPanelDatos(new BoxLayout(panelDatos, BoxLayout.Y_AXIS));
        panelDatos.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        crearNombreLabel(productoCardDTO.getNombreProdcto(), FONT_BOLD, 16);
        crearPrecioLabel(productoCardDTO.getPrecioFormateado(), FONT_REGULAR, 18);

        // Datos de pruebaq
        tallaLbl = new JLabel("Talla: M");
        tallaLbl.setFont(FontLoader.cargarFont(FONT_REGULAR, 14));
        cantidadLbl = new JLabel("Cantidad: 1");
        cantidadLbl.setFont(FontLoader.cargarFont(FONT_REGULAR, 14));
        eliminarBtn = new BotonIcono("X");
        eliminarBtn.setForeground(Color.BLACK);
        agregarDatosAlPanel(nombreLbl, precioLbl, tallaLbl, cantidadLbl);

        agregarComponente(imagenLbl);
        agregarComponente(panelDatos);
        agregarComponente(eliminarBtn);
    }

    public String getProductoId() {
        return productoCardDTO.getProdcutoId();
    }

}
