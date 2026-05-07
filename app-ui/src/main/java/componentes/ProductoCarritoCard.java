package componentes;

import dtos.ProductoCardDTO;
import panels.ProductoPanelBase;

import javax.swing.*;

public class ProductoCarritoCard extends ProductoPanelBase {
    private ProductoCardDTO productoCardDTO;
    private JLabel tallaLbl;
    private JLabel cantidadLbl;
    private BotonIcono eliminarBtn;

    public ProductoCarritoCard(ProductoCardDTO producto) {
        configurarLayoutHorizontal();
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        this.productoCardDTO = producto;
    }

    public void iniciarComponentes() {
        cargarImagen(productoCardDTO.getRutaImg(), 190, 190);

        configurarPanelDatos(new BoxLayout(panelDatos, BoxLayout.Y_AXIS));
        panelDatos.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
    }

}
