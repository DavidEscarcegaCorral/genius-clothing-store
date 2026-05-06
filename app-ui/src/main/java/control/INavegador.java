package control;

import panels.ProductoDetallePanel;

public interface INavegador {
    void navegarADetalle(ProductoDetallePanel panelDetalle);

    void irAHome();
}