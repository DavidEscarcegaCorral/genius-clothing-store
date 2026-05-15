/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control.gestor;

import administracion.IAdministracionFacade;
import control.navegacion.NavegacionControl;
import dialogs.AgregarProductoDialog;
import dialogs.EditarProductoDialog;
import dto_request.ProductoRequestDTO;
import dto_response.ProductoResponseDTO;
import dtos.StockPorTalla;
import enumeradores.CategoriaProducto;
import enumeradores.EstadoProducto;
import enumeradores.EtiquetaEstilo;
import enumeradores.EtiquetaGenero;
import excepcion.NegocioException;
import observer.IObserver;
import panels.AdministracionProductosPanel;
import panels.Header;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class AdministracionProductosControl implements IObserver {


    private final AdministracionProductosPanel administracionProductosPanel;
    private final Header header;
    private final IAdministracionFacade service;
    private final NavegacionControl navegacion;
    private final AgregarProductoDialog agregarProductoDialog;
    private final EditarProductoDialog editarProductoDialog;
    private String idProducto;

    public AdministracionProductosControl(AdministracionProductosPanel administracionProductosPanel, Header header, IAdministracionFacade service, NavegacionControl navegacion, AgregarProductoDialog agregarProductoDialog, EditarProductoDialog editarProductoDialog) {
        this.administracionProductosPanel = administracionProductosPanel;
        this.header = header;
        this.service = service;
        this.navegacion = navegacion;
        this.agregarProductoDialog = agregarProductoDialog;
        this.editarProductoDialog = editarProductoDialog;
        inicializarListeners();
    }

    public void inicializarListeners() {
        administracionProductosPanel.getAgregarProducto().addActionListener(e -> abrirDialogAgregarProducto());
        administracionProductosPanel.getModificarProducto().addActionListener(e -> abrirDialogEditarProducto());
        administracionProductosPanel.getPublicarProducto().addActionListener(e -> publicarProducto());
        administracionProductosPanel.getBotonRegresar().addActionListener(e -> navegacion.abrirLoginFrame());
        agregarProductoDialog.getBtnCancelar().addActionListener(e -> agregarProductoDialog.dispose());
        agregarProductoDialog.getBtnGuardar().addActionListener(e -> AgregarProducto());
        editarProductoDialog.getBtnAceptar().addActionListener(e -> editarProducto());
        editarProductoDialog.getBtnCancelar().addActionListener(e -> editarProductoDialog.dispose());
        administracionProductosPanel.getTabla().getSelectionModel().addListSelectionListener(e -> {
            //Entra a la condición cuando ya dejas de seleccionar
            if (!e.getValueIsAdjusting()) {
                //Obtenemos el valor de la fila seleccionada
                int fila = administracionProductosPanel.getTabla().getSelectedRow();
                //Si el usuario selecciono la fila obtiene los valores
                if (fila != -1) {
                    //Obtenemos el id y el estado para usarlos
                    idProducto = administracionProductosPanel.getTabla().getValueAt(fila, 0).toString();
                }
            }
        });
    }

    public void abrirDialogAgregarProducto() {
        agregarProductoDialog.cargarImagenes(cargarImagenes());
        navegacion.abrirAgregarProductoDialog();
    }

    public void abrirDialogEditarProducto() {
        navegacion.abrirEditarProductoDialog();
    }

    public void abrirPublicarProductoDialog() {
        navegacion.abrirPublicarProductoDialog();
    }
    

    public AgregarProductoDialog getAgregarProductoDialog() {
        return agregarProductoDialog;
    }

    public EditarProductoDialog getEditarProductoDialog() {
        return editarProductoDialog;
    }

    public void AgregarProducto() {
        try {
            String nombre = agregarProductoDialog.getTxtNombre().getText().trim();
            String descripcion = agregarProductoDialog.getTxtDescripcion().getText().trim();
            BigDecimal precio = new BigDecimal(agregarProductoDialog.getTxtPrecio().getText().trim());
            String rutaImagen = (String) agregarProductoDialog.getCbImagen().getSelectedItem();
            List<StockPorTalla> inventario = agregarProductoDialog.obtenerInventario();

            CategoriaProducto categoria = (CategoriaProducto) agregarProductoDialog.getCbCategoria().getSelectedItem();
            EtiquetaGenero genero = (EtiquetaGenero) agregarProductoDialog.getCbGenero().getSelectedItem();
            
            List<EtiquetaEstilo> estilos = new ArrayList<>();
            if (agregarProductoDialog.getChkCasual().isSelected()) {
                estilos.add(EtiquetaEstilo.CASUAL);
            }
            if (agregarProductoDialog.getChkDeportivo().isSelected()) {
                estilos.add(EtiquetaEstilo.DEPORTIVO);
            }
            if (agregarProductoDialog.getChkUrbano().isSelected()) {
                estilos.add(EtiquetaEstilo.URBANO);
            }
            if (agregarProductoDialog.getChkFormal().isSelected()) {
                estilos.add(EtiquetaEstilo.FORMAL);
            }
            if (agregarProductoDialog.getChkElegante().isSelected()) {
                estilos.add(EtiquetaEstilo.ELEGANTE);
            }
            if (agregarProductoDialog.getChkDeporte().isSelected()) {
                estilos.add(EtiquetaEstilo.DEPORTE);
            }
            if (agregarProductoDialog.getChkClasico().isSelected()) {
                estilos.add(EtiquetaEstilo.CLASICO);
            }
            
            ProductoRequestDTO dto = new ProductoRequestDTO(nombre, descripcion, precio, rutaImagen, inventario, categoria, genero, estilos);
            service.agregarProducto(dto);

            cargarTabla();
            JOptionPane.showMessageDialog(agregarProductoDialog, "Producto agregado correctamente");
            agregarProductoDialog.setVisible(false);
        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(agregarProductoDialog, e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(agregarProductoDialog, "El precio y las cantidades deben ser números válidos.");
        }
    }

    public void publicarProducto() {
        if (idProducto == null) {
            JOptionPane.showMessageDialog(null, "Debe de seleccionar un producto primero");
            return;
        }

        int respuesta = JOptionPane.showConfirmDialog(null, "¿Deseas publicar este producto?", "Confirmar publicación", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            try {
                service.publicarProducto(idProducto);
                JOptionPane.showMessageDialog(null, "Producto publicado exitosamente");
                cargarTabla();
            } catch (NegocioException e) {
                JOptionPane.showMessageDialog(null, "Error al intentar publicar el producto" + e.getMessage());
            }
        }
    }
    
    public void editarProducto(){
        if(idProducto == null){
            JOptionPane.showMessageDialog(null, "Debe seleccionar un producto primero");
            return;
        }
         EstadoProducto nuevoEstado = (EstadoProducto) editarProductoDialog.getCombo().getSelectedItem();
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Deseas cambiar el estado del producto?","Confirmar Publicación",JOptionPane.YES_NO_OPTION);
        if(respuesta == JOptionPane.YES_OPTION){
            try{
                service.actualizarProducto(idProducto, nuevoEstado);
                JOptionPane.showMessageDialog(null, "Producto actualizado correctamente");
                cargarTabla();
                editarProductoDialog.setVisible(false);
            }catch(NegocioException e){
                JOptionPane.showMessageDialog(null, "Error al intentar cambiar el estado del producto" + e.getMessage());
            }
        }
    }

    //Esto es para llenar la tabla del panel
    public void cargarTabla() {
        try {
            List<ProductoResponseDTO> productos = service.obtenerProductos();
            administracionProductosPanel.cargarTabla(productos);
        } catch (NegocioException e) {
             JOptionPane.showMessageDialog(null, "Error al cargar los productos: " + e.getMessage());
        }
    }
    
    private String[] cargarImagenes() {
    try {
        //Buscamos las imagenes de los recursos
        java.net.URL url = getClass().getResource("/img");
        //Lo convertimos a objeto file
        java.io.File carpeta = new java.io.File(url.toURI());
        //Listamos solo los archivos que sean imagenes
        String[] archivos = carpeta.list((dir, nombre) ->nombre.endsWith(".png") || nombre.endsWith(".jpg") || nombre.endsWith(".jpeg"));
        
        if (archivos == null){
            return new String[0];
        }
        //Si no es null le damos el prefijo img a cada imagen para que quede como ruta completa
        return java.util.Arrays.stream(archivos).map(nombre -> "/img/" + nombre).toArray(String[]::new);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al cargar las imágenes: " + e.getMessage());
        return new String[0];
    }
}

    @Override
    public void cargar() {
        cargarTabla();
    }
}
