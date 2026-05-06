package control;

import panels.ProductoDetallePanel;

public interface INavegador {
    void navegarADetalleProdcuto(ProductoDetallePanel panelDetalle);

    void irAHome();
}