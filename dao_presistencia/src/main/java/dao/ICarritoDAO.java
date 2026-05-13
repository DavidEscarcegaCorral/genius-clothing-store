package dao;

import dominio.CarritoEntidad;
import excepciones.PersistenciaException;

public interface ICarritoDAO {
    CarritoEntidad obtenerCarritoPorUsuario(String usuarioId) throws PersistenciaException;
    CarritoEntidad agregarProducto(String usuarioId, String productoId, String nombre, 
            java.math.BigDecimal precio, String talla, Integer cantidad, String rutaImagen) throws PersistenciaException;
    CarritoEntidad eliminarProducto(String usuarioId, String productoId) throws PersistenciaException;
    void vaciarCarrito(String usuarioId) throws PersistenciaException;
}
