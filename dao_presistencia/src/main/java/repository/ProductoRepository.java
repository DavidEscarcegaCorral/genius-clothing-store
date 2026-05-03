/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import dominio.ProductoEntidad;
import enumeradores.EstadoProducto;
import org.bson.types.ObjectId;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ProductoRepository {
    private List<ProductoEntidad> productosMock;

    public ProductoRepository() {
    }

    public void inicializarProductosMock() {
        productosMock = new ArrayList<>();

        productosMock.add(new ProductoEntidad(
                new ObjectId(),
                "zapato1",
                "Un zapato",
                new BigDecimal("232.22"),
                "\"C:\\Users\\Usuario\\Downloads\\descarga (2).png\"",
                22,
                EstadoProducto.PAUSADO
        ));

        productosMock.add(new ProductoEntidad(
                new ObjectId(),
                "zapato2",
                "Un tenni",
                new BigDecimal("555.88"),
                "\"C:\\Users\\Usuario\\Downloads\\descarga (2).png\"",
                78,
                EstadoProducto.BORRADOR
        ));
    }

    public List<ProductoEntidad> obtenerProductos() {
        return productosMock;
    }
}
