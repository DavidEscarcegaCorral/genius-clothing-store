package panels;

import componentes.BotonRedondeado;
import componentes.ComboBoxGenius;
import componentes.ProductoTagsLabel;
import dto_response.ProductoResponseDTO;
import dtos.ProductoCardDTO;
import util.Estilo;
import util.FontLoader;
import util.ImageUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ProductoPantalla extends JPanel {
    private ProductoResponseDTO producto;
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

        precioLbl = new JLabel("$" + producto.getPrecio());
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

    public void cargarDatosProducto(ProductoResponseDTO productoDTO) {
        this.producto = productoDTO;
        iniciarComponentes();
    }

    public void setAgregarAlCarritoListener(ActionListener listener) {
        agregarAlCarritoBtn.addActionListener(listener);
    }

    public ProductoCardDTO getProductoParaCarrito() {
        if (producto == null) {
            return null;
        }

        ProductoCardDTO cardDTO = new ProductoCardDTO();
        cardDTO.setProductoId(producto.getId());
        cardDTO.setNombreProducto(producto.getNombre());
        cardDTO.setPrecio(producto.getPrecio());
        cardDTO.setGenero(producto.getGenero());
        cardDTO.setRutaImagen(producto.getRutaImagen());

        return cardDTO;
    }

    public String getTallaSeleccionada() {
        if (comboTallas != null && comboTallas.getSelectedItem() != null) {
            return (String) comboTallas.getSelectedItem();
        }
        return "Única";
    }
}
