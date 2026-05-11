/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dialogs;

import componentes.BotonRedondeado;
import componentes.CampoTextoGenius;
import componentes.ComboBoxGenius;
import enumeradores.CategoriaProducto;
import enumeradores.EstadoProducto;
import enumeradores.EtiquetaGenero;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import panels.BuscadorGenius;
import util.Estilo;

/**
 *
 * @author Usuario
 */
public class AgregarProductoDialog extends JDialog{

    private CampoTextoGenius txtNombre = new CampoTextoGenius("", 20, Color.BLACK, Color.white, 200, 36);
    private CampoTextoGenius txtDescripcion = new CampoTextoGenius("", 20, Color.BLACK, Color.white, 200, 36);
    private CampoTextoGenius txtPrecio = new CampoTextoGenius("", 20, Color.BLACK, Color.white, 200, 36);
    private CampoTextoGenius txtStock = new CampoTextoGenius("", 20, Color.BLACK, Color.white, 200, 36);
    String[] imagenes = {
    "/img/TenisSL72OG.png",
    "/img/PlayeraPoloNikeSportswear.jpg"
    };
    ComboBoxGenius<String> cbImagen = new ComboBoxGenius<>(imagenes);

    private ComboBoxGenius<CategoriaProducto> cbCategoria;
    private ComboBoxGenius<EtiquetaGenero> cbGenero;

    JCheckBox chkCH = new JCheckBox("CH");
    JCheckBox chkM = new JCheckBox("M");
    JCheckBox chkG = new JCheckBox("G");
    JCheckBox chkXG = new JCheckBox("XG");

    private JCheckBox chkCasual = new JCheckBox("Casual");
    private JCheckBox chkDeportivo = new JCheckBox("Deportivo");
    private JCheckBox chkUrbano = new JCheckBox("Urbano");
    private JCheckBox chkFormal = new JCheckBox("Formal");
    private JCheckBox chkElegante = new JCheckBox("Elegante");
    private JCheckBox chkDeporte = new JCheckBox("Deporte");
    private JCheckBox chkClasico = new JCheckBox("Clásico");


     BotonRedondeado btnGuardar = new BotonRedondeado("Guardar");
     BotonRedondeado btnCancelar = new BotonRedondeado("Cancelar");

    public AgregarProductoDialog() {
        setTitle("Agregar un producto");
        setLayout(new BorderLayout());
        getContentPane().setBackground(Estilo.AMARILLO_GENIUS);
        inicializarComponentes();
        pack();
        setLocationRelativeTo(null);
    }
    
    private void inicializarComponentes(){
        JPanel panelBotones = new JPanel();
        panelBotones.add(btnGuardar);
        panelBotones.add(btnCancelar);
        add(panelBotones,BorderLayout.SOUTH);  
        
        cbCategoria = new ComboBoxGenius<>(CategoriaProducto.values());
        cbGenero = new ComboBoxGenius<>(EtiquetaGenero.values());
        cbImagen  = new ComboBoxGenius<>(new String[]{
        "/img/TenisSL72OG.png",
        "/img/PlayeraPoloNikeSportswear.jpg"
        });
        JPanel panelCentro = new JPanel(new GridLayout(0, 2, 8, 8));
        //Esto es para agregarle espacio a los paneles y que no queden pegados
        panelCentro.setBorder(BorderFactory.createEmptyBorder(12, 16, 12, 16));

        panelCentro.add(new JLabel("Nombre:"));
        panelCentro.add(txtNombre);
        panelCentro.add(new JLabel("Descripción:"));
        panelCentro.add(txtDescripcion);
        panelCentro.add(new JLabel("Precio:"));
        panelCentro.add(txtPrecio);
        panelCentro.add(new JLabel("Imagen:"));
        panelCentro.add(cbImagen);
        panelCentro.add(new JLabel("Stock:"));
        panelCentro.add(txtStock);
        panelCentro.add(new JLabel("Categoría:"));
        panelCentro.add(cbCategoria);
        panelCentro.add(new JLabel("Género:"));
        panelCentro.add(cbGenero);

        //Tallas en su propio panel
        JPanel panelTallas = new JPanel(new FlowLayout(FlowLayout.LEFT, 4, 0));
        panelTallas.add(chkCH);
        panelTallas.add(chkM);
        panelTallas.add(chkG);
        panelTallas.add(chkXG);
        panelCentro.add(new JLabel("Tallas:"));
        panelCentro.add(panelTallas);

        //Estilos en su propio panel
        JPanel panelEstilos = new JPanel(new FlowLayout(FlowLayout.LEFT, 4, 0));
        panelEstilos.add(chkCasual);
        panelEstilos.add(chkDeportivo);
        panelEstilos.add(chkUrbano);
        panelEstilos.add(chkFormal);
        panelEstilos.add(chkElegante);
        panelEstilos.add(chkDeporte);
        panelEstilos.add(chkClasico);
        panelCentro.add(new JLabel("Estilos:"));  panelCentro.add(panelEstilos);
        add(panelCentro);
        
        panelCentro.setOpaque(false);
        panelTallas.setOpaque(false);
        panelEstilos.setOpaque(false);
        panelBotones.setOpaque(false);
    }

    public CampoTextoGenius getTxtNombre() {
        return txtNombre;
    }

    public CampoTextoGenius getTxtDescripcion() {
        return txtDescripcion;
    }

    public CampoTextoGenius getTxtPrecio() {
        return txtPrecio;
    }

    public String[] getImagenes() {
        return imagenes;
    }

    public ComboBoxGenius<String> getCbImagen() {
        return cbImagen;
    }

    public CampoTextoGenius getTxtStock() {
        return txtStock;
    }

    public ComboBoxGenius<CategoriaProducto> getCbCategoria() {
        return cbCategoria;
    }

    public ComboBoxGenius<EtiquetaGenero> getCbGenero() {
        return cbGenero;
    }

    public JCheckBox getChkCH() {
        return chkCH;
    }

    public JCheckBox getChkM() {
        return chkM;
    }

    public JCheckBox getChkG() {
        return chkG;
    }

    public JCheckBox getChkXG() {
        return chkXG;
    }

    public JCheckBox getChkCasual() {
        return chkCasual;
    }

    public JCheckBox getChkDeportivo() {
        return chkDeportivo;
    }

    public JCheckBox getChkUrbano() {
        return chkUrbano;
    }

    public JCheckBox getChkFormal() {
        return chkFormal;
    }

    public JCheckBox getChkElegante() {
        return chkElegante;
    }

    public JCheckBox getChkDeporte() {
        return chkDeporte;
    }

    public JCheckBox getChkClasico() {
        return chkClasico;
    }

    public BotonRedondeado getBtnGuardar() {
        return btnGuardar;
    }

    public BotonRedondeado getBtnCancelar() {
        return btnCancelar;
    }
    
    
    
    
}
