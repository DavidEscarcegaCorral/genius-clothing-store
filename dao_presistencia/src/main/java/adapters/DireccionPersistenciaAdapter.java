package adapters;

import dominio.DIreccionEntidad;
import entidadesmongo.DireccionMongoEntidad;
import excepciones.PersistenciaException;
import org.bson.types.ObjectId;

/**
 * Adapter para convertir entre entidades de dominio y MongoDB para direcciones
 */
public class DireccionPersistenciaAdapter {

    /**
     * Convierte una dirección del dominio a entidad MongoDB
     */
    public DireccionMongoEntidad convertirAMongo(DIreccionEntidad direccion) throws PersistenciaException {
        if (direccion == null) {
            return null;
        }

        DireccionMongoEntidad mongoEntidad = new DireccionMongoEntidad();

        // Convertir ID String a ObjectId
        mongoEntidad.setId(convertirStringAObjectId(direccion.getId()));

        mongoEntidad.setCalle(direccion.getCalle());
        mongoEntidad.setNumeroExterior(direccion.getNumeroExterior());
        mongoEntidad.setNumeroInterior(direccion.getNumeroInterior());
        mongoEntidad.setColonia(direccion.getColonia());
        mongoEntidad.setCiudad(direccion.getCiudad());
        mongoEntidad.setEstado(direccion.getEstado());
        mongoEntidad.setCodigoPostal(direccion.getCodigoPostal());
        mongoEntidad.setPais(direccion.getPais());
        mongoEntidad.setReferencias(direccion.getReferencias());

        return mongoEntidad;
    }

    /**
     * Convierte una entidad MongoDB a dirección del dominio
     */
    public DIreccionEntidad convertirADominio(DireccionMongoEntidad mongoEntidad) {
        if (mongoEntidad == null) {
            return null;
        }

        DIreccionEntidad direccion = new DIreccionEntidad();

        // Convertir ObjectId a String
        direccion.setId(convertirObjectIdAString(mongoEntidad.getId()));

        // Copiar campos directos
        direccion.setCalle(mongoEntidad.getCalle());
        direccion.setNumeroExterior(mongoEntidad.getNumeroExterior());
        direccion.setNumeroInterior(mongoEntidad.getNumeroInterior());
        direccion.setColonia(mongoEntidad.getColonia());
        direccion.setCiudad(mongoEntidad.getCiudad());
        direccion.setEstado(mongoEntidad.getEstado());
        direccion.setCodigoPostal(mongoEntidad.getCodigoPostal());
        direccion.setPais(mongoEntidad.getPais());
        direccion.setReferencias(mongoEntidad.getReferencias());

        return direccion;
    }

    /**
     * Convierte String a ObjectId
     */
    public ObjectId convertirStringAObjectId(String id) throws PersistenciaException {
        if (id == null || id.isBlank()) {
            return null;
        }

        if (!ObjectId.isValid(id)) {
            throw new PersistenciaException(
                    "El id de dirección recibido no tiene formato válido de ObjectId: " + id
            );
        }

        return new ObjectId(id);
    }

    /**
     * Convierte ObjectId a String
     */
    public String convertirObjectIdAString(ObjectId id) {
        return id != null ? id.toHexString() : null;
    }
}
