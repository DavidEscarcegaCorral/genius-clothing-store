package dao;

import dominio.UsuarioEntidad;
import excepciones.PersistenciaException;

public interface IUsuarioDAO {
    UsuarioEntidad guardar(UsuarioEntidad usuario) throws PersistenciaException;

    UsuarioEntidad buscarPorUsuario(String nombreUsuario) throws PersistenciaException;

    UsuarioEntidad buscarPorId(String id) throws PersistenciaException;

    boolean existeUsuario(String nombreUsuario, String password) throws PersistenciaException;
}