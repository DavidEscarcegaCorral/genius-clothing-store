package autorizacion;

import dao.UsuarioDAO;
import dto_request.CredencialesDTO;
import excepciones.CredencialesInvalidasException;
import excepciones.UsuarioBloqueadoException;
import objetosnegocio.UsuarioBO;

public class AutorizacionService implements IAutorizacionService {

    private final UsuarioDAO usuarioDAO;

    public AutorizacionService() {
        this.usuarioDAO = new UsuarioDAO();
    }

    @Override
    public UsuarioBO verificarLogin(CredencialesDTO credencialesDTO) {
        try {
            boolean usuarioExistente = usuarioDAO.existeUsuario(
                    credencialesDTO.usuario(),
                    credencialesDTO.password());

            if (!usuarioExistente) {
                throw new CredencialesInvalidasException("Usuario o contraseña incorrectos.");
            }

            dominio.UsuarioEntidad usuarioEntidad = usuarioDAO.buscarPorUsuario(credencialesDTO.usuario());

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
