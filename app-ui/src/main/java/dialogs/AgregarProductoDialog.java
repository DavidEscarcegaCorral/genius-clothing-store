/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dialogs;

import componentes.BotonRedondeado;
import enumeradores.CategoriaProducto;
import enumeradores.EstadoProducto;
import enumeradores.EtiquetaGenero;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import util.Estilo;

/**
 *
 * @author Usuario
 */
public class AgregarProductoDialog extends JDialog{

    private JTextField txtNombre;
    private JTextArea txtDescripcion;
    private JTextField txtPrecio;
    private JTextField txtRutaImagen;
    private JTextField txtStock;

    private JComboBox<EstadoProducto> cbEstado;
    private JComboBox<CategoriaProducto> cbCategoria;
    private JComboBox<EtiquetaGenero> cbGenero;

    private JCheckBox chkCH;
    private JCheckBox chkM;
    private JCheckBox chkG;
    private JCheckBox chkXG;

    private JCheckBox chkCasual;
    private JCheckBox chkDeportivo;
    private JCheckBox chkUrbano;
    private JCheckBox chkFormal;


    private BotonRedondeado btnGuardar;
    private BotonRedondeado btnCancelar;

    public AgregarProductoDialog() {
        setTitle("Agregar un producto");
        setBackground(Estilo.AMARILLO_GENIUS);
        inicializarComponentes();
    }
    
    private void inicializarComponentes(){
        System.out.println("jala");
    }
    
}
