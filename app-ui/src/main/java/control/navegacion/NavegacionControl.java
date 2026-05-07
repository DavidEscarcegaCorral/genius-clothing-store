package control.navegacion;

import frames.AdministracionProductoFrame;
import frames.GlobalFrame;
import frames.LogInFrame;
import panels.ProductoDetallePanel;

import java.util.Stack;

import static util.Constants.Pantallas.*;

public class NavegacionControl implements INavegador {
    private LogInFrame logInFrame;
    private GlobalFrame globalFrame;
    private AdministracionProductoFrame administracionProductoFrame;

    private String pantallaActual;
    private final Stack<Pantalla> historial;

    public NavegacionControl() {
        this.logInFrame = null;
        this.globalFrame = null;
        this.pantallaActual = null;
        this.historial = new Stack<>();
    }

    private static class Pantalla {
        final String nombre;
        final ProductoDetallePanel detallePanel;

        Pantalla(String nombre) {
            this(nombre, null);
        }

        Pantalla(String nombre, ProductoDetallePanel detallePanel) {
            this.nombre = nombre;
            this.detallePanel = detallePanel;
        }
    }

    public boolean tieneHistorial() {
        return !historial.isEmpty();
    }

    public void irAtras() {
        if (historial.isEmpty()) {
            return;
        }

        Pantalla pantallaAnterior = historial.pop();

        if (pantallaAnterior.detallePanel != null) {
            globalFrame.cambiarPantallaDetalle(pantallaAnterior.detallePanel);
        }

        globalFrame.mostrarPantalla(pantallaAnterior.nombre);
        pantallaActual = pantallaAnterior.nombre;
        globalFrame.setPantallaActual(pantallaActual);
        actualizarVisibilidadAtras();
    }

    private void pushHistorial(String nombre) {
        historial.push(new Pantalla(nombre));
    }

    private boolean esPantallaActual(String pantalla) {
        return pantallaActual != null && pantallaActual.equals(pantalla);
    }

    @Override
    public void irAHome() {
        validarGlobalFrame();
        if (!esPantallaActual(MAIN_PAGE)) {
            pushHistorial(pantallaActual);
            globalFrame.mostrarPantalla(MAIN_PAGE);
            pantallaActual = MAIN_PAGE;
            globalFrame.setPantallaActual(pantallaActual);
            actualizarVisibilidadAtras();
        }
    }

    @Override
    public void navegarADetalleProdcuto(ProductoDetallePanel detallePanel) {
        validarGlobalFrame();
        if (detallePanel == null) {
            throw new IllegalArgumentException("ProductoDetallePanel no puede ser null");
        }
        if (!esPantallaActual(DETALLE_PRODUCTO)) {
            pushHistorial(pantallaActual);
            globalFrame.cambiarPantallaDetalle(detallePanel);
            globalFrame.mostrarPantalla(DETALLE_PRODUCTO);
            pantallaActual = DETALLE_PRODUCTO;
            globalFrame.setPantallaActual(pantallaActual);
            actualizarVisibilidadAtras();
        }
    }

    public void navegarACarrito() {
        validarGlobalFrame();
        if (!esPantallaActual(CARRITO)) {
            pushHistorial(pantallaActual);
            globalFrame.mostrarPantalla(CARRITO);
            pantallaActual = CARRITO;
            globalFrame.setPantallaActual(pantallaActual);
            actualizarVisibilidadAtras();
        }
    }

    public void setGlobalFrame(GlobalFrame globalFrame) {
        if (globalFrame == null) {
            throw new IllegalArgumentException("El globalFrame es null");
        }
        this.globalFrame = globalFrame;
        this.globalFrame.getHeader().setHomeAction(e -> irAHome());
        this.globalFrame.getHeader().getAtrasBtn().addActionListener(e -> irAtras());
    }

    public void actualizarVisibilidadAtras() {
        if (globalFrame != null) {
            globalFrame.getHeader().setAtrasVisible(!historial.isEmpty());
        }
    }

    public void setLogInFrame(LogInFrame logInFrame) {
        if (logInFrame == null) {
            throw new IllegalArgumentException("LogInFrame no puede ser null");
        }
        this.logInFrame = logInFrame;
    }

    public void abrirGlobalFrame() {
        validarGlobalFrame();

        if (logInFrame != null) {
            logInFrame.dispose();
        }

        historial.clear();

        globalFrame.getHeader().actualizarUsuario();
        globalFrame.setVisible(true);
        pantallaActual = MAIN_PAGE;
        globalFrame.setPantallaActual(pantallaActual);
        actualizarVisibilidadAtras();
    }

    public void abrirLoginFrame() {
        validarLogInFrame();

        if (globalFrame != null) {
            globalFrame.dispose();
        }

        logInFrame.setVisible(true);
        pantallaActual = LOGIN;
    }

    private void validarGlobalFrame() {
        if (globalFrame == null) {
            throw new IllegalStateException("GlobalFrame no ha sido inicializado");
        }
    }

    public void setAdministracionProductoFrame(AdministracionProductoFrame administracionProductoFrame) {
        this.administracionProductoFrame = administracionProductoFrame;
    }

    public void abrirAdministracionProductosFrame() {
        globalFrame.dispose();
        administracionProductoFrame.setVisible(true);
    }

    private void validarLogInFrame() {
        if (logInFrame == null) {
            throw new IllegalStateException("LogInFrame no ha sido inicializado");
        }
    }
}
