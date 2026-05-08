package control.navegacion;

import panels.ProductoPantalla;

public interface INavegador {
    void navegarADetalleProdcuto(ProductoPantalla panelDetalle);

    void navegarACarrito();

    void irAHome();
}