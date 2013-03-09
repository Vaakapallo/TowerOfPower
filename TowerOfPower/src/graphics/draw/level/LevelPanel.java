/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics.draw.level;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import logic.level.Level;

/**
 *
 * @author 41407
 */
public class LevelPanel extends JPanel {

    private LevelDrawer d;
    private Level l;

    public LevelPanel(Level level) {
        this.d = new LevelDrawer();
        this.l = level;
    }

    public void setL(Level l) {
        this.l = l;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(0,0,0));
        d.drawGrid(l.getGrid(), g);
    }
}
