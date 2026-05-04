package autorizacion;

import objetosnegocio.UsuarioBO;

public class SesionService {
    private static UsuarioBO usuarioActual;

    public static void iniciarSesion(UsuarioBO usuario) {
        usuarioActual = usuario;
    }

    public static UsuarioBO getUsuarioActual() {
        return usuarioActual;
    }

    public static void cerrarSesionActual() {
        usuarioActual = null;
    }
}
