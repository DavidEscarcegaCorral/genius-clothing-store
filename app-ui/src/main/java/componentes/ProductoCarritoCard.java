package componentes;

import dtos.ProductoCardDTO;
import panels.ProductoCardBase;
import util.FontLoader;

import javax.swing.*;
import java.awt.*;

public class ProductoCarritoCard extends ProductoCardBase {
    private ProductoCardDTO productoCardDTO;
    private String tallaSeleccionada;
    private int cantidad;
    private JLabel tallaLbl;
    private JLabel cantidadLbl;
    private BotonIcono eliminarBtn;
    private JPanel panelBotones;

    private static final int ANCHO = 450;
    private static final int ALTO = 180;

    public ProductoCarritoCard(ProductoCardDTO producto, String talla, int cantidad) {
        configurarLayoutHorizontal();
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 3),
                BorderFactory.createEmptyBorder(0, 0, 0, 0)
        ));
        setPreferredSize(new Dimension(ANCHO, ALTO));
        setMaximumSize(new Dimension(ANCHO, ALTO));
        setMinimumSize(new Dimension(ANCHO, ALTO));

        this.productoCardDTO = producto;
        this.tallaSeleccionada = talla;
        this.cantidad = cantidad;
    }

public void iniciarComponentes() {
        cargarImagen(productoCardDTO.getRutaImagen(), 170, 170);

        configurarPanelDatos(new BoxLayout(panelDatos, BoxLayout.Y_AXIS));
        panelDatos.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        crearNombreLabel(productoCardDTO.getNombreProducto(), FONT_BOLD, 16);
        crearPrecioLabel("$" + productoCardDTO.getPrecio(), FONT_REGULAR, 18);

        String tallaMostrar = (tallaSeleccionada != null && !tallaSeleccionada.isEmpty())
                ? tallaSeleccionada : "Única";
        tallaLbl = new JLabel("Talla: " + tallaMostrar);
        cantidadLbl = new JLabel("Cantidad: " + cantidad);
        eliminarBtn = new BotonIcono("X");
        agregarDatosAlPanel(nombreLbl, precioLbl, tallaLbl, cantidadLbl);

        agregarComponente(imagenLbl);
        agregarComponente(panelDatos);
        agregarComponente(eliminarBtn);
    }

public String getProductoId() {
        return productoCardDTO.getProductoId();
    }

    public String getTallaSeleccionada() {
        return tallaSeleccionada;
    }

    public int getCantidad() {
        return cantidad;
    }

}
