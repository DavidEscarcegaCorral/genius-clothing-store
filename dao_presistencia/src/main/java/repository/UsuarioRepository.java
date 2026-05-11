package repository;

import dominio.UsuarioEntidad;
import enumeradores.RolUsuario;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UsuarioRepository {
    private List<UsuarioEntidad> usuariosMock;

    public UsuarioRepository() {
        inicialiarUsuariosMock();
    }

    public boolean existeUsuario(String usuario, String contraseña) {
        return usuariosMock.stream()
                .anyMatch(u -> u.getNombreUsuario().equals(usuario)
                        && u.getPasswordHash().equals(contraseña)
                        && u.isActivo());
    }

    public void inicialiarUsuariosMock() {
        usuariosMock = new ArrayList<>();

        // Usuario 1
        usuariosMock.add(new UsuarioEntidad(
                UUID.randomUUID().toString(),
                "Juan",
                "Perez",
                "Garcia",
                "juan.perez@gmail.com",
                "Usuario1",
                "1234",
                RolUsuario.CLIENTE,
                true,
                0,
                LocalDateTime.now(),
                new ArrayList<>()
        ));

        usuariosMock.add(new UsuarioEntidad(
                UUID.randomUUID().toString(),
                "David",
                "Escarcega",
                "Corral",
                "ana.lopez@admin.com",
                "admin",
                "1234",
                RolUsuario.ADMINISTRADOR,
                true,
                0,
                LocalDateTime.now(),
                new ArrayList<>()
        ));
    }

    public List<UsuarioEntidad> getUsuariosMock() {
        return usuariosMock;
    }
}
