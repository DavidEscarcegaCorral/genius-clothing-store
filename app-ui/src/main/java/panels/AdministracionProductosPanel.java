/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package panels;

import componentes.BotonRedondeado;
import dtos.ProductoDTO;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class AdministracionProductosPanel extends JPanel{
    
    private BotonRedondeado agregarProducto;
    private BotonRedondeado publicarProducto;
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
        publicarProducto = new BotonRedondeado("Publicar Producto");
        panelBotones.add(publicarProducto,BorderLayout.SOUTH);
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

    public BotonRedondeado getPublicarProducto() {
        return publicarProducto;
    }

    public BotonRedondeado getModificarProducto() {
        return modificarProducto;
    }

    
    public JTable getTabla() {
        return tabla;
    }
    
    public void cargarTabla(List<ProductoDTO> productos) {
    //Definimos las columnas que queremos mostrar en las tablas
    String[] columnas = {"ID", "Nombre", "Precio", "Stock", "Estado"};
    //Creamos una tabla con las columnas
    DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

    //Le damos a cada columna lo que va a mostrar
    for (ProductoDTO p : productos) {
        Object[] fila = {
            p.getId(),
            p.getNombre(),
            p.getPrecio(),
            p.getStock(),
            p.getEstado()
        };
        //Agregamos la fila a la tabla
        modelo.addRow(fila);
    }
    //Se lo asignamos al JTable
    tabla.setModel(modelo);
    }
}