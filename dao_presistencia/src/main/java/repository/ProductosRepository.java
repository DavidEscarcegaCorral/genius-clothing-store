/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import dominio.ProductoEntidad;
import enumeradores.CategoriaProdcuto;
import enumeradores.EstadoProducto;
import enumeradores.EtiquetaEstilo;
import enumeradores.EtiquetaGenero;
import org.bson.types.ObjectId;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ProductosRepository {
    private List<ProductoEntidad> productosMock;

    public ProductosRepository() {
        inicializarProductosMock();
    }

    public void inicializarProductosMock() {
        productosMock = new ArrayList<>();

        productosMock.add(new ProductoEntidad(
                new ObjectId(), "Tenis SL72 OG", "Lanzados por primera vez en 1972, los tenis " +
                "adidas SL72 OG tienen una estructura liviana que revolucionó el running. " +
                "Hoy en día, el exterior de nylon transpirable, los revestimientos de gamuza y los detalles en piel le " +
                "imprimen un estilo de inspiración retro a tu vida activa.",
                new BigDecimal("2,2990.00"), "/img/TenisSL72OG.png", 15,
                EstadoProducto.DISPONIBLE, CategoriaProdcuto.CALZADO,
                Arrays.asList("25", "26", "27", "28"), EtiquetaGenero.HOMBRE,
                Arrays.asList(EtiquetaEstilo.URBANO, EtiquetaEstilo.CLASICO)
        ));

    }

    public List<ProductoEntidad> obtenerProductos() {
        return productosMock;
    }
}
