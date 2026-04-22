package frames;

import componentes.BotonRedondeado;
import org.genius.team.Main;
import panels.Header;

import javax.swing.*;
import java.awt.*;

public class GlobalFrame extends JFrame {
    private JPanel mainPanel;
    private Header header;

    public GlobalFrame() {
        setTitle("Global Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(300, 200));
        pack();
        setLocationRelativeTo(null);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        header = new Header();

        mainPanel.add(header, BorderLayout.NORTH);

        // PRUEBAS DE COMPONENTES VISUALES
        JPanel panelAuxiliar = new JPanel();
        panelAuxiliar.add(new BotonRedondeado("Prueba de boton redondeado"));
        mainPanel.add(panelAuxiliar, BorderLayout.CENTER);

        add(mainPanel);
    }
}
