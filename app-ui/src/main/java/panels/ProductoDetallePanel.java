package panels;

import componentes.BotonRedondeado;
import dtos.ProductoDTO;

import javax.swing.*;
import java.awt.*;

public class ProductoDetallePanel extends ProductoPanelBase {
    private ProductoDTO producto;
    private BotonRedondeado agregarAlCarritoBtn;
    private JPanel panelMedio;

    public ProductoDetallePanel() {
        configurarLayoutVertical();
    }

    public void iniciarComponentes() {
        crearNombreLabel(producto.getNombre(), FONT_REGULAR, 45);
        cargarImagenConBorde(producto.getRutaImagen(), 420, 420, Color.BLACK, 3);
        crearPrecioLabel(producto.getPrecioFormateado(), FONT_REGULAR, 30);
        
        agregarAlCarritoBtn = new BotonRedondeado("Agregar al carrito");

        panelMedio = new JPanel();
        panelMedio.setLayout(new BoxLayout(panelMedio, BoxLayout.X_AXIS));
        panelMedio.setOpaque(false);
        
        JPanel panelDatosDetalle = new JPanel();
        panelDatosDetalle.setLayout(new BoxLayout(panelDatosDetalle, BoxLayout.Y_AXIS));
        panelDatosDetalle.setOpaque(false);
        panelDatosDetalle.add(precioLbl);
        agregarEspacioVertical(30);
        panelDatosDetalle.add(agregarAlCarritoBtn);

        panelMedio.add(imagenLbl);
        panelMedio.add(Box.createRigidArea(new Dimension(50, 0)));
        panelMedio.add(panelDatosDetalle);

        agregarComponenteConEspacio(nombreLbl, 30);
        agregarComponente(panelMedio);
    }

    public void cargarDatosProducto(ProductoDTO productoDTO) {
        this.producto = productoDTO;
        iniciarComponentes();
    }
}
