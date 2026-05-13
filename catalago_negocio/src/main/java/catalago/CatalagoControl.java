package catalago;

import dao.IProductoDAO;

public class CatalagoControl {
    public final IProductoDAO productoDAO;

    public CatalagoControl(IProductoDAO productoDAO) {
        this.productoDAO = productoDAO;
    }
}
