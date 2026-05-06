package panels;

import autorizacion.SesionService;
import componentes.BotonIcono;
import componentes.LogoGenius;
import util.Estilo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Header extends JPanel {
    private LogoGenius homeButton;
    private BuscadorGenius buscadorGenius;
    private BotonIcono usuarioBtn;
    private BotonIcono carritoBtn;

    public Header() {
        setBackground(Color.BLACK);
        iniciarComponentes();

        // Borde amarillo
        setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Estilo.AMARILLO_GENIUS));
    }

    private void iniciarComponentes() {
        // Layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Primera seccion
        homeButton = new LogoGenius();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 25, 5, 0);
        add(homeButton, gbc);

        // Segunda seccion
        buscadorGenius = new BuscadorGenius();
        gbc.gridx = 1;
        gbc.weightx = 0.9;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(buscadorGenius, gbc);

        // Boton Usuario
        usuarioBtn = new BotonIcono("Iniciar Sesion");
        usuarioBtn.setFont(Estilo.FONT_OPNS_COND_REGULAR, 20);
        usuarioBtn.setForeground(Color.white);
        gbc.gridx = 2;
        gbc.weightx = 0.1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(usuarioBtn, gbc);
    }

    public void actualizarUsuario() {
        if (SesionService.getUsuarioActual() != null) {
            usuarioBtn.setText(SesionService.getUsuarioActual().getUsuario());
        } else {
            usuarioBtn.setText("Iniciar Sesion");
        }
        revalidate();
        repaint();
    }

    public LogoGenius getHomeButton() {
        return homeButton;
    }

    public void setHomeButton(LogoGenius homeButton) {
        this.homeButton = homeButton;
    }

    public BuscadorGenius getBuscadorGenius() {
        return buscadorGenius;
    }

    public void setBuscadorGenius(BuscadorGenius buscadorGenius) {
        this.buscadorGenius = buscadorGenius;
    }

    public BotonIcono getUsuarioBtn() {
        return usuarioBtn;
    }

    public void setUsuarioBtn(BotonIcono usuarioBtn) {
        this.usuarioBtn = usuarioBtn;
    }

    public BotonIcono getCarritoBtn() {
        return carritoBtn;
    }

    public void setCarritoBtn(BotonIcono carritoBtn) {
        this.carritoBtn = carritoBtn;
    }

    public void setHomeAction(ActionListener action) {
        this.homeButton.addActionListener(action);
    }
}
