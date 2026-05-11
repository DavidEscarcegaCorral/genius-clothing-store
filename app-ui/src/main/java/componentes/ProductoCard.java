package componentes;

import dtos.ProductoCardDTO;
import panels.ProductoCardBase;
import util.FontLoader;

import javax.swing.*;
import java.awt.*;

public class ProductoCard extends ProductoCardBase {
    private ProductoCardDTO productoCardDTO;
    private JLabel generoLbl;

    public ProductoCard(ProductoCardDTO producto) {
        configurarLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

        this.productoCardDTO = producto;
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        cargarImagen(productoCardDTO.getRutaImg(), 230, 230);
        imagenLbl.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        configurarPanelDatos(new BoxLayout(panelDatos, BoxLayout.Y_AXIS));
        panelDatos.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        crearNombreLabel(productoCardDTO.getNombreProdcto(), FONT_BOLD, 18);
        crearPrecioLabel(productoCardDTO.getPrecioFormateado(), FONT_REGULAR, 20);

        generoLbl = new JLabel(productoCardDTO.getGeneroProcuto().getValor());
        generoLbl.setFont(FontLoader.cargarFont(FONT_REGULAR, 20));

        agregarDatosAlPanel(nombreLbl, precioLbl, generoLbl);

        agregarComponente(imagenLbl, BorderLayout.NORTH);
        agregarComponente(panelDatos, BorderLayout.CENTER);
    }

    public String getProductoId() {
        return productoCardDTO.getProdcutoId();
    }

}
