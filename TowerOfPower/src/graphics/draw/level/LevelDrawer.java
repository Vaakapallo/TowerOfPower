/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics.draw.level;

import graphics.grid.Grid;
import graphics.grid.GridCell;
import java.awt.Graphics;
import java.util.ArrayList;
import logic.level.Level;

/**
 *
 * @author 41407
 */
public class LevelDrawer {
    
    
    
    public void drawLevel(Level level, Graphics g) {
        
    }

    void drawGrid(Grid grid, Graphics graphics) {
        ArrayList<GridCell> orderedCells = grid.getCells();
        int x1, y1, x2, y2;
        for (GridCell c : orderedCells) {
            x1 = c.getX();
            y1 = c.getY();
            graphics.fillRect(x1, y1, 10, 10);
        }
    }
}
