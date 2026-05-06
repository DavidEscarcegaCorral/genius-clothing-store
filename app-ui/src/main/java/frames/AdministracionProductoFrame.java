/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import observer.IObserver;
import panels.AdministracionProductosPanel;
import panels.Header;

/**
 *
 * @author Usuario
 */
public class AdministracionProductoFrame extends JFrame {
   
    public AdministracionProductosPanel administracionProductosPanel;
    private IObserver observer;
    
    public AdministracionProductoFrame() {
        
        setTitle("Menu de productos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);
        setMinimumSize(new Dimension(300,200));
        
        administracionProductosPanel = new AdministracionProductosPanel();
        add(administracionProductosPanel);
        
        //Centramos los componentes
        pack();
        //Centramos la pantalla
        setLocationRelativeTo(null);
    }

    public AdministracionProductosPanel getAdministracionProductosPanel() {
        return administracionProductosPanel;
    }

    public void setObserver(IObserver observer) {
        this.observer = observer;
    }
    
    //Si es true carga la tabla
    @Override
    public void setVisible(boolean visible) {
        if (visible && observer != null) {
            observer.cargar();
        }
        super.setVisible(visible);
    }
}
