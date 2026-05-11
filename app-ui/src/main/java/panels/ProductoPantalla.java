package panels;

import componentes.BotonRedondeado;
import componentes.ComboBoxGenius;
import componentes.ProductoTagsLabel;
import dtos.salida.ProductoSalidaDTO;
import util.Estilo;
import util.FontLoader;
import util.ImageUtil;

import javax.swing.*;
import java.awt.*;

public class ProductoPantalla extends JPanel {
    private ProductoSalidaDTO producto;
    private JLabel imagenLbl;
    private JLabel nombreLbl;
    private JLabel precioLbl;
    private ProductoTagsLabel tagsLbl;
    private ComboBoxGenius<String> comboTallas;
    private BotonRedondeado agregarAlCarritoBtn;

    private JPanel panelContenedor;
    private JPanel panelDetalles;

    public ProductoPantalla() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public void iniciarComponentes() {
        ImageIcon img = ImageUtil.cargarImagen(producto.getRutaImagen(), 425, 425);
        imagenLbl = new JLabel(img);
        imagenLbl.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

        nombreLbl = new JLabel(producto.getNombre());
        nombreLbl.setFont(FontLoader.cargarFont(Estilo.FONT_OPNS_COND_REGULAR, 45));
        nombreLbl.setForeground(Color.BLACK);

        precioLbl = new JLabel(producto.getPrecioFormateado());
        precioLbl.setFont(FontLoader.cargarFont(Estilo.FONT_OPNS_COND_REGULAR, 45));
        precioLbl.setForeground(Color.BLACK);

        tagsLbl = new ProductoTagsLabel(producto.getGenero(), producto.getEstilos());

        agregarAlCarritoBtn = new BotonRedondeado("Agregar al carrito");

        iniciarPanelDetalles();

        panelContenedor = new JPanel();
        panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.X_AXIS));
        panelContenedor.setOpaque(false);

        panelContenedor.add(imagenLbl);
        panelContenedor.add(Box.createRigidArea(new Dimension(50, 0)));
        panelContenedor.add(panelDetalles);

        add(nombreLbl);
        add(panelContenedor);

    }

    private void iniciarPanelDetalles() {
        panelDetalles = new JPanel();
        panelDetalles.setLayout(new BoxLayout(panelDetalles, BoxLayout.Y_AXIS));
        panelDetalles.setOpaque(false);

        panelDetalles.add(tagsLbl);
        panelDetalles.add(precioLbl);
        panelDetalles.add(agregarAlCarritoBtn);
    }

    public void cargarDatosProducto(ProductoSalidaDTO productoDTO) {
        this.producto = productoDTO;
        iniciarComponentes();
    }
}
