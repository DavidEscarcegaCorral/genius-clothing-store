package entidadesmongo;

import enumeradores.RolUsuario;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

public class UsuarioMongoEntidad {

    @BsonId
    private ObjectId id;

    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String email;
    private String nombreUsuario;
    private String passwordHash;
    private RolUsuario rol;
    private boolean activo;

    public UsuarioMongoEntidad() {
    }

    public UsuarioMongoEntidad(String nombre, String apellidoPaterno, String apellidoMaterno, 
            String email, String nombreUsuario, String passwordHash, RolUsuario rol, boolean activo) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.email = email;
        this.nombreUsuario = nombreUsuario;
        this.passwordHash = passwordHash;
        this.rol = rol;
        this.activo = activo;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getIdComoTexto() {
        return id != null ? id.toHexString() : null;
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

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
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
}