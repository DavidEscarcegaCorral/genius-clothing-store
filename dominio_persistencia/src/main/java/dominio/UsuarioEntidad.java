package dominio;

import enumeradores.RolUsuario;

import java.time.LocalDateTime;
import java.util.List;

public class UsuarioEntidad {

    private String id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String email;
    private String nombreUsuario;
    private String passwordHash;
    private RolUsuario rol;
    private boolean activo;
    private int intentosFallidos;
    private LocalDateTime fechaCreacion;
    private List<DireccionEntidad> direccionesEnvio;

    public UsuarioEntidad() {
    }

    public UsuarioEntidad(String id, String nombre, String apellidoPaterno, String apellidoMaterno, String email, String nombreUsuario, String passwordHash, RolUsuario rol, boolean activo, int intentosFallidos, LocalDateTime fechaCreacion, List<DireccionEntidad> direccionesEnvio) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.email = email;
        this.nombreUsuario = nombreUsuario;
        this.passwordHash = passwordHash;
        this.rol = rol;
        this.activo = activo;
        this.intentosFallidos = intentosFallidos;
        this.fechaCreacion = fechaCreacion;
        this.direccionesEnvio = direccionesEnvio;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
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

    public int getIntentosFallidos() {
        return intentosFallidos;
    }

    public void setIntentosFallidos(int intentosFallidos) {
        this.intentosFallidos = intentosFallidos;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public List<DireccionEntidad> getDireccionesEnvio() {
        return direccionesEnvio;
    }

    public void setDireccionesEnvio(List<DireccionEntidad> direccionesEnvio) {
        this.direccionesEnvio = direccionesEnvio;
    }
}
