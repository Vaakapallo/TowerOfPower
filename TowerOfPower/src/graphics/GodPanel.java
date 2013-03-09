/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import graphics.draw.level.LevelPanel;
import graphics.draw.level.UIPanel;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author 41407
 */
public class GodPanel extends JPanel {

    private LevelPanel l;
    private UIPanel u;

    public GodPanel(LevelPanel l, UIPanel u) {
        this.l = l;
        this.u = u;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        l.update(g);
    }

    public void update() {
        this.repaint();
    }
}
