package autorizacion;

import dtos.CredencialesDTO;
import repository.UsuarioRepository;

public class AutorizacionService implements IAutorizacionService{
    // Repositorio Mock
    private UsuarioRepository repository;

    public AutorizacionService(){
        this.repository = new UsuarioRepository();
    }

    @Override
    public boolean verificarLogin(CredencialesDTO credencialesDTO) {
        return true;
    }
}
