package compras;

import dtos.CarritoDTO;

public class ComprasFacade implements IComprasFacade {
    @Override
    public CarritoDTO obtenerCarrito(String usuarioId) {
        return null;
    }

    @Override
    public CarritoDTO agregarProdcuto(String usuarioId, String productoId, int cantidad) {
        return null;
    }

    @Override
    public CarritoDTO eliminarProducto(String usuarioId, String productoId) {
        return null;
    }

    @Override
    public void vaciarCarrito(String usuarioId) {

    }
}
