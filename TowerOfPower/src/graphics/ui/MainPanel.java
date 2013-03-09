/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics.ui;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author 41407
 */
public class MainPanel extends JPanel {

    JPanel component;

    public MainPanel() {
    }

    public void addComponent(JPanel component) {
        this.component = component;
        component.setPreferredSize(new Dimension(1024,768));
        this.add(component);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
