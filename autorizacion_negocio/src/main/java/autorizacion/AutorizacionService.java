package autorizacion;

import dtos.CredencialesDTO;
import objetosnegocio.UsuarioBO;
import repository.UsuarioRepository;

public class AutorizacionService implements IAutorizacionService {
    // Repositorio Mock
    private UsuarioRepository repository;

    public AutorizacionService() {
        this.repository = new UsuarioRepository();
    }

    @Override
    public boolean verificarLogin(CredencialesDTO credencialesDTO) {
        boolean usuarioExistente = repository.existeUsuario(
                credencialesDTO.usuario(),
                credencialesDTO.password());

        if (!usuarioExistente) {
            return false;
        }

        UsuarioBO usuarioBO = new UsuarioBO(
                credencialesDTO.usuario(),
                credencialesDTO.password(),
                true
        );

        if (!usuarioBO.puedeIniciarSesion()){
            return false;
        }

        return true;

    }
}
