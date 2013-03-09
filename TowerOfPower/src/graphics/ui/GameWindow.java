/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics.ui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author 41407
 */
public class GameWindow implements Runnable {

    private JPanel mainPanel;
    private JFrame frame;

    public GameWindow(JPanel panel) {
        this.mainPanel = panel;
    }
    
    @Override
    public void run() {
        frame = new JFrame("HELLO WINDOW");
        frame.setPreferredSize(new Dimension(1024, 768));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        addComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void addComponents(Container contentPane) {
        frame.add(mainPanel);
        mainPanel.setBounds(0, 0, 1024, 768);
    }

    public JFrame getFrame() {
        return frame;
    }
}
