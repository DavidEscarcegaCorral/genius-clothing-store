package autorizacion;

import dao.UsuarioDAO;
import dto_request.UsuarioLoginDTO;
import excepciones.CredencialesInvalidasException;
import excepciones.PersistenciaException;
import objetosnegocio.UsuarioBO;

public class AutorizacionFacade implements IAutorizacionFacade {

    private final AutorizacionControl autorizacionControl;

    public AutorizacionFacade() {
        this.autorizacionControl = new AutorizacionControl(new UsuarioDAO());
    }

    @Override
    public UsuarioBO verificarLogin(UsuarioLoginDTO usuarioLoginDTO) {
        try {
            boolean usuarioExistente = autorizacionControl.verificarUsuarioExistente(
                    usuarioLoginDTO.usuario(),
                    usuarioLoginDTO.password());

            if (!usuarioExistente) {
                throw new CredencialesInvalidasException("Usuario o contraseña incorrectos.");
            }

            dominio.UsuarioEntidad usuarioEntidad = autorizacionControl.buscarPorUsuario(usuarioLoginDTO.usuario());

            if (usuarioEntidad == null) {
                throw new CredencialesInvalidasException("Usuario o contraseña incorrectos.");
            }

            UsuarioBO usuarioBO = autorizacionControl.convertirEntidadABO(usuarioEntidad);

            if (!usuarioBO.puedeIniciarSesion()) {
                throw new CredencialesInvalidasException("La cuenta está inactiva o bloqueada.");
            }

            return usuarioBO;
        } catch (PersistenciaException e) {
            throw new CredencialesInvalidasException("Error al iniciar sesión: " + e.getMessage());
        }
    }

    public UsuarioBO obtenerUsuarioPorId(String id) {
        try {
            dominio.UsuarioEntidad entidad = autorizacionControl.buscarPorId(id);
            return autorizacionControl.convertirEntidadABO(entidad);
        } catch (PersistenciaException e) {
            throw new CredencialesInvalidasException("Error al obtener usuario: " + e.getMessage());
        }
    }
}