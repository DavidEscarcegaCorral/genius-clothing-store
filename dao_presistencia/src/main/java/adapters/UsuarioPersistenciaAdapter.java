package adapters;

import dominio.UsuarioEntidad;
import entidadesmongo.UsuarioMongoEntidad;
import org.bson.types.ObjectId;

public class UsuarioPersistenciaAdapter {

    public UsuarioMongoEntidad convertirAMongo(UsuarioEntidad usuario) {
        if (usuario == null) {
            return null;
        }

        UsuarioMongoEntidad mongo = new UsuarioMongoEntidad();
        mongo.setId(convertirStringAObjectId(usuario.getId()));
        mongo.setNombre(usuario.getNombre());
        mongo.setApellidoPaterno(usuario.getApellidoPaterno());
        mongo.setApellidoMaterno(usuario.getApellidoMaterno());
        mongo.setEmail(usuario.getEmail());
        mongo.setNombreUsuario(usuario.getNombreUsuario());
        mongo.setPasswordHash(usuario.getPasswordHash());
        mongo.setRol(usuario.getRol());
        mongo.setActivo(usuario.isActivo());

        return mongo;
    }

    public UsuarioEntidad convertirADominio(UsuarioMongoEntidad mongo) {
        if (mongo == null) {
            return null;
        }

        UsuarioEntidad usuario = new UsuarioEntidad();
        usuario.setId(convertirObjectIdAString(mongo.getId()));
        usuario.setNombre(mongo.getNombre());
        usuario.setApellidoPaterno(mongo.getApellidoPaterno());
        usuario.setApellidoMaterno(mongo.getApellidoMaterno());
        usuario.setEmail(mongo.getEmail());
        usuario.setNombreUsuario(mongo.getNombreUsuario());
        usuario.setPasswordHash(mongo.getPasswordHash());
        usuario.setRol(mongo.getRol());
        usuario.setActivo(mongo.isActivo());

        return usuario;
    }

    public ObjectId convertirStringAObjectId(String id) {
        if (id == null || id.isBlank()) {
            return null;
        }
        return new ObjectId(id);
    }

    public String convertirObjectIdAString(ObjectId id) {
        if (id == null) {
            return null;
        }
        return id.toHexString();
    }
}