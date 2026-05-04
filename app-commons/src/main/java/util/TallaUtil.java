package util;

import enumeradores.CategoriaProducto;
import enumeradores.TallaRopaInferior;
import enumeradores.TallaRopaSuperior;
import enumeradores.TallasCalzado;

import java.util.ArrayList;
import java.util.List;

public class TallaUtil {

    public static List<String> obtenerTallasPorCategoria(CategoriaProducto categoria) {
        List<String> tallas = new ArrayList<>();

        switch (categoria) {
            case CALZADO:
                for (TallasCalzado talla : TallasCalzado.values()) {
                    tallas.add(talla.getValor());
                }
                break;
            case CAMISETA:
            case CHAQUETA:
            case SUDADERA:
            case ABRIGO:
            case VESTIDO:
                for (TallaRopaSuperior talla : TallaRopaSuperior.values()) {
                    tallas.add(talla.getValor());
                }
                break;

            case PANTALON:
            case SHORT:
            case FALDA:
                for (TallaRopaInferior talla : TallaRopaInferior.values()) {
                    tallas.add(talla.getValor());
                }
                break;

            case ACCESORIOS:
                tallas.add("ÚNICA");
                break;
        }

        return tallas;
    }

    public static boolean esValidaTalla(String talla, CategoriaProducto categoria) {
        return obtenerTallasPorCategoria(categoria).contains(talla);
    }

}

