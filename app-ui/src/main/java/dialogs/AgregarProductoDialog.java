/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dialogs;

import componentes.BotonRedondeado;
import componentes.CampoTextoGenius;
import componentes.ComboBoxGenius;
import dtos.StockPorTalla;
import enumeradores.CategoriaProducto;
import enumeradores.EstadoProducto;
import enumeradores.EtiquetaGenero;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import util.TallaUtil;

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

    private JCheckBox chkCasual = new JCheckBox("Casual");
    private JCheckBox chkDeportivo = new JCheckBox("Deportivo");
    private JCheckBox chkUrbano = new JCheckBox("Urbano");
    private JCheckBox chkFormal = new JCheckBox("Formal");
    private JCheckBox chkElegante = new JCheckBox("Elegante");
    private JCheckBox chkDeporte = new JCheckBox("Deporte");
    private JCheckBox chkClasico = new JCheckBox("Clásico");

    private JPanel panelInventario;
    private Map<String, JTextField> camposInventario = new HashMap<>();

    BotonRedondeado btnGuardar = new BotonRedondeado("Guardar");
    BotonRedondeado btnCancelar = new BotonRedondeado("Cancelar");

    public AgregarProductoDialog() {
        
        cbCategoria = new ComboBoxGenius<>(CategoriaProducto.values());
        cbGenero = new ComboBoxGenius<>(EtiquetaGenero.values());
        setTitle("Agregar un producto");
        setLayout(new BorderLayout());
        getContentPane().setBackground(Estilo.AMARILLO_GENIUS);
        inicializarComponentes();
        pack();
        setLocationRelativeTo(null);
    }
    
    private void inicializarComponentes(){
        JPanel panelCentro = new JPanel(new GridBagLayout());
        panelCentro.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 8, 4, 8);
        //Movemos los componentes a la izquierda
        gbc.anchor = GridBagConstraints.WEST;
        //Evitamos que se expandam
        gbc.fill = GridBagConstraints.NONE;

        // Nombre
        //Columnas
        gbc.gridx = 0;
        //Filas
        gbc.gridy = 0; 
        panelCentro.add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1;
        panelCentro.add(txtNombre, gbc);

        // Descripción
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelCentro.add(new JLabel("Descripción:"), gbc);
        gbc.gridx = 1;
        panelCentro.add(txtDescripcion, gbc);

        // Precio
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelCentro.add(new JLabel("Precio:"), gbc);
        gbc.gridx = 1;
        panelCentro.add(txtPrecio, gbc);

        // Imagen
        gbc.gridx = 0;
        gbc.gridy = 3;
        panelCentro.add(new JLabel("Imagen:"), gbc);
        gbc.gridx = 1;
        panelCentro.add(cbImagen, gbc);

        // Categoría
        gbc.gridx = 0;
        gbc.gridy = 4;
        panelCentro.add(new JLabel("Categoría:"), gbc);
        gbc.gridx = 1;
        panelCentro.add(cbCategoria, gbc);

        // Género
        gbc.gridx = 0;
        gbc.gridy = 5;
        panelCentro.add(new JLabel("Género:"), gbc);
        gbc.gridx = 1;
        panelCentro.add(cbGenero, gbc);

        // Estilos
        JPanel panelEstilos = new JPanel(new FlowLayout(FlowLayout.LEFT, 4, 0));
        panelEstilos.setOpaque(false);
        panelEstilos.add(chkCasual);
        panelEstilos.add(chkDeportivo);
        panelEstilos.add(chkUrbano);
        panelEstilos.add(chkFormal);
        panelEstilos.add(chkElegante);
        panelEstilos.add(chkDeporte);
        panelEstilos.add(chkClasico);
        gbc.gridx = 0;
        gbc.gridy = 6; 
        panelCentro.add(new JLabel("Estilos:"), gbc);
        gbc.gridx = 1;
        
        panelCentro.add(panelEstilos, gbc);

        // Inventario
        panelInventario = new JPanel(new GridLayout(0, 4, 8, 4));
        panelInventario.setOpaque(false);
        panelInventario.setBorder(BorderFactory.createTitledBorder("Inventario por talla"));
        actualizarInventarioPorCategoria();
        cbCategoria.addActionListener(e -> actualizarInventarioPorCategoria());
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelCentro.add(panelInventario, gbc);

        // Botones
        JPanel panelBotones = new JPanel();
        panelBotones.setOpaque(false);
        panelBotones.add(btnGuardar);
        panelBotones.add(btnCancelar);
        gbc.gridy = 8;
        panelCentro.add(panelBotones, gbc);

        add(panelCentro, BorderLayout.CENTER);
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

    private void actualizarInventarioPorCategoria() {
        panelInventario.removeAll();
        camposInventario.clear();

        CategoriaProducto categoria = (CategoriaProducto) cbCategoria.getSelectedItem();
        if (categoria == null) return;

        List<String> tallas = TallaUtil.obtenerTallasPorCategoria(categoria);

        for (String talla : tallas) {
            JLabel labelTalla = new JLabel(talla + ":");
            JTextField txtCantidad = new JTextField("0", 5);
            camposInventario.put(talla, txtCantidad);
            panelInventario.add(labelTalla);
            panelInventario.add(txtCantidad);
        }

        panelInventario.revalidate();
        panelInventario.repaint();
    }

    public List<StockPorTalla> obtenerInventario() {
        List<StockPorTalla> inventario = new ArrayList<>();
        for (Map.Entry<String, JTextField> entry : camposInventario.entrySet()) {
            String talla = entry.getKey();
            try {
                int cantidad = Integer.parseInt(entry.getValue().getText().trim());
                inventario.add(new StockPorTalla(talla, cantidad));
            } catch (NumberFormatException e) {
                inventario.add(new StockPorTalla(talla, 0));
            }
        }
        return inventario;
    }

    public int getStockTotal() {
        return obtenerInventario().stream()
                .mapToInt(s -> s.getCantidad())
                .sum();
    }

}
