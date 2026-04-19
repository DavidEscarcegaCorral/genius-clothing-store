package frames;

import javax.swing.*;
import java.awt.*;

public class GlobalFrame extends JFrame {
    public GlobalFrame() {
        setTitle("Global Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(300, 200));
        pack();
        setLocationRelativeTo(null);
    }
}
