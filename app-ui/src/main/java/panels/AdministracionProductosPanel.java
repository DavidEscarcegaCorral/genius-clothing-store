/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package panels;

import componentes.BotonRedondeado;
import componentes.LogoGenius;
import componentes.TituloPantalla;
import dtos.salida.ProductoSalidaDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import util.Estilo;

/**
 *
 * @author Usuario
 */
public class AdministracionProductosPanel extends JPanel{
    
    private BotonRedondeado agregarProducto;
    private BotonRedondeado publicarProducto;
    private BotonRedondeado modificarProducto;
    JTable tabla = new JTable();
    public AdministracionProductosPanel() {
        setLayout(new BorderLayout());
        setOpaque(true);
        setBackground(Estilo.AMARILLO_GENIUS);
        iniciarComponentes();
        
    }
    
    private void iniciarComponentes(){
        JPanel panelNorte = new JPanel();
        LogoGenius logo = new LogoGenius();
        panelNorte.add(logo);
        BuscadorGenius buscador = new BuscadorGenius();
        panelNorte.add(buscador);
        panelNorte.setBackground(Color.BLACK);
        add(panelNorte,BorderLayout.NORTH);
        JPanel panelBotones = new JPanel();
        
        agregarProducto = new BotonRedondeado("Agregar Producto");
        panelBotones.add(agregarProducto);
        publicarProducto = new BotonRedondeado("Publicar Producto");
        panelBotones.add(publicarProducto);
        modificarProducto = new BotonRedondeado("Modificar Producto");
        panelBotones.add(modificarProducto);
        panelBotones.setOpaque(false);
        add(panelBotones,BorderLayout.SOUTH);
        tabla = new JTable();
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        add(scroll,BorderLayout.CENTER);
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
    
    public void cargarTabla(List<ProductoSalidaDTO> productos) {
    //Definimos las columnas que queremos mostrar en las tablas
    String[] columnas = {"ID", "Nombre", "Precio", "Stock", "Estado"};
    //Creamos una tabla con las columnas
    DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

    //Le damos a cada columna lo que va a mostrar
    for (ProductoSalidaDTO p : productos) {
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