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
import java.util.Random;
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
    private int yMargin;
    private int xMargin;

    public LevelDrawer() {
    }

    public void drawLevel(Level l, Graphics g) {
        drawBackgroundTopHalf(g, l);
        drawGrid(l.getGrid(), g);
        drawCellContents(l.getGrid(), g);
        drawBackgroundBottomHalf(g, l);
        g.drawLine(xMargin, 0, xMargin, 12309);
        g.drawLine(0, yMargin, 143241, yMargin);
    }

    /**
     * Draws parameter grid
     *
     * @param grid
     * @param g Graphics
     */
    void drawGrid(Grid grid, Graphics g) {
        String path = defaultPath + "grid/54/";
        ArrayList<Cell> orderedCells = grid.getCells();

        for (Cell c : orderedCells) {
            if (c.isVisible()) {
                drawCell(g, c, path);
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
    private void drawCell(Graphics g, Cell c, String path) {
        drawCellTile(g, c, path);
    }

    /**
     * Draws the base tile of given cell.
     *
     * @param g graphics
     * @param c cell
     * @param path path to the folder of the image
     */
    private void drawCellTile(Graphics g, Cell c, String path) {
        /**
         * Destination coordinates A.K.A. where the image will be drawn
         *
         * (dstx1, dsty1) : upper left corner (dstx2, dsty2) : lower right
         * corner width, height : self-explanatory
         */
        Random random = new Random();

        Image i = getImage(path + "0" + random.nextInt(4));
        drawImage(g, i, c.getX(), c.getY() - c.getHeight() - random.nextInt(3) + 2,
                i.getWidth(null), i.getHeight(null));
    }

    /**
     * Handles drawing of cell's contents
     *
     * @param g graphics
     * @param c cell in question
     */
    private void drawCellContents(Grid grid, Graphics g) {

        ArrayList<Cell> orderedCells = grid.getCells();

        for (Cell c : orderedCells) {
            if (c.getContent() != null) {
                String path = defaultPath + c.getContent().getPath();
                Image i = getImage(path);
                drawImage(g, i,
                        c.getX(),
                        c.getY() + c.getHeight() - i.getHeight(null),
                        i.getWidth(null), i.getHeight(null));
            }
        }

    }

    private void drawBackgroundBottomHalf(Graphics g, Level l) {
        String path = defaultPath + "background/";
        path += l.getBackgroundImage() + "bottom";
        Image i = getImage(path);
        drawImage(g, i, 0, 0, i.getWidth(null), i.getWidth(null));
    }

    private void drawBackgroundTopHalf(Graphics g, Level l) {
        String path = defaultPath + "background/";
        path += l.getBackgroundImage() + "top";
        Image i = getImage(path);
        drawImage(g, i, 0, 0, i.getWidth(null), i.getWidth(null));
    }

    private void drawImage(Graphics g, Image i,
            int x, int y,
            int width, int height) {
        int dstx1 = x;
        int dsty1 = y;

        int dstx2 = dstx1 + width;
        int dsty2 = dsty1 + height;

        g.drawImage(i,
                dstx1, dsty1,
                dstx2, dsty2,
                0, 0,
                width, height, null);
    }
}
