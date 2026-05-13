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
    private EstadoProducto estadoProducto;

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
        agregarProductoDialog.getBtnGuardar().addActionListener(e -> AgregarProducto());

        administracionProductosPanel.getTabla().getSelectionModel().addListSelectionListener(e -> {
            //Entra a la condición cuando ya dejas de seleccionar
            if (!e.getValueIsAdjusting()) {
                //Obtenemos el valor de la fila seleccionada
                int fila = administracionProductosPanel.getTabla().getSelectedRow();
                //Si el usuario selecciono la fila obtiene los valores
                if (fila != -1) {
                    //Obtenemos el id y el estado para usarlos
                    idProducto = administracionProductosPanel.getTabla().getValueAt(fila, 0).toString();
                    estadoProducto = (EstadoProducto) administracionProductosPanel.getTabla().getValueAt(fila, 4);
                }
            }
        });
    }

    public void abrirDialogAgregarProducto() {
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

            List<String> tallas = new ArrayList<>();
            if (agregarProductoDialog.getChkCH().isSelected()) {
                tallas.add("CH");
            }
            if (agregarProductoDialog.getChkM().isSelected()) {
                tallas.add("M");
            }
            if (agregarProductoDialog.getChkG().isSelected()) {
                tallas.add("G");
            }
            if (agregarProductoDialog.getChkXG().isSelected()) {
                tallas.add("XG");
            }
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
            ProductoRequestDTO dto = new ProductoRequestDTO(nombre, descripcion, precio, rutaImagen, inventario, categoria, tallas, genero, estilos);
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

    public List<ProductoResponseDTO> obtenerProductos() {
        try {
            return service.obtenerProductos();
        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(null, "Error al ver los productos" + e.getMessage());
            //regresamos una lista vacia para evitar que truene
            return List.of();
        }
    }

    //Esto es para llenar la tabla del panel
    public void cargarTabla() {
        try {
            List<ProductoResponseDTO> productos = service.obtenerProductos();
            administracionProductosPanel.cargarTabla(productos);
        } catch (NegocioException e) {
            System.out.println("Error al cargar los productos " + e.getMessage());
        }
    }

    @Override
    public void cargar() {
        cargarTabla();
    }
}
