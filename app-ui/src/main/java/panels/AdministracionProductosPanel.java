/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package panels;

import componentes.BotonRedondeado;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Usuario
 */
public class AdministracionProductosPanel extends JPanel{
    
    private BotonRedondeado agregarProducto;
    private BotonRedondeado eliminarProducto;
    private BotonRedondeado publicarProducto;
    private BotonRedondeado verProductos;
    private BotonRedondeado modificarProducto;
    private Header header;
    JTable tabla = new JTable();
    public AdministracionProductosPanel() {
        setLayout(new BorderLayout());
        setOpaque(false);
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        
        JPanel panelBotones = new JPanel();
        
        agregarProducto = new BotonRedondeado("Agregar Producto");
        panelBotones.add(agregarProducto,BorderLayout.SOUTH);
        eliminarProducto = new BotonRedondeado("Eliminar Producto");
        panelBotones.add(eliminarProducto,BorderLayout.SOUTH);
        publicarProducto = new BotonRedondeado("Publicar Producto");
        panelBotones.add(publicarProducto,BorderLayout.SOUTH);
        verProductos = new BotonRedondeado("Ver Productos");
        panelBotones.add(verProductos,BorderLayout.SOUTH);
        modificarProducto = new BotonRedondeado("Modificar Producto");
        panelBotones.add(modificarProducto,BorderLayout.SOUTH);
        
        tabla = new JTable();
        JScrollPane scroll = new JScrollPane();
        add(scroll,BorderLayout.CENTER);
        add(header,BorderLayout.NORTH);
    }

    public BotonRedondeado getAgregarProducto() {
        return agregarProducto;
    }

    public void setAgregarProducto(BotonRedondeado agregarProducto) {
        this.agregarProducto = agregarProducto;
    }

    public BotonRedondeado getEliminarProducto() {
        return eliminarProducto;
    }

    public void setEliminarProducto(BotonRedondeado eliminarProducto) {
        this.eliminarProducto = eliminarProducto;
    }

    public BotonRedondeado getPublicarProducto() {
        return publicarProducto;
    }

    public void setPublicarProducto(BotonRedondeado publicarProducto) {
        this.publicarProducto = publicarProducto;
    }

    public BotonRedondeado getVerProductos() {
        return verProductos;
    }

    public void setVerProductos(BotonRedondeado verProductos) {
        this.verProductos = verProductos;
    }

    public BotonRedondeado getModificarProducto() {
        return modificarProducto;
    }

    public void setModificarProducto(BotonRedondeado modificarProducto) {
        this.modificarProducto = modificarProducto;
    }

    public JTable getTabla() {
        return tabla;
    }
    
    
}
