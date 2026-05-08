/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administracion;

import objetosnegocio.ProductoBO;
import dominio.ProductoEntidad;
import dtos.ProductoDTO;
import enumeradores.EstadoProducto;
import mappers.ProductoMapper;
import repository.ProductosRepository;
import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;
import mappers.ProductoMapper;

/**
 *
 * @author Usuario
 */
public class AdministracionFacade implements IAdministracionFacade {
    private ProductosRepository repository;
    private ProductoBO bo;

    //Cuandos se crea un AdministracionService se crea un ProductoRepository
    public AdministracionFacade() {
        this.repository = new ProductosRepository();
    }

    @Override
    public List<ProductoDTO> obtenerProductos() {
        ;
        List<ProductoEntidad> entidades = repository.obtenerProductos();

        return entidades.stream()
                .map(ProductoMapper::entidadADtoCompleto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductoDTO agregarProducto(ProductoDTO producto) {
        bo.validarProducto(producto);
        //Convertir a entidad

        //Llamar al dao

        //Regresar el dto

        return null;

    }

    @Override
    public ProductoDTO publicarProducto(String id) {
        //Buscamos el producto por el id 

        //Validar que no sea nulo

        //Convertir a DTO para validar  

        //Validar desde el BO

        //Cambiar el estado a publicado

        //Actualizar en DAO

        //Regresar dto del actualizado

        return null;
    }

    @Override
    public ProductoDTO actualizarProducto(String id, EstadoProducto estado) {
        //Validar que no sean nulo

        //Buscamos el producto por id desde la dao

        //Validamos que exista el producto

        //Validar desde el bo
        bo.validarEstado(estado);
        //Le cambiamos el estado a la entidad

        //Actualizamos desde la DAO

        //Regresamos el dto actualizado

        return null;
    }
}

