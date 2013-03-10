/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics.ui;

import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author 41407
 */
public class GameWindow extends JFrame {

    private JPanel mainPanel;

    public GameWindow(JPanel panel) {
        this.mainPanel = panel;
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addComponents(this.getContentPane());
        this.pack();
        this.setVisible(true);
    }

    private void addComponents(Container contentPane) {
        this.add(mainPanel);
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }
}
