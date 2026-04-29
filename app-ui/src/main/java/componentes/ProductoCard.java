package componentes;

import dtos.ProductoCardDTO;
import util.ImageUtil;

import javax.swing.*;
import java.awt.*;

public class ProductoCard extends JPanel {
    private JLabel imagenLbl;
    private JLabel precioProdcuto;
    private JLabel nombreProducto;
    private JLabel generoProdcuto;

    private final String rutaPrueba = "TenisSL72OG.png";

    public ProductoCard(ProductoCardDTO prodcuto) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        iniciarComponentes();

    }

    public void iniciarComponentes() {
        ImageIcon img = ImageUtil.cargarImagen("/img/" + rutaPrueba, 250, 250);
        imagenLbl = new JLabel(img);
        add(imagenLbl, BorderLayout.NORTH);

    }

}
