/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics.draw.level;

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

    public void drawLevel(Level level, Graphics g) {
    }

    void drawGrid(Grid grid, Graphics graphics) {
        ArrayList<GridCell> orderedCells = grid.getCells();
        int dstx1, dsty1, dstx2, dsty2;
        for (GridCell c : orderedCells) {
            dstx1 = c.getX();
            dsty1 = c.getY();
            dstx2 = dstx1 + 50;
            dsty2 = dsty1 + 25;
            Image img = getImage();
            graphics.drawImage(img, dstx1, dsty1, dstx2, dsty2, 0, 0, 50, 25, null);

        }
    }

    private Image getImage() {
        try {
            BufferedImage img = null;
            img = ImageIO.read(new File("src/assets/level/gridcell_50x25_transparency.png"));
            return img;
        } catch (IOException e) {
            System.out.println("fack");
            return null;
        }

    }
}
