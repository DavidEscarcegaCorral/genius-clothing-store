package autorizacion;

import dao.UsuarioDAO;
import dto_request.UsuarioLoginDTO;
import excepciones.CredencialesInvalidasException;
import excepciones.UsuarioBloqueadoException;
import objetosnegocio.UsuarioBO;

public class AutorizacionFacade implements IAutorizacionFacade {

    private final UsuarioDAO usuarioDAO;

    public AutorizacionFacade() {
        this.usuarioDAO = new UsuarioDAO();
    }

    @Override
    public UsuarioBO verificarLogin(UsuarioLoginDTO usuarioLoginDTO) {
        try {
            boolean usuarioExistente = usuarioDAO.existeUsuario(
                    usuarioLoginDTO.usuario(),
                    usuarioLoginDTO.password());

            if (!usuarioExistente) {
                throw new CredencialesInvalidasException("Usuario o contraseña incorrectos.");
            }

            dominio.UsuarioEntidad usuarioEntidad = usuarioDAO.buscarPorUsuario(usuarioLoginDTO.usuario());

            if (usuarioEntidad == null) {
                throw new CredencialesInvalidasException("Usuario o contraseña incorrectos.");
            }

            UsuarioBO usuarioBO = new UsuarioBO(
                    usuarioEntidad.getId(),
                    usuarioEntidad.getNombre(),
                    usuarioEntidad.getApellidoPaterno(),
                    usuarioEntidad.getEmail(),
                    usuarioEntidad.getNombreUsuario(),
                    usuarioEntidad.getPasswordHash(),
                    usuarioEntidad.getRol(),
                    usuarioEntidad.isActivo()
            );

            if (!usuarioBO.puedeIniciarSesion()) {
                throw new UsuarioBloqueadoException("La cuenta está inactiva o bloqueada.");
            }

            return usuarioBO;
        } catch (excepciones.PersistenciaException e) {
            throw new CredencialesInvalidasException("Error al iniciar sesión: " + e.getMessage());
        } catch (CredencialesInvalidasException | UsuarioBloqueadoException e) {
            throw e;
        }
    }
}
