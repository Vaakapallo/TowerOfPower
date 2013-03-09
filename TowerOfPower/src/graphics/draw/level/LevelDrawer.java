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
 * Draws the level on its parent JPanel
 * 
 * @author 41407
 */
public class LevelDrawer {

    /**
     * The default path from where to look for image files
     */
    String defaultPath = "resources/level/";

    public void drawLevel(Level level, Graphics g) {
    }

    /**
     * Draws parameter grid
     * 
     * @param grid
     * @param g Graphics
     */
    void drawGrid(Grid grid, Graphics g) {
        String path = defaultPath + "grid/50x25/";
        ArrayList<GridCell> orderedCells = grid.getCells();

        for (GridCell c : orderedCells) {
            drawCell(g, c, path);
        }
    }

    /**
     * Calls ImageLoader to load source image
     * @param path
     * @return Image to be drawn
     */
    private Image getImage(String path) {
        ImageLoader l = new ImageLoader(path + ".png");
        return l.getImage();
    }

    /**
     * Handles cell drawing.
     * 
     * For now, only works for 50px cells.
     * 
     * @param g Graphics
     * @param c GridCell
     * @param path Path to the target file.
     */
    private void drawCell(Graphics g, GridCell c, String path) {
        int dstx1, dsty1, dstx2, dsty2;
        dstx1 = c.getX();
        dsty1 = c.getY();
        dstx2 = dstx1 + 50;
        dsty2 = dsty1 + 25;
        g.drawImage(getImage(path + "00"), dstx1, dsty1, dstx2,
                dsty2, 0, 0, 50, 25, null);
    }
}
