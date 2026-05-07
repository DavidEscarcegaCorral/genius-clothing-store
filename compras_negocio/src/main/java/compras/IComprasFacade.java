package compras;

import dtos.CarritoDTO;

public interface IComprasFacade {
    // Gestion del carrito
    CarritoDTO obtenerCarrito(String usuarioId);

    CarritoDTO agregarProdcuto(String usuarioId, String productoId, int cantidad);

    CarritoDTO eliminarProducto(String usuarioId, String productoId);

    void        vaciarCarrito(String usuarioId);

    // Agregar mas metodos del proceso de compra
}
