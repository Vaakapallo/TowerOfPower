/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import java.awt.Color;
import java.awt.Container;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author 41407
 */
public class GameWindow extends JFrame {

    JPanel p;

    public GameWindow(JPanel p) throws HeadlessException {
        this.p = p;
        this.setTitle("HELLO WINDOW");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        addContent(this.getContentPane());
        this.setVisible(true);
    }

    private void addContent(Container contentPane) {
        contentPane.add(p);
    }

    public void update() {
        this.repaint();
    }
}
