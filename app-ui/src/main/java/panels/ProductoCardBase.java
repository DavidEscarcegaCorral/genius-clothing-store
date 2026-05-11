package panels;

import util.Estilo;
import util.FontLoader;
import util.ImageUtil;

import javax.swing.*;
import java.awt.*;

public abstract class ProductoCardBase extends JPanel {
    protected JLabel imagenLbl;
    protected JLabel nombreLbl;
    protected JLabel precioLbl;
    protected JPanel panelDatos;

    protected static final String FONT_BOLD = Estilo.FONT_OPNS_COND_BOLD;
    protected static final String FONT_REGULAR = Estilo.FONT_OPNS_COND_REGULAR;

    protected ProductoCardBase() {
        initBase();
    }

    private void initBase() {
        setOpaque(false);
        panelDatos = new JPanel();
        panelDatos.setOpaque(false);
    }

    protected void configurarLayout(BorderLayout layout) {
        setLayout(layout);
    }

    protected void configurarLayoutVertical() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    protected void configurarLayoutHorizontal() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    }

    protected void configurarPanelDatos(BoxLayout layout) {
        panelDatos.setLayout(layout);
    }

    protected void cargarImagen(String ruta, int ancho, int alto) {
        ImageIcon img = ImageUtil.cargarImagen(ruta, ancho, alto);
        imagenLbl = new JLabel(img);
    }

    protected void cargarImagenConBorde(String ruta, int ancho, int alto, Color colorBorde, int grosor) {
        ImageIcon img = ImageUtil.cargarImagen(ruta, ancho, alto);
        imagenLbl = new JLabel(img);
        imagenLbl.setBorder(BorderFactory.createLineBorder(colorBorde, grosor));
    }

    protected void crearNombreLabel(String nombre, String font, int tamaño) {
        nombreLbl = new JLabel(nombre);
        nombreLbl.setFont(FontLoader.cargarFont(font, tamaño));
    }

    protected void crearPrecioLabel(String precioFormateado, String font, int tamaño) {
        precioLbl = new JLabel(precioFormateado);
        precioLbl.setFont(FontLoader.cargarFont(font, tamaño));
    }

    protected void agregarDatosAlPanel(JComponent... componentes) {
        for (JComponent comp : componentes) {
            panelDatos.add(comp);
        }
    }

    protected void agregarEspacioVertical(int altura) {
        panelDatos.add(Box.createRigidArea(new Dimension(0, altura)));
    }

    protected void agregarComponente(JComponent componente) {
        add(componente);
    }

    protected void agregarComponente(JComponent componente, String constraint) {
        add(componente, constraint);
    }

    protected void agregarComponenteConEspacio(JComponent componente, int altura) {
        add(componente);
        add(Box.createRigidArea(new Dimension(0, altura)));
    }
}