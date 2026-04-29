package objetosnegocio;

import enumeradores.RolUsuario;

public class UsuarioBO {
    private String id;
    private String nombre;
    private String apellido;
    private String email;
    private String usuario;
    private String contraseñaHash;
    private RolUsuario rol;
    private boolean activo;

    public UsuarioBO() {
    }

    public UsuarioBO(String id, String nombre, String apellido, String email, String usuario, String contraseñaHash, RolUsuario rol, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.usuario = usuario;
        this.contraseñaHash = contraseñaHash;
        this.rol = rol;
        this.activo = activo;
    }

    // Constructor para login
    public UsuarioBO(String usuario, String contraseñaHash, boolean activo) {
        this.usuario = usuario;
        this.contraseñaHash = contraseñaHash;
        this.activo = activo;
    }

    // Validar contraseña
    public boolean validarContraseña(String contraseña) {
        if (contraseña == null || this.contraseñaHash == null) {
            return false;
        }

        return this.contraseñaHash.equals(contraseña);
    }

    // Para validar si el usuario no esta suspendido
    public boolean puedeIniciarSesion(){
        return this.activo;
    }

    @Override
    public String toString() {
        return "UsuarioBO{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", usuario='" + usuario + '\'' +
                ", contraseñaHash='" + contraseñaHash + '\'' +
                ", rol=" + rol +
                ", activo=" + activo +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseñaHash() {
        return contraseñaHash;
    }

    public void setContraseñaHash(String contraseñaHash) {
        this.contraseñaHash = contraseñaHash;
    }

    public RolUsuario getRol() {
        return rol;
    }

    public void setRol(RolUsuario rol) {
        this.rol = rol;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
