package control.navegacion;

import panels.ProductoDetallePanel;

public interface INavegador {
    void navegarADetalleProdcuto(ProductoDetallePanel panelDetalle);
    void navegarACarrito();
    void irAHome();
}