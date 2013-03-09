/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics.draw.level;

import graphics.ImageLoader;
import graphics.grid.Grid;
import graphics.grid.GridCell;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import logic.level.Level;

/**
 *
 * @author 41407
 */
public class LevelDrawer {

    String defaultPath = "resources/level/";
    
    public void drawLevel(Level level, Graphics g) {
    }

    void drawGrid(Grid grid, Graphics graphics) {
        String path = defaultPath+"grid/50x25/";
        ArrayList<GridCell> orderedCells = grid.getCells();
        int dstx1, dsty1, dstx2, dsty2;
        for (GridCell c : orderedCells) {
            dstx1 = c.getX();
            dsty1 = c.getY();
            dstx2 = dstx1 + 50;
            dsty2 = dsty1 + 25;
            graphics.drawImage(getImage(path+"00"), dstx1, dsty1, dstx2,
                    dsty2, 0, 0, 50, 25, null);

        }
    }

    private Image getImage(String path) {
        ImageLoader l = new ImageLoader(path+".png");
        return l.getImage();
    }
}
