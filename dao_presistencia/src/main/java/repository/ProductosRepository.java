/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import dominio.ProductoEntidad;
import enumeradores.*;
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
                new BigDecimal("2990"), "/img/TenisSL72OG.png", 15,
                EstadoProducto.PUBLICADO, CategoriaProducto.CALZADO,
                Arrays.asList(TallasCalzado.TALLA_25,
                        TallasCalzado.TALLA_25_5,
                        TallasCalzado.TALLA_26,
                        TallasCalzado.TALLA_27), EtiquetaGenero.MUJER,
                Arrays.asList(EtiquetaEstilo.URBANO, EtiquetaEstilo.DEPORTE)
        ));
        
    }

    public List<ProductoEntidad> obtenerProductos() {
        return productosMock;
    }


}
