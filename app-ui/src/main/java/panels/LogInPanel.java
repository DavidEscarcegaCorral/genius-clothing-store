package panels;

import componentes.BotonRedondeado;
import componentes.CampoContrseñaGenius;
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
    public CampoTextoGenius usuarioTxt;
    public CampoContrseñaGenius contrseñaTxt;
    public BotonRedondeado ingresarBtn;
    public BotonRedondeado registrarseBtn;

    private final JLabel errorLbl = new JLabel("El usuario o la contraseña no coinciden");

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
        iniciarSesionLbl.setFont(FontLoader.cargarFont(Estilo.FONT_PROGRAMME_NORMAL, 38));
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 0, 40, 0);
        add(iniciarSesionLbl, gbc);

        // Label de usuario
        usuarioLbl = new JLabel("Usuario");
        usuarioLbl.setFont(FontLoader.cargarFont(Estilo.FONT_PROGRAMME_NORMAL, 20));
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 10, 0);
        add(usuarioLbl, gbc);

        // Campo de texto
        usuarioTxt = new CampoTextoGenius("Usuario", 20, Color.BLACK, Color.white, 220, 40);
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 0, 28, 0);
        add(usuarioTxt, gbc);

        // Label contraseña
        contraseñaLlb = new JLabel("Contraseña");
        contraseñaLlb.setFont(FontLoader.cargarFont(Estilo.FONT_PROGRAMME_NORMAL, 20));
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 0, 10, 0);
        add(contraseñaLlb, gbc);

        // Campo contraseña
        contrseñaTxt = new CampoContrseñaGenius("Ingresa tu contraseña", 20, Color.BLACK, Color.white, 220, 40);
        gbc.gridy = 4;
        gbc.insets = new Insets(0, 0, 40, 0);
        add(contrseñaTxt, gbc);

        // Boton ingresar
        ingresarBtn = new BotonRedondeado("Ingresar");
        gbc.gridy = 5;
        gbc.insets = new Insets(0, 0, 15, 0);
        add(ingresarBtn, gbc);

        // Boton registrarse
        registrarseBtn = new BotonRedondeado("Registrarse");
        gbc.gridy = 6;
        gbc.insets = new Insets(0, 0, 15, 0);
        add(registrarseBtn, gbc);
    }

    private void limpiarCampos() {
        usuarioTxt.setText("");
        contrseñaTxt.setText("");
    }

    public CampoTextoGenius getUsuarioTxt() {
        return usuarioTxt;
    }

    public CampoContrseñaGenius getContrseñaTxt() {
        return contrseñaTxt;
    }

    public BotonRedondeado getIngresarBtn() {
        return ingresarBtn;
    }

    public BotonRedondeado getRegistrarseBtn() {
        return registrarseBtn;
    }
}
