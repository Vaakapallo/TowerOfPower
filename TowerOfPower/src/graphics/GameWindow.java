/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Opens a new game window with specified JPanel.
 * 
 * @author 41407
 */
public class GameWindow extends JFrame {

    JPanel p;

    public GameWindow(JPanel p){
        this.p = p;
        this.setTitle("HELLO WINDOW");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1024, 768);
        this.setBackground(Color.black);
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