/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import dominio.ProductoEntidad;
import enumeradores.CategoriaProducto;
import enumeradores.EstadoProducto;
import enumeradores.EtiquetaEstilo;
import enumeradores.EtiquetaGenero;
import org.bson.types.ObjectId;
import util.TallaUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
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
                TallaUtil.obtenerTallasPorCategoria(CategoriaProducto.CALZADO), EtiquetaGenero.MUJER,
                Arrays.asList(EtiquetaEstilo.URBANO, EtiquetaEstilo.DEPORTE)
        ));

        productosMock.add(new ProductoEntidad(
                new ObjectId(), "Playera polo nike sportswear", "Renueva tu estilo con la Playera Polo Nike Sportswear" +
                " que redefine el look deportivo con un acabado más sofisticado. El diseño convierte los logos Swoosh en un patrón de encaje " +
                "que eleva el outfit sin perder la vibra urbana. Su ajuste cuadrado mantiene la sensación de jersey " +
                "clásico y facilita el movimiento para uso diario.",
                new BigDecimal("1899"), "/img/PlayeraPoloNikeSportswear.jpg", 25,
                EstadoProducto.PUBLICADO, CategoriaProducto.CAMISETA,
                TallaUtil.obtenerTallasPorCategoria(CategoriaProducto.CAMISETA), EtiquetaGenero.MUJER,
                Arrays.asList(EtiquetaEstilo.URBANO, EtiquetaEstilo.DEPORTE)
        ));

    }

    public List<ProductoEntidad> obtenerProductos() {
        return productosMock;
    }

    public ProductoEntidad busarPorId(ObjectId id) {
        if (id == null) {
            return null;
        }

        return productosMock.stream()
                .filter(productoEntidad -> productoEntidad.getId().equals(id))
                .findFirst()
                .orElse(null);
    }


}
