package componentes;

import dtos.ProductoCardDTO;
import util.Estilo;
import util.FontLoader;
import util.ImageUtil;

import javax.swing.*;
import java.awt.*;

public class ProductoCard extends JPanel {
    private ProductoCardDTO productoCardDTO;
    private JLabel imagenLbl;
    private JLabel nombreProductoLbl;
    private JLabel precioProdcutoLbl;
    private JLabel generoProdcutoLbl;
    private JPanel panelDatos;

    public ProductoCard(ProductoCardDTO prodcuto) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        setOpaque(false);
        this.productoCardDTO = prodcuto;
        iniciarComponentes();
    }

    public void iniciarComponentes() {
        ImageIcon img = ImageUtil.cargarImagen(productoCardDTO.getRutaImg(), 230, 230);
        imagenLbl = new JLabel(img);

        panelDatos = new JPanel();
        panelDatos.setLayout(new BoxLayout(panelDatos, BoxLayout.Y_AXIS));
        panelDatos.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        panelDatos.setOpaque(false);

        // Obtener datos del producto
        nombreProductoLbl = new JLabel(productoCardDTO.getNombreProdcto());
        nombreProductoLbl.setFont(FontLoader.cargarFont(Estilo.FONT_OPNS_COND_BLOD, 24));
        precioProdcutoLbl = new JLabel(productoCardDTO.getPrecioProducto().toString());
        precioProdcutoLbl.setFont(FontLoader.cargarFont(Estilo.FONT_OPNS_COND_REGULAR, 22));
        generoProdcutoLbl = new JLabel(productoCardDTO.getGeneroProcuto().getValor());
        generoProdcutoLbl.setFont(FontLoader.cargarFont(Estilo.FONT_OPNS_COND_REGULAR, 22));

        panelDatos.add(nombreProductoLbl);
        panelDatos.add(precioProdcutoLbl);
        panelDatos.add(generoProdcutoLbl);

        add(imagenLbl, BorderLayout.NORTH);
        add(panelDatos, BorderLayout.CENTER);
    }

}
