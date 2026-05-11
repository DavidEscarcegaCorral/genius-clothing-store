package conexion;

import com.mongodb.client.MongoCollection;
import entidadesmongo.ProductoMongoEntidad;
import enumeradores.CategoriaProducto;
import enumeradores.EstadoProducto;
import enumeradores.EtiquetaEstilo;
import enumeradores.EtiquetaGenero;
import org.bson.types.ObjectId;
import util.TallaUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class DatabaseSeeder {
    private static final Logger LOGGER = Logger.getLogger(DatabaseSeeder.class.getName());

    /**
     * Inicializa la base de datos con productos si está vacía
     */
    public static void inicializarProductosSiEstaVacio() {
        try {
            ConexionMongoDB conexion = ConexionMongoDB.getInstance();
            MongoCollection<ProductoMongoEntidad> coleccion = conexion
                    .getCollection("productos", ProductoMongoEntidad.class);

            long documentosExistentes = coleccion.countDocuments();

            if (documentosExistentes == 0) {
                List<ProductoMongoEntidad> productos = obtenerProductosMock();
                coleccion.insertMany(productos);
                LOGGER.info("✓ Base de datos inicializada con " + productos.size() + " productos");
            } else {
                LOGGER.info("✓ Base de datos ya contiene " + documentosExistentes + " productos");
            }
        } catch (Exception e) {
            LOGGER.severe("✗ Error al inicializar la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Obtiene una lista de productos para seeding
     */
    private static List<ProductoMongoEntidad> obtenerProductosMock() {
        List<ProductoMongoEntidad> productos = new ArrayList<>();

        productos.add(crearProducto(
                "507f1f77bcf86cd799439011",
                "Tenis SL72 OG",
                "Lanzados por primera vez en 1972, los tenis adidas SL72 OG tienen una estructura liviana que revolucionó el running. Hoy en día, el exterior de nylon transpirable, los revestimientos de gamuza y los detalles en piel le imprimen un estilo de inspiración retro a tu vida activa.",
                new BigDecimal("2990"),
                "/img/TenisSL72OG.png",
                15,
                CategoriaProducto.CALZADO,
                EtiquetaGenero.MUJER,
                Arrays.asList(EtiquetaEstilo.URBANO, EtiquetaEstilo.DEPORTE)
        ));

        productos.add(crearProducto(
                "507f1f77bcf86cd799439012",
                "Playera polo nike sportswear",
                "Renueva tu estilo con la Playera Polo Nike Sportswear que redefine el look deportivo con un acabado más sofisticado. El diseño convierte los logos Swoosh en un patrón de encaje que eleva el outfit sin perder la vibra urbana.",
                new BigDecimal("1899"),
                "/img/PlayeraPoloNikeSportswear.jpg",
                25,
                CategoriaProducto.CAMISETA,
                EtiquetaGenero.MUJER,
                Arrays.asList(EtiquetaEstilo.URBANO, EtiquetaEstilo.CASUAL)
        ));

        productos.add(crearProducto(
                "507f1f77bcf86cd799439013",
                "Jorts Firebird Utility",
                "Los jorts Firebird Utility son un giro moderno a un estilo icónico de adidas. Inspirados en la cultura urbana, estos jorts tienen una forma holgada para un look relajado.",
                new BigDecimal("1263"),
                "/img/JortsFirebirdUtility.jpg",
                30,
                CategoriaProducto.SHORT,
                EtiquetaGenero.MUJER,
                Arrays.asList(EtiquetaEstilo.DEPORTIVO, EtiquetaEstilo.CASUAL)
        ));

        return productos;
    }

    private static ProductoMongoEntidad crearProducto(
            String id,
            String nombre,
            String descripcion,
            BigDecimal precio,
            String rutaImagen,
            Integer stock,
            CategoriaProducto categoria,
            EtiquetaGenero genero,
            List<EtiquetaEstilo> estilos) {

        ProductoMongoEntidad producto = new ProductoMongoEntidad();
        producto.setId(new ObjectId(id));
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setPrecio(precio);
        producto.setRutaImagen(rutaImagen);
        producto.setStock(stock);
        producto.setEstado(EstadoProducto.PUBLICADO);
        producto.setCategoria(categoria);
        producto.setTallas(TallaUtil.obtenerTallasPorCategoria(categoria));
        producto.setGenero(genero);
        producto.setEstilos(estilos);

        return producto;
    }
}