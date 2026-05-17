/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebasDAOs;

import static com.mongodb.assertions.Assertions.assertNotNull;
import dao.IProductoDAO;
import dao.ProductoDAO;
import dominio.ProductoEntidad;
import enumeradores.CategoriaProducto;
import enumeradores.EstadoProducto;
import enumeradores.EtiquetaGenero;
import excepciones.PersistenciaException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Usuario
 */
public class ProductoDAOTest {
    
    IProductoDAO dao = new ProductoDAO();
    
//    @Test
//    public void testAgregarProductoCorrectamente() throws PersistenciaException {
//
//        ProductoDAO dao = new ProductoDAO();
//
//        ProductoEntidad producto = new ProductoEntidad();
//
//        producto.setNombre("Playera Oversize");
//        producto.setDescrpcionProducto("Playera negra");
//        producto.setPrecio(new BigDecimal("499.99"));
//        producto.setRutaImagen("imagen.png");
//
//        producto.setEstado(EstadoProducto.PUBLICADO);
//        producto.setCategoria(CategoriaProducto.CAMISETA);
//        producto.setGenero(EtiquetaGenero.UNISEX);
//
//        producto.setInventario(new ArrayList<>());
//        producto.setEstilos(new ArrayList<>());
//
//        ProductoEntidad resultado = dao.agregarProducto(producto);
//
//        assertNotNull(resultado);
//        assertNotNull(resultado.getId());
//        assertEquals("Playera Oversize", resultado.getNombre());
//    }
//
//    @Test
//    public void testAgregarProductoNull() {
//
//        ProductoDAO dao = new ProductoDAO();
//
//        assertThrows(
//                PersistenciaException.class,
//                () -> dao.agregarProducto(null)
//        );
//    }
//
//    @Test
//    public void testCambiarEstadoCorrectamente() throws PersistenciaException {
//
//        ProductoDAO dao = new ProductoDAO();
//
//        ProductoEntidad producto = new ProductoEntidad();
//
//        producto.setNombre("Sudadera");
//        producto.setDescrpcionProducto("Sudadera negra");
//        producto.setPrecio(new BigDecimal("899.99"));
//        producto.setRutaImagen("/img/imagen.png");
//
//        producto.setEstado(EstadoProducto.BORRADOR);
//        producto.setCategoria(CategoriaProducto.SUDADERA);
//        producto.setGenero(EtiquetaGenero.UNISEX);
//
//        producto.setInventario(new ArrayList<>());
//        producto.setEstilos(new ArrayList<>());
//
//        ProductoEntidad guardado = dao.agregarProducto(producto);
//
//        ProductoEntidad actualizado =
//                dao.cambiarEstado(
//                        guardado.getId(),
//                        EstadoProducto.PUBLICADO
//                );
//
//        assertEquals(
//                EstadoProducto.PUBLICADO,
//                actualizado.getEstado()
//        );
//    }
//
//    @Test
//    public void testCambiarEstadoIdInvalido() {
//
//        ProductoDAO dao = new ProductoDAO();
//
//        assertThrows(
//                PersistenciaException.class,
//                () -> dao.cambiarEstado(
//                        "123",
//                        EstadoProducto.PUBLICADO
//                )
//        );
//    }
//
//    @Test
//    public void testPublicarProductoCorrectamente() throws PersistenciaException {
//
//        ProductoDAO dao = new ProductoDAO();
//
//        ProductoEntidad producto = new ProductoEntidad();
//
//        producto.setNombre("Pantalon");
//        producto.setDescrpcionProducto("Pantalon cargo");
//        producto.setPrecio(new BigDecimal("799.99"));
//        producto.setRutaImagen("/img/imagen.png");
//
//        producto.setEstado(EstadoProducto.BORRADOR);
//        producto.setCategoria(CategoriaProducto.PANTALON);
//        producto.setGenero(EtiquetaGenero.UNISEX);
//
//        producto.setInventario(new ArrayList<>());
//        producto.setEstilos(new ArrayList<>());
//
//        ProductoEntidad guardado = dao.agregarProducto(producto);
//
//        ProductoEntidad publicado =
//                dao.publicarProducto(
//                        guardado.getId(),
//                        EstadoProducto.PUBLICADO
//                );
//
//        assertEquals(
//                EstadoProducto.PUBLICADO,
//                publicado.getEstado()
//        );
//    }
//
//    @Test
//    public void testBuscarPorIdCorrectamente() throws PersistenciaException {
//
//        ProductoDAO dao = new ProductoDAO();
//
//        ProductoEntidad producto = new ProductoEntidad();
//
//        producto.setNombre("Gorra");
//        producto.setDescrpcionProducto("Gorra negra");
//        producto.setPrecio(new BigDecimal("299.99"));
//        producto.setRutaImagen("/img/imagen.png");
//
//        producto.setEstado(EstadoProducto.PUBLICADO);
//        producto.setCategoria(CategoriaProducto.ACCESORIOS);
//        producto.setGenero(EtiquetaGenero.UNISEX);
//
//        producto.setInventario(new ArrayList<>());
//        producto.setEstilos(new ArrayList<>());
//
//        ProductoEntidad guardado = dao.agregarProducto(producto);
//
//        ProductoEntidad encontrado =
//                dao.buscarPorId(guardado.getId());
//
//        assertNotNull(encontrado);
//        assertEquals("Gorra", encontrado.getNombre());
//    }
//
//    @Test
//    public void testBuscarPorIdInvalido() {
//
//        ProductoDAO dao = new ProductoDAO();
//
//        assertThrows(
//                PersistenciaException.class,
//                () -> dao.buscarPorId("abc")
//        );
//    }
//
//    @Test
//    public void testObtenerProductos() throws PersistenciaException {
//
//        ProductoDAO dao = new ProductoDAO();
//
//        List<ProductoEntidad> productos =
//                dao.obtenerProductos();
//
//        assertNotNull(productos);
//    }
//
//    @Test
//    public void testObtenerProductosPublicados() throws PersistenciaException {
//
//        ProductoDAO dao = new ProductoDAO();
//
//        List<ProductoEntidad> productos =
//                dao.obtenerProductosPublicados();
//
//        assertNotNull(productos);
//
//        for (ProductoEntidad producto : productos) {
//
//            assertEquals(
//                    EstadoProducto.PUBLICADO,
//                    producto.getEstado()
//            );
//        }
//    }
//
//    @Test
//    public void testBuscarPorNombreExistente() throws PersistenciaException {
//
//        ProductoDAO dao = new ProductoDAO();
//
//        ProductoEntidad producto = new ProductoEntidad();
//        producto.setNombre("Tenis Jordan");
//        producto.setDescrpcionProducto("Tenis Jordan negro");
//        producto.setPrecio(new BigDecimal("1299.99"));
//        producto.setRutaImagen("/img/imagen.png");
//        producto.setEstado(EstadoProducto.BORRADOR);
//        producto.setCategoria(CategoriaProducto.CALZADO);
//        producto.setGenero(EtiquetaGenero.UNISEX);
//        producto.setInventario(new ArrayList<>());
//        producto.setEstilos(new ArrayList<>());
//        dao.agregarProducto(producto);
//
//        // Busca por ese nombre y verifica que lo encuentre
//        ProductoEntidad encontrado = dao.buscarPorNombre("Tenis Jordan");
//
//        assertNotNull(encontrado);
//        assertEquals("Tenis Jordan", encontrado.getNombre());
//    }
//
//    @Test
//    public void testBuscarPorNombreNoExistente() throws PersistenciaException {
//
//        ProductoDAO dao = new ProductoDAO();
//
//        ProductoEntidad encontrado = dao.buscarPorNombre("NombreQueNoExiste12345");
//
//        assertNull(encontrado);
//    }
}

