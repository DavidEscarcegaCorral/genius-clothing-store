package panels;

import componentes.BotonRedondeado;
import dtos.ProductoDTO;
import util.ImageUtil;

import javax.swing.*;

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
        ImageIcon img = ImageUtil.cargarImagen(producto.getRutaImagen(), 420, 420);
        imagenLbl = new JLabel(img);
        precioLbl = new JLabel(producto.getPrecioFormateado());
        agregarAlCarritoBtn = new BotonRedondeado("Agregar al carrito");

        panelMedio = new JPanel(new BoxLayout(this, BoxLayout.X_AXIS));
        panelMedio.setOpaque(false);
        panelMedio.add(imagenLbl);

        panelDatos = new JPanel(new BoxLayout(this, BoxLayout.Y_AXIS));
        panelDatos.setOpaque(false);
        panelDatos.add(precioLbl);
        panelDatos.add(agregarAlCarritoBtn);

        panelMedio.add(panelDatos);
        agregarCompoentens();

    }

    public void agregarCompoentens() {
        add(nombreProdcutoLbl);
        add(panelMedio);
    }

    public void cargarDatosProducto(ProductoDTO productoDTO) {
        this.producto = productoDTO;
        iniciarComponentes();
    }


}
