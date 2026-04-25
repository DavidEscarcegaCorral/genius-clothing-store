package autorizacion;

public interface IAutorizacionService {
    boolean verificarLogin(String usuario, String contraseña);
}
