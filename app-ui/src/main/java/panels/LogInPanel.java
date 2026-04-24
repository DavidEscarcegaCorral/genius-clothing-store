package panels;

import componentes.BotonRedondeado;
import componentes.CampoTextoGenius;
import util.Estilo;
import util.FontLoader;

import javax.swing.*;
import java.awt.*;

public class LogInPanel extends JPanel {
    private GridBagConstraints gbc;
    private JLabel iniciarSesionLbl;
    private JLabel usuarioLbl;
    private JLabel contraseñaLlb;
    private CampoTextoGenius usuario;
    private BotonRedondeado ingresarBtn;
    private BotonRedondeado registrarseBtn;

    public LogInPanel() {
        setOpaque(false);
        setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();

        // Configuracion de la grid
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        iniciarComponentes();

    }

    private void iniciarComponentes() {
        // Label de iniciar sesion
        iniciarSesionLbl = new JLabel("Iniciar sesión");
        iniciarSesionLbl.setFont(FontLoader.cargarFont(Estilo.FONT_NORMAL, 38));
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 40, 0);
        add(iniciarSesionLbl, gbc);

        // Label de usuario
        usuarioLbl = new JLabel("Usuario");
        usuarioLbl.setFont(FontLoader.cargarFont(Estilo.FONT_NORMAL, 26));
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 40, 0);
        add(usuarioLbl, gbc);


    }
}
