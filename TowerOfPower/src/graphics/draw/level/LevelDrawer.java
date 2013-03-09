/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics.draw.level;

import graphics.ImageLoader;
import graphics.grid.Grid;
import graphics.grid.Cell;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import logic.level.Level;

/**
 * Draws the level on its parent JPanel
 *
 * @author 41407
 */
public class LevelDrawer {

    /**
     * The default path from where to look for image files. In this case, it
     * will be assigned to the root folder of level graphics.
     */
    String defaultPath = "resources/level/";

    public void drawLevel(Level l, Graphics g) {
        
        int yMargin = 108;
        int xMargin = 42;
//        drawBackgroundTopHalf(g);
        drawGrid(l.getGrid(), g, xMargin, yMargin);
        //       drawBackgroundBottomHalf(g);
    }

    /**
     * Draws parameter grid
     *
     * @param grid
     * @param g Graphics
     */
    void drawGrid(Grid grid, Graphics g, int xMargin, int yMargin) {
        String path = defaultPath + "grid/50x25/";
        ArrayList<Cell> orderedCells = grid.getCells();

        for (Cell c : orderedCells) {
            if (c.isVisible()) {
                drawCell(g, c, xMargin, yMargin, path);
            }
        }
    }

    /**
     * Calls ImageLoader to load source image
     *
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
     * @param c Cell
     * @param path Path to the target file.
     */
    private void drawCell(Graphics g, Cell c, int xMargin, int yMargin, String path) {
        drawCellTile(g, c, xMargin, yMargin, path);

//        drawCellContents(g, c);
    }

    /**
     * Draws the base tile of given cell.
     *
     * @param g graphics
     * @param c cell
     * @param path path to the folder of the image
     */
    private void drawCellTile(Graphics g, Cell c, int xMargin, int yMargin,
            String path) {
        /**
         * Destination coordinates A.K.A. where the image will be drawn
         *
         * (dstx1, dsty1) : upper left corner (dstx2, dsty2) : lower right
         * corner width, height : self-explanatory
         */
        int dstx1 = c.getX() + xMargin;
        int dsty1 = c.getY() + yMargin;
        
        Image i = getImage(path+"00");
        
        int width = i.getWidth(null);
        int height = i.getHeight(null);
        
        int dstx2 = dstx1 + width;
        int dsty2 = dsty1 + height;
        
        g.drawImage(i,
                dstx1, dsty1,
                dstx2, dsty2,
                0, 0,
                width, height, null);
    }

    /**
     * Handles drawing of cell's contents
     *
     * @param g graphics
     * @param c cell in question
     */
    private void drawCellContents(Graphics g, Cell c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void drawBackgroundBottomHalf(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void drawBackgroundTopHalf(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
