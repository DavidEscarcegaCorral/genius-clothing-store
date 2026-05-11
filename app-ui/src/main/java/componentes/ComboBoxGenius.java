package componentes;

import util.Estilo;
import util.FontLoader;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;

public class ComboBoxGenius<E> extends JComboBox<E> {
    public ComboBoxGenius(E[] items) {
        super(items);
        configureEditor();
    }

    public ComboBoxGenius() {
        configureEditor();
    }

    public void configureEditor() {
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);
        setFont(FontLoader.cargarFont(Estilo.FONT_PROGRAMME_NORMAL, 20));
        setFocusable(false);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton button = new JButton();
                button.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10)); // Margen derecho
                button.setContentAreaFilled(false);
                button.setFocusPainted(false);
                button.setOpaque(true);
                button.setBackground(Color.WHITE);
                button.setCursor(new Cursor(Cursor.HAND_CURSOR));

                button.setIcon(new Icon() {
                    private final int width = 14;
                    private final int height = 8;

                    @Override
                    public void paintIcon(Component c, Graphics g, int x, int y) {
                        Graphics2D g2 = (Graphics2D) g.create();
                        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                        g2.setColor(Color.BLACK);

                        int[] xPoints = {x, x + width, x + (width / 2)};
                        int[] yPoints = {y + 2, y + 2, y + height + 2};

                        g2.fillPolygon(xPoints, yPoints, 3);
                        g2.dispose();
                    }

                    @Override
                    public int getIconWidth() {
                        return width;
                    }

                    @Override
                    public int getIconHeight() {
                        return height;
                    }
                });

                return button;
            }
        });

        setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

                if (isSelected) {
                    setBackground(Estilo.AMARILLO_GENIUS);
                } else {
                    setBackground(Color.WHITE);
                }
                setForeground(Color.BLACK);
                return this;
            }
        });
    }
    //Para usarlo para las imagemnes
    public ComboBoxGenius(E[] items) {
        super(items);
    }
    
    
}
