/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import administracion.IAdministracionService;
import dialogs.AgregarProductoDialog;
import dialogs.EditarProductoDialog;
import dialogs.PublicarProductoDialog;
import dtos.ProductoDTO;
import java.util.List;
import panels.AdministracionProductosPanel;
import panels.Header;

/**
 *
 * @author Usuario
 */
public class AdministracionProductosControl {

    private final AdministracionProductosPanel administracionProductosPanel;
    private final Header header;
    private final IAdministracionService service;
    private final NavegacionControl navegacion;
    private final AgregarProductoDialog agregarProductoDialog;
    private final EditarProductoDialog editarProductoDialog;
    private final PublicarProductoDialog publicarProductoDialog;

    public AdministracionProductosControl(AdministracionProductosPanel administracionProductosPanel, Header header, IAdministracionService service, NavegacionControl navegacion, AgregarProductoDialog agregarProductoDialog, EditarProductoDialog editarProductoDialog, PublicarProductoDialog publicarProductoDialog) {
        this.administracionProductosPanel = administracionProductosPanel;
        this.header = header;
        this.service = service;
        this.navegacion = navegacion;
        this.agregarProductoDialog = agregarProductoDialog;
        this.editarProductoDialog = editarProductoDialog;
        this.publicarProductoDialog = publicarProductoDialog;
        cargarTabla();
    }

   public List<ProductoDTO> obtenerProductos(){
       return service.obtenerProductos();
   }
    
   //Esto es para llenar la tabla del panel
   public void cargarTabla() {
    List<ProductoDTO> productos = service.obtenerProductos();
    administracionProductosPanel.cargarTabla(productos);
}
}
