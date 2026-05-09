/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control.gestor;

import administracion.IAdministracionFacade;
import control.navegacion.NavegacionControl;
import dialogs.AgregarProductoDialog;
import dialogs.EditarProductoDialog;
import dialogs.PublicarProductoDialog;
import dtos.salida.ProductoSalidaDTO;
import excepcion.NegocioException;
import observer.IObserver;
import panels.AdministracionProductosPanel;
import panels.Header;

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
    private final PublicarProductoDialog publicarProductoDialog;

    public AdministracionProductosControl(AdministracionProductosPanel administracionProductosPanel, Header header, IAdministracionFacade service, NavegacionControl navegacion, AgregarProductoDialog agregarProductoDialog, EditarProductoDialog editarProductoDialog, PublicarProductoDialog publicarProductoDialog) {
        this.administracionProductosPanel = administracionProductosPanel;
        this.header = header;
        this.service = service;
        this.navegacion = navegacion;
        this.agregarProductoDialog = agregarProductoDialog;
        this.editarProductoDialog = editarProductoDialog;
        this.publicarProductoDialog = publicarProductoDialog;
    }
    
    public void inicializarListeners(){
        administracionProductosPanel.getAgregarProducto().addActionListener(e -> abrirDialogAgregarProducto());
        administracionProductosPanel.getModificarProducto().addActionListener(e -> abrirDialogEditarProducto());
        administracionProductosPanel.getPublicarProducto().addActionListener(e -> abrirPublicarProductoDialog());
    }
    
    
    public void abrirDialogAgregarProducto(){
        navegacion.abrirAgregarProductoDialog();
    }
    
    public void abrirDialogEditarProducto(){
        navegacion.abrirEditarProductoDialog();
    }
    
    public void abrirPublicarProductoDialog(){
        navegacion.abrirPublicarProductoDialog();
    }

    public List<ProductoSalidaDTO> obtenerProductos() {
    try {
        return service.obtenerProductos();
    } catch (NegocioException e) {
        System.out.println("Error al ver los productos"+e.getMessage());
        //regresamos una lista vacia para evitar que truene
        return List.of();
      }
    }

    //Esto es para llenar la tabla del panel
    public void cargarTabla() {
    try {
        List<ProductoSalidaDTO> productos =service.obtenerProductos();
        administracionProductosPanel.cargarTabla(productos);
    } catch (NegocioException e) {
        System.out.println("Error al cargar los productos "+e.getMessage());
     }
    }

    @Override
    public void cargar() {
        cargarTabla();
    }
}
