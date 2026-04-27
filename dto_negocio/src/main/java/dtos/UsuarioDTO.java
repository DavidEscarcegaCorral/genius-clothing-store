/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import enumeradores.RolUsuario;

/**
 *
 * @author Usuario
 */
public class UsuarioDTO {
    
    private Integer idUsuarioDTO;
    private String nombreUsuario;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correo;
    private String contraseña;
    private RolUsuario rol;

    public UsuarioDTO(Integer idUsuarioDTO, String nombreUsuario, String nombre, String apellidoPaterno, String apellidoMaterno, String correo, String contraseña, RolUsuario rol) {
        this.idUsuarioDTO = idUsuarioDTO;
        this.nombreUsuario = nombreUsuario;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.contraseña = contraseña;
        this.rol = rol;
    } 
    
    public UsuarioDTO(String nombreUsuario, String nombre, String apellidoPaterno, String apellidoMaterno, String correo, String contraseña, RolUsuario rol) {
        this.nombreUsuario = nombreUsuario;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.contraseña = contraseña;
        this.rol = rol;
    }

    public UsuarioDTO(String nombreUsuario, String nombre, String apellidoPaterno, String apellidoMaterno, String correo, String contraseña) {
        this.nombreUsuario = nombreUsuario;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    public UsuarioDTO() {
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

    public RolUsuario getRol() {
        return rol;
    }

    public void setRol(RolUsuario rol) {
        this.rol = rol;
    }

    public Integer getIdUsuarioDTO() {
        return idUsuarioDTO;
    }

    public void setIdUsuarioDTO(Integer idUsuario) {
        this.idUsuarioDTO = idUsuario;
    }
    
    
    
}
