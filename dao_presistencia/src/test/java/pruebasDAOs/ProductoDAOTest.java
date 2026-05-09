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
    
    /*
    Pruebas exitosas
    */
//    @Test
//    public void agregarProducto()throws PersistenciaException {
//
//    ProductoEntidad producto = new ProductoEntidad(
//            null,
//            "Tenis SLLL",
//            "Tenis clásicos",
//            new BigDecimal("2500"),
//            "/img/TenisSL72OG.png",
//            10,
//            EstadoProducto.BORRADOR,
//            CategoriaProducto.CALZADO,
//            //Lista de tallas
//            List.of("26", "27"),
//            EtiquetaGenero.UNISEX,
//            
//            new ArrayList<>()
//    );
//
//    ProductoEntidad resultado = dao.agregarProducto(producto);
//
//    assertNotNull(resultado);
//    assertNotNull(resultado.getId());
//    assertEquals("/img/TenisSL72OG.png",
//            resultado.getRutaImagen());
//}
//    @Test
//    public void cambiarEstado()throws PersistenciaException {
//
//    ProductoEntidad producto = new ProductoEntidad(
//            null,
//            "Tenis SL72",
//            "Tenis Adidas clásicos",
//            new BigDecimal("2500"),
//            "/img/TenisSL72OG.png",
//            10,
//            EstadoProducto.BORRADOR,
//            CategoriaProducto.CALZADO,
//            List.of("26", "27"),
//            EtiquetaGenero.UNISEX,
//            new ArrayList<>()
//    );
//
//    ProductoEntidad guardado =dao.agregarProducto(producto);
//
//    ProductoEntidad actualizado =dao.cambiarEstado(guardado.getId(), EstadoProducto.PUBLICADO);
//
//    assertEquals(EstadoProducto.PUBLICADO,actualizado.getEstado());
//    
//    }
//    
//    @Test
//    public void publicarProducto() throws PersistenciaException {
//
//    ProductoEntidad producto = new ProductoEntidad(
//            null,
//            "Tenis SL75",
//            "Tenis Adidas clásicos",
//            new BigDecimal("2500"),
//            "/img/TenisSL72OG.png",
//            10,
//            EstadoProducto.BORRADOR,
//            CategoriaProducto.CALZADO,
//            List.of("26", "27"),
//            EtiquetaGenero.UNISEX,
//            new ArrayList<>()
//    );
//
//    ProductoEntidad guardado =dao.agregarProducto(producto);
//
//    ProductoEntidad publicado =dao.publicarProducto(guardado.getId());
//
//    assertEquals(EstadoProducto.PUBLICADO,publicado.getEstado());   
// }
//    
//    @Test
//    public void buscarPorId()
//        throws PersistenciaException {
//
//    ProductoEntidad producto = new ProductoEntidad(
//            null,
//            "Tenis SL72",
//            "Tenis Adidas clásicos",
//            new BigDecimal("2500"),
//            "/img/TenisSL72OG.png",
//            10,
//            EstadoProducto.BORRADOR,
//            CategoriaProducto.CALZADO,
//            List.of("26", "27"),
//            EtiquetaGenero.UNISEX,
//            new ArrayList<>()
//    );
//
//    ProductoEntidad guardado =dao.agregarProducto(producto);
//
//    ProductoEntidad encontrado =dao.buscarPorId(guardado.getId());
//
//    assertNotNull(encontrado);
//
//    assertEquals("/img/TenisSL72OG.png",encontrado.getRutaImagen());
//    
//   }
//    
//    @Test
//    public void obtenerProductos()throws PersistenciaException {
//
//    ProductoEntidad producto = new ProductoEntidad(
//            null,
//            "Tenis SL72",
//            "Tenis Adidas clásicos",
//            new BigDecimal("2500"),
//            "/img/TenisSL72OG.png",
//            10,
//            EstadoProducto.BORRADOR,
//            CategoriaProducto.CALZADO,
//            List.of("26", "27"),
//            EtiquetaGenero.UNISEX,
//            new ArrayList<>()
//    );
//
//    dao.agregarProducto(producto);
//
//    List<ProductoEntidad> productos =dao.obtenerProductos();
//
//    assertNotNull(productos);
//
//    assertFalse(productos.isEmpty());
//   }
//    
//    /*
//    Prueba de fallos
//    Verificamos que lancen la excepcion
//    */
//    
//    @Test
//    public void agregarProductoError() {
//        
//    assertThrows(PersistenciaException.class,() -> {dao.agregarProducto(null);});
//    
//    }
//    
//    @Test
//    public void cambiarEstadoIdInvalido() {
//
//    assertThrows(PersistenciaException.class,() -> {dao.cambiarEstado( "id_invalido",EstadoProducto.PUBLICADO);});
//    
//    }
//    
//    @Test
//    public void publicarProducto_dInvalido() {
//
//    assertThrows(PersistenciaException.class,() -> {dao.publicarProducto("123");});
//    
//    }
//
//    @Test
//    public void buscarPorIdIdInvalido() {
//
//    assertThrows(PersistenciaException.class,() -> { dao.buscarPorId("abc" );});
//    
//    }
//    
//    
}

