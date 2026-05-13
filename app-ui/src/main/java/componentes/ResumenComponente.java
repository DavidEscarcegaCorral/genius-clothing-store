package componentes;

import util.Estilo;
import util.FontLoader;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ResumenComponente extends JPanel {
    private JLabel lblPrincipal;
    private BotonPlano btnContinuar;

    private static final String RESUMEN = "Resumen";

    public void ResumenComponentes() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Border linea = BorderFactory.createLineBorder(Color.BLACK, 3);
        Border padding = BorderFactory.createEmptyBorder(20, 16, 20, 16);
        setBorder(BorderFactory.createCompoundBorder(linea, padding));
        setOpaque(false);
    }

    public void iniciarComponentes() {
        lblPrincipal = new JLabel(RESUMEN);
        lblPrincipal.setFont(FontLoader.cargarFont(Estilo.FONT_PROGRAMME_NORMAL, 28));
    }

    public void agregarComponente(JComponent component) {
        add(component);
        add(Box.createRigidArea(new Dimension(0, 20)));
    }
}
