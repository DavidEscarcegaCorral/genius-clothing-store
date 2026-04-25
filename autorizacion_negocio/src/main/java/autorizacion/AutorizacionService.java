package autorizacion;

import repository.UsuarioRepository;

public class AutorizacionService implements IAutorizacionService{
    // Repositorio Mock
    private UsuarioRepository repository;

    public AutorizacionService(){
        this.repository = new UsuarioRepository();
    }

    @Override
    public boolean verificarLogin(String usuario, String contraseña) {
        // Logica de verificacion del negocio (de momento mock)
        if (usuario == null || usuario.trim().isEmpty() || contraseña == null){
            return false;
        }

        return repository.existeUsuario(usuario, contraseña);

    }
}
