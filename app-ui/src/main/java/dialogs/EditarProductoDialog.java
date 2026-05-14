/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dialogs;

import componentes.BotonRedondeado;
import componentes.ComboBoxGenius;
import enumeradores.EstadoProducto;
import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import util.Estilo;

/**
 *
 * @author Usuario
 */
public class EditarProductoDialog extends JDialog{
    
    BotonRedondeado btnCancelar = new BotonRedondeado("Cancelar");
    BotonRedondeado btnAceptar = new BotonRedondeado("Aceptar");
    
    //El publicado es aparte
    EstadoProducto[] permitidos = {
    EstadoProducto.BORRADOR,
    EstadoProducto.AGOTADO,
    EstadoProducto.PAUSADO
    };

    ComboBoxGenius<EstadoProducto> combo = new ComboBoxGenius<>(permitidos);

    public EditarProductoDialog() {
        setTitle("Editar producto");
        setLayout(new BorderLayout());
        getContentPane().setBackground(Estilo.AMARILLO_GENIUS);
        inicializarComponentes();
        pack();
        setLocationRelativeTo(null);
    }
    
    private void inicializarComponentes(){
        add(combo,BorderLayout.CENTER);
        JPanel botonesSur = new JPanel();
        botonesSur.add(btnCancelar);
        botonesSur.add(btnAceptar);
        add(botonesSur,BorderLayout.SOUTH);
    }

    public BotonRedondeado getBtnCancelar() {
        return btnCancelar;
    }

    

    public BotonRedondeado getBtnAceptar() {
        return btnAceptar;
    }

    public ComboBoxGenius<EstadoProducto> getCombo() {
        return combo;
    }
    
    
    
}
