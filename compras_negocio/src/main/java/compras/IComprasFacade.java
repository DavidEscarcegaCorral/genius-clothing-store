package compras;

import dtos.CarritoDTO;

public interface IComprasFacade {
    CarritoDTO obtenerCarrito(String usuarioId);

    CarritoDTO agregarProdcuto(String usuarioId, String productoId, String talla, int cantidad);

    CarritoDTO eliminarProducto(String usuarioId, String productoId);

    void vaciarCarrito(String usuarioId);

    boolean validarUsuarioActivo(String usuarioId);

}
