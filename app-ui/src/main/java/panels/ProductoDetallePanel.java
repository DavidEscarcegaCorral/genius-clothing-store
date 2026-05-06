package panels;

import componentes.BotonRedondeado;
import dtos.ProductoDTO;
import util.Estilo;
import util.FontLoader;
import util.ImageUtil;

import javax.swing.*;
import java.awt.*;

public class ProductoDetallePanel extends JPanel {
    private ProductoDTO producto;
    private JLabel nombreProdcutoLbl;
    private JLabel imagenLbl;
    private JLabel precioLbl;
    private BotonRedondeado agregarAlCarritoBtn;

    private JPanel panelMedio;
    private JPanel panelDatos;

    public ProductoDetallePanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setOpaque(false);
    }

    public void iniciarComponentes() {
        nombreProdcutoLbl = new JLabel(producto.getNombre());
        nombreProdcutoLbl.setFont(FontLoader.cargarFont(Estilo.FONT_OPNS_COND_REGULAR, 45));
        ImageIcon img = ImageUtil.cargarImagen(producto.getRutaImagen(), 420, 420);
        imagenLbl = new JLabel(img);
        imagenLbl.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        precioLbl = new JLabel(producto.getPrecioFormateado());
        precioLbl.setFont(FontLoader.cargarFont(Estilo.FONT_OPNS_COND_REGULAR, 30));
        agregarAlCarritoBtn = new BotonRedondeado("Agregar al carrito");

        panelMedio = new JPanel();
        panelMedio.setLayout(new BoxLayout(panelMedio, BoxLayout.X_AXIS));
        panelMedio.setOpaque(false);
        panelMedio.add(imagenLbl);
        panelMedio.add(Box.createRigidArea(new Dimension(50, 0)));

        panelDatos = new JPanel();
        panelDatos.setLayout(new BoxLayout(panelDatos, BoxLayout.Y_AXIS));
        panelDatos.setOpaque(false);
        panelDatos.add(precioLbl);
        panelDatos.add(Box.createRigidArea(new Dimension(0, 30)));
        panelDatos.add(agregarAlCarritoBtn);

        panelMedio.add(panelDatos);
        agregarCompoentens();

    }

    public void agregarCompoentens() {
        add(nombreProdcutoLbl);
        add(Box.createRigidArea(new Dimension(0, 30)));
        add(panelMedio);
    }

    public void cargarDatosProducto(ProductoDTO productoDTO) {
        this.producto = productoDTO;
        iniciarComponentes();
    }


}
