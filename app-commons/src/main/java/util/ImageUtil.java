package util;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImageUtil {
    /**
     * Carga una imagen desde resources y la escala al tamaño deseado.
     */
    public static ImageIcon cargarImagen(String ruta, int ancho, int alto) {
        try {
            URL url = ImageUtil.class.getResource(ruta);

            if (url == null) {
                System.out.println("No se encontro la imagen en: " + ruta);
                return null;
            }

            ImageIcon iconoOriginal = new ImageIcon(url);
            Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);

            return new ImageIcon(imagenEscalada);
        } catch (Exception e) {
            System.err.println("Error cargando imagen: " + e.getMessage());
            return null;
        }
    }
}
