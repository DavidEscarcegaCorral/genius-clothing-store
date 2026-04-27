package frames;

import componentes.BotonRedondeado;
import panels.Header;

import javax.swing.*;
import java.awt.*;

public class GlobalFrame extends JFrame {
    private JPanel panelPrincipal;
    private Header header;

    public GlobalFrame() {
        // Configuraciones del frame
        setTitle("Global Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);
        setMinimumSize(new Dimension(300, 200));

        // Panel principal del frame
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.setOpaque(false);
        header = new Header();

        // Agregar componentes al panel principal
        panelPrincipal.add(header, BorderLayout.NORTH);

        // PRUEBAS DE COMPONENTES VISUALES
        JPanel panelAuxiliar = new JPanel();
        panelAuxiliar.setOpaque(false);
        panelAuxiliar.add(new BotonRedondeado("Prueba de boton redondeado"));
        panelPrincipal.add(panelAuxiliar, BorderLayout.CENTER);

        // Agregar componentes al frame principal
        add(panelPrincipal);

        // Emapquetado del frame
        pack();
        setLocationRelativeTo(null);
    }
}
