/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics.draw.level;

import java.awt.Graphics;
import javax.swing.JPanel;
import logic.level.Level;

/**
 *
 * @author 41407
 */
public class CombatPanel extends JPanel {

    private CombatScreenDrawer d;
    private Level l;

    public CombatPanel(Level level) {
        this.d = new CombatScreenDrawer(level);
        this.l = level;
    }

    public void setL(Level l) {
        this.l = l;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        d.drawLevel(l, g);
    }
}