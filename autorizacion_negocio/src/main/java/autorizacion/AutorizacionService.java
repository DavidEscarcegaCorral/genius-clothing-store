package autorizacion;

import dto_request.CredencialesDTO;
import excepciones.CredencialesInvalidasException;
import excepciones.UsuarioBloqueadoException;
import objetosnegocio.UsuarioBO;
import repository.UsuarioRepository;

public class AutorizacionService implements IAutorizacionService {
    // Repositorio Mock
    private UsuarioRepository repository;

    public AutorizacionService() {
        this.repository = new UsuarioRepository();
    }

    @Override
    public UsuarioBO verificarLogin(CredencialesDTO credencialesDTO) {
        boolean usuarioExistente = repository.existeUsuario(
                credencialesDTO.usuario(),
                credencialesDTO.password());

        if (!usuarioExistente) {
            throw new CredencialesInvalidasException("Usuario o contraseña incorrectos.");
        }

        // de momento solo devuelve datos de login para trabajar en sesionservice
        UsuarioBO usuarioBO = new UsuarioBO(
                credencialesDTO.usuario(),
                credencialesDTO.password(),
                true
        );

        // Regla para validar que el usuario no este en estado inactivo
        if (!usuarioBO.puedeIniciarSesion()) {
            throw new UsuarioBloqueadoException("La cuenta está inactiva o bloqueada.");
        }

        return usuarioBO;

    }
}
