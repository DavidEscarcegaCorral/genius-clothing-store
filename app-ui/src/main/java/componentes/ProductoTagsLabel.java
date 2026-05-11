package componentes;

import enumeradores.EtiquetaEstilo;
import enumeradores.EtiquetaGenero;
import util.Estilo;
import util.FontLoader;

import javax.swing.*;
import java.util.List;

public class ProductoTagsLabel extends JLabel {

    public ProductoTagsLabel(EtiquetaGenero genero, List<EtiquetaEstilo> estilos) {
        setText(generarTexto(genero, estilos));
        setFont(FontLoader.cargarFont(Estilo.FONT_PROGRAMME_NORMAL, 20));
        setForeground(java.awt.Color.BLACK);
    }

    private String generarTexto(EtiquetaGenero genero, List<EtiquetaEstilo> estilos) {
        StringBuilder sb = new StringBuilder();

        if (genero != null) {
            sb.append(genero.getValor());
        }

        if (estilos != null && !estilos.isEmpty()) {
            for (EtiquetaEstilo estilo : estilos) {
                sb.append(" - ").append(estilo.getValor());
            }
        }

        return sb.toString();
    }

    public void actualizarTags(EtiquetaGenero genero, List<EtiquetaEstilo> estilos) {
        setText(generarTexto(genero, estilos));
    }
}