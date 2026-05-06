package control;

import panels.ProductoDetallePanel;

public interface Navegador {
    void navegarADetalle(ProductoDetallePanel panelDetalle);
    void irAHome();
}