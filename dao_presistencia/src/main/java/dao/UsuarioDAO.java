package dao;

import adapters.UsuarioPersistenciaAdapter;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import conexion.ConexionMongoDB;
import dominio.UsuarioEntidad;
import entidadesmongo.UsuarioMongoEntidad;
import excepciones.PersistenciaException;
import org.bson.types.ObjectId;

import static com.mongodb.client.model.Filters.eq;

public class UsuarioDAO implements IUsuarioDAO {

    private final MongoCollection<UsuarioMongoEntidad> coleccionUsuarios;
    private final UsuarioPersistenciaAdapter usuarioAdapter;

    public UsuarioDAO() {
        this.coleccionUsuarios = ConexionMongoDB.getInstance()
                .getCollection("usuarios", UsuarioMongoEntidad.class);
        this.usuarioAdapter = new UsuarioPersistenciaAdapter();
    }

    @Override
    public UsuarioEntidad buscarPorUsuario(String nombreUsuario) throws PersistenciaException {
        if (nombreUsuario == null || nombreUsuario.isBlank()) {
            throw new PersistenciaException("El nombre de usuario no puede ser nulo o vacío");
        }

        try {
            UsuarioMongoEntidad mongoUsuario = coleccionUsuarios
                    .find(eq("nombreUsuario", nombreUsuario))
                    .first();

            return usuarioAdapter.convertirADominio(mongoUsuario);
        } catch (MongoException e) {
            throw new PersistenciaException("Error al buscar usuario por nombre", e);
        }
    }

    @Override
    public UsuarioEntidad buscarPorId(String id) throws PersistenciaException {
        if (id == null || id.isBlank()) {
            throw new PersistenciaException("El ID no puede ser nulo o vacío");
        }

        try {
            ObjectId objectId = usuarioAdapter.convertirStringAObjectId(id);
            UsuarioMongoEntidad mongoUsuario = coleccionUsuarios
                    .find(eq("_id", objectId))
                    .first();

            return usuarioAdapter.convertirADominio(mongoUsuario);
        } catch (MongoException e) {
            throw new PersistenciaException("Error al buscar usuario por ID", e);
        }
    }

    @Override
    public UsuarioEntidad guardar(UsuarioEntidad usuario) throws PersistenciaException {
        if (usuario == null) {
            throw new PersistenciaException("El usuario no puede ser nulo");
        }

        try {
            UsuarioMongoEntidad mongoUsuario = usuarioAdapter.convertirAMongo(usuario);
            
            if (mongoUsuario.getId() == null) {
                coleccionUsuarios.insertOne(mongoUsuario);
            } else {
                coleccionUsuarios.replaceOne(eq("_id", mongoUsuario.getId()), mongoUsuario);
            }

            return usuarioAdapter.convertirADominio(mongoUsuario);
        } catch (MongoException e) {
            throw new PersistenciaException("Error al guardar usuario", e);
        }
    }

    @Override
    public boolean existeUsuario(String nombreUsuario, String password) throws PersistenciaException {
        if (nombreUsuario == null || nombreUsuario.isBlank()) {
            throw new PersistenciaException("El nombre de usuario no puede ser nulo o vacío");
        }

        try {
            UsuarioMongoEntidad mongoUsuario = coleccionUsuarios
                    .find(eq("nombreUsuario", nombreUsuario))
                    .first();

            if (mongoUsuario == null) {
                return false;
            }

            return mongoUsuario.getPasswordHash().equals(password) && mongoUsuario.isActivo();
        } catch (MongoException e) {
            throw new PersistenciaException("Error al verificar usuario", e);
        }
    }
}