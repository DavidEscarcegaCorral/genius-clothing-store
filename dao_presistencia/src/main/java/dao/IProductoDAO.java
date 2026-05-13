/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dominio.ProductoEntidad;
import enumeradores.EstadoProducto;
import excepciones.PersistenciaException;

import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IProductoDAO {

    ProductoEntidad agregarProducto(ProductoEntidad producto) throws PersistenciaException;

    ProductoEntidad cambiarEstado(String id, EstadoProducto estado) throws PersistenciaException;

    ProductoEntidad publicarProducto(String id, EstadoProducto estado) throws PersistenciaException;

    ProductoEntidad buscarPorId(String id) throws PersistenciaException;

    List<ProductoEntidad> obtenerProductos() throws PersistenciaException;

    List<ProductoEntidad> obtenerProductosPublicados() throws PersistenciaException;
}
