package panels;

import componentes.BotonPlano;
import util.Estilo;
import util.FontLoader;

import javax.swing.*;
import java.awt.*;

public class OpcionesCarritoPanel extends JPanel {
    private JLabel resumenLbl;
    private JLabel subtotalLbl;
    private BotonPlano irAlPagoBtn;

    private final String TITULO = "Resumen";
    private final String SUBTOTAL_TXT = "Sub total: ";
    private final String TEXTO_BTN = "Ir al pago      >";

    public OpcionesCarritoPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        setOpaque(false);
        iniciarComponentes();
        agregarComponentes();
    }

    public void iniciarComponentes() {
        resumenLbl = new JLabel(TITULO);
        resumenLbl.setFont(FontLoader.cargarFont(Estilo.FONT_PROGRAMME_NORMAL, 28));

        subtotalLbl = new JLabel(SUBTOTAL_TXT);

        irAlPagoBtn = new BotonPlano(TEXTO_BTN);
    }

    public void agregarComponentes() {
        add(resumenLbl);
        add(irAlPagoBtn);
    }

}
