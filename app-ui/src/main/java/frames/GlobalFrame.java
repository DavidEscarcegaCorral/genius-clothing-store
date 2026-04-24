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
        // Configuraciones del frame
        setTitle("Global Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);
        setMinimumSize(new Dimension(300, 200));

        // Panel principal del frame
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setOpaque(false);
        header = new Header();

        // Agregar componentes al panel principal
        mainPanel.add(header, BorderLayout.NORTH);

        // PRUEBAS DE COMPONENTES VISUALES
        JPanel panelAuxiliar = new JPanel();
        panelAuxiliar.setOpaque(false);
        panelAuxiliar.add(new BotonRedondeado("Prueba de boton redondeado"));
        mainPanel.add(panelAuxiliar, BorderLayout.CENTER);

        // Agregar componentes al frame principal
        add(mainPanel);

        // Emapquetado del frame
        pack();
        setLocationRelativeTo(null);
    }
}
