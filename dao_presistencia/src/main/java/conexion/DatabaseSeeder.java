package conexion;

import com.mongodb.client.MongoCollection;
import entidadesmongo.CarritoMongoEntidad;
import entidadesmongo.ProductoMongoEntidad;
import entidadesmongo.UsuarioMongoEntidad;
import enumeradores.*;
import org.bson.types.ObjectId;
import util.TallaUtil;

import entidadesmongo.StockPorTalla;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class DatabaseSeeder {
    private static final Logger LOGGER = Logger.getLogger(DatabaseSeeder.class.getName());

    public static void inicializarProductosSiEstaVacio() {
        try {
            ConexionMongoDB conexion = ConexionMongoDB.getInstance();

            eliminarYCargarDatos(conexion);

        } catch (Exception e) {
            LOGGER.severe("Error al inicializar la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void eliminarYCargarDatos(ConexionMongoDB conexion) {
        MongoCollection<UsuarioMongoEntidad> coleccionUsuarios = conexion.getCollection("usuarios", UsuarioMongoEntidad.class);
        MongoCollection<CarritoMongoEntidad> coleccionCarritos = conexion.getCollection("carritos", CarritoMongoEntidad.class);
        MongoCollection<ProductoMongoEntidad> coleccionProductos = conexion.getCollection("productos", ProductoMongoEntidad.class);

        LOGGER.info("Eliminando datos existentes de la base de datos...");
        coleccionUsuarios.deleteMany(new org.bson.Document());
        coleccionCarritos.deleteMany(new org.bson.Document());
        coleccionProductos.deleteMany(new org.bson.Document());

        LOGGER.info("Cargando datos del seeder...");
        inicializarUsuarios(conexion);
        inicializarCarritos(conexion);
        inicializarProductos(conexion);

        LOGGER.info("Base de datos reiniciada correctamente");
    }

    private static void inicializarUsuarios(ConexionMongoDB conexion) {
        MongoCollection<UsuarioMongoEntidad> coleccion = conexion
                .getCollection("usuarios", UsuarioMongoEntidad.class);

        long documentosExistentes = coleccion.countDocuments();

        if (documentosExistentes == 0) {
            List<UsuarioMongoEntidad> usuarios = new ArrayList<>();

            usuarios.add(new UsuarioMongoEntidad(
                    "David",
                    "Escarcega",
                    "Corral",
                    "david@genius.com",
                    "admin",
                    "1234",
                    RolUsuario.ADMINISTRADOR,
                    true
            ));

            usuarios.add(new UsuarioMongoEntidad(
                    "Juan",
                    "Perez",
                    "Garcia",
                    "juan.perez@email.com",
                    "juan",
                    "1234",
                    RolUsuario.CLIENTE,
                    true
            ));

            coleccion.insertMany(usuarios);
            LOGGER.info("Base de datos inicializada con " + usuarios.size() + " usuarios");
        } else {
            LOGGER.info("Base de datos ya contiene " + documentosExistentes + " usuarios");
        }
    }

    private static void inicializarCarritos(ConexionMongoDB conexion) {
        MongoCollection<CarritoMongoEntidad> coleccion = conexion
                .getCollection("carritos", CarritoMongoEntidad.class);

        long documentosExistentes = coleccion.countDocuments();

        if (documentosExistentes == 0) {
            List<CarritoMongoEntidad> carritos = new ArrayList<>();

            String usuarioId = "000000000000000000000001";
            CarritoMongoEntidad carrito = new CarritoMongoEntidad(usuarioId);
            carrito.setItems(new ArrayList<>());

            carritos.add(carrito);

            coleccion.insertMany(carritos);
            LOGGER.info("Base de datos inicializada con " + carritos.size() + " carritos");
        } else {
            LOGGER.info("Base de datos ya contiene " + documentosExistentes + " carritos");
        }
    }

    private static void inicializarProductos(ConexionMongoDB conexion) {
        MongoCollection<ProductoMongoEntidad> coleccion = conexion
                .getCollection("productos", ProductoMongoEntidad.class);

        long documentosExistentes = coleccion.countDocuments();

        if (documentosExistentes == 0) {
            List<ProductoMongoEntidad> productos = obtenerProductosMock();
            coleccion.insertMany(productos);
            LOGGER.info("Base de datos inicializada con " + productos.size() + " productos");
        } else {
            LOGGER.info("Base de datos ya contiene " + documentosExistentes + " productos");
        }
    }

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
            Integer stockTotal,
            CategoriaProducto categoria,
            EtiquetaGenero genero,
            List<EtiquetaEstilo> estilos) {

        ProductoMongoEntidad producto = new ProductoMongoEntidad();
        producto.setId(new ObjectId(id));
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setPrecio(precio);
        producto.setRutaImagen(rutaImagen);
        producto.setEstado(EstadoProducto.PUBLICADO);
        producto.setCategoria(categoria);
        producto.setTallas(TallaUtil.obtenerTallasPorCategoria(categoria));
        producto.setGenero(genero);
        producto.setEstilos(estilos);

        List<String> tallasDisponibles = TallaUtil.obtenerTallasPorCategoria(categoria);
        List<StockPorTalla> inventario = new ArrayList<>();

        int cantidadPorTalla = tallasDisponibles.isEmpty() ? 0 : stockTotal / tallasDisponibles.size();
        int resto = tallasDisponibles.isEmpty() ? 0 : stockTotal % tallasDisponibles.size();

        for (int i = 0; i < tallasDisponibles.size(); i++) {
            int cantidad = cantidadPorTalla + (i < resto ? 1 : 0);
            inventario.add(new StockPorTalla(tallasDisponibles.get(i), cantidad));
        }

        producto.setInventario(inventario);

        return producto;
    }
}