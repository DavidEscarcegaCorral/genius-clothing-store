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
                new ObjectId(), "Tenis Samba OG", "Un icono del fútbol sala convertido en leyenda urbana.",
                new BigDecimal("60.00"), "/img/TenisSL72OG.png", 15,
                EstadoProducto.DISPONIBLE, CategoriaProdcuto.CALZADO,
                Arrays.asList("25", "26", "27", "28"), EtiquetaGenero.HOMBRE,
                Arrays.asList(EtiquetaEstilo.URBANO, EtiquetaEstilo.CLASICO)
        ));

    }

    public List<ProductoEntidad> obtenerProductos() {
        return productosMock;
    }
}
