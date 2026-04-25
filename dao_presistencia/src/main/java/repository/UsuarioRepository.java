package repository;

public class UsuarioRepository {
    public boolean existeUsuario(String usuario, String contraseña){
        String usuario1 = "user";
        String contra1 = "1234";

        return usuario.equals(usuario1) && contraseña.equals(contra1);
    }
}
