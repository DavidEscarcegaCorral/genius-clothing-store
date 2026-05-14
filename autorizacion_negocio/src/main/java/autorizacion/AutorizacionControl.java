package autorizacion;

import dao.IUsuarioDAO;
import dominio.UsuarioEntidad;
import excepciones.PersistenciaException;
import mappers.UsuarioMapper;
import objetosnegocio.UsuarioBO;

public class AutorizacionControl {
    private final IUsuarioDAO usuarioDAO;

    public AutorizacionControl(IUsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public boolean verificarUsuarioExistente(String nombreUsuario, String password) throws PersistenciaException {
        return usuarioDAO.existeUsuario(nombreUsuario, password);
    }

    public UsuarioEntidad buscarPorUsuario(String nombreUsuario) throws PersistenciaException {
        return usuarioDAO.buscarPorUsuario(nombreUsuario);
    }

    public UsuarioEntidad buscarPorId(String id) throws PersistenciaException {
        return usuarioDAO.buscarPorId(id);
    }

    public UsuarioBO convertirEntidadABO(UsuarioEntidad entidad) {
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
}