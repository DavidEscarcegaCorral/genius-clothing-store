package panels;

import componentes.BotonPlano;
import util.Estilo;
import util.FontLoader;

import javax.swing.*;
import javax.swing.border.Border;
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
        Border linea = BorderFactory.createLineBorder(Color.BLACK, 3);
        Border padding = BorderFactory.createEmptyBorder(20, 16, 20, 16);
        setBorder(BorderFactory.createCompoundBorder(linea, padding));
        setOpaque(false);
        iniciarComponentes();
        agregarComponentes();
    }

    public void iniciarComponentes() {
        resumenLbl = new JLabel(TITULO);
        resumenLbl.setFont(FontLoader.cargarFont(Estilo.FONT_PROGRAMME_NORMAL, 28));

        subtotalLbl = new JLabel(SUBTOTAL_TXT);
        subtotalLbl.setFont(FontLoader.cargarFont(Estilo.FONT_PROGRAMME_NORMAL, 18));

        irAlPagoBtn = new BotonPlano(TEXTO_BTN);
    }

    public void agregarComponentes() {
        add(resumenLbl);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(subtotalLbl);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(irAlPagoBtn);
    }

}
