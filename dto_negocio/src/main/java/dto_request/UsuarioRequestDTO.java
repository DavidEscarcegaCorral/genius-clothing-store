package dto_request;

public class UsuarioRequestDTO {
    private String nombreUsuario;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correo;
    private String contraseña;
    private String contraseñaConfirmacion;

    public UsuarioRequestDTO(String nombreUsuario, String nombre, String apellidoPaterno, String apellidoMaterno, String correo, String contraseña, String contraseñaConfirmacion) {
        this.nombreUsuario = nombreUsuario;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.contraseña = contraseña;
        this.contraseñaConfirmacion = contraseñaConfirmacion;
    }

    public UsuarioRequestDTO() {

    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getContraseñaConfirmacion() {
        return contraseñaConfirmacion;
    }

    public void setContraseñaConfirmacion(String contraseñaConfirmacion) {
        this.contraseñaConfirmacion = contraseñaConfirmacion;
    }

    // Metodo temporal para validar las conseñas, luego lo cambiamos :v
    public boolean sonContraseñasIguales() {
        return contraseña != null && contraseña.equals(contraseñaConfirmacion);
    }
}
