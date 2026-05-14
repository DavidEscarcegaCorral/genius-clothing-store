package mappers;

import dominio.UsuarioEntidad;
import objetosnegocio.UsuarioBO;

public class UsuarioMapper {

    public static UsuarioBO entidadABO(UsuarioEntidad entidad) {
        if (entidad == null) {
            return null;
        }
        return new UsuarioBO(
                entidad.getId(),
                entidad.getNombre(),
                entidad.getApellidoPaterno(),
                entidad.getEmail(),
                entidad.getNombreUsuario(),
                entidad.getPasswordHash(),
                entidad.getRol(),
                entidad.isActivo()
        );
    }

    public static UsuarioEntidad boAEntidad(UsuarioBO bo) {
        if (bo == null) {
            return null;
        }
        UsuarioEntidad entidad = new UsuarioEntidad();
        entidad.setId(bo.getId());
        entidad.setNombre(bo.getNombre());
        entidad.setApellidoPaterno(bo.getApellido());
        entidad.setEmail(bo.getEmail());
        entidad.setNombreUsuario(bo.getUsuario());
        entidad.setPasswordHash(bo.getContraseñaHash());
        entidad.setRol(bo.getRol());
        entidad.setActivo(bo.isActivo());
        return entidad;
    }
}