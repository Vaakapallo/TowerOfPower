/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics.draw.level;

import graphics.grid.Cell;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import logic.level.Level;

/**
 * Draws the level on its parent JPanel
 *
 * @author 41407
 */
public class LevelDrawer {

    private HashMap<String, Image> images;

    public LevelDrawer() {
    }

    public void drawLevel(Level l, Graphics g) {
        drawBackgroundBottomLayers(g, l);
        drawGrid(g, l);
        drawCellContents(g, l);
        drawBackgroundTopLayers(g, l);
        this.images = l.getLevelImages();
    }

    /**
     * Draws parameter grid
     *
     * @param grid
     * @param g Graphics
     */
    void drawGrid(Graphics g, Level l) {
        ArrayList<Cell> orderedCells = l.getGrid().getCells();

        for (Cell c : orderedCells) {
            if (c.isVisible()) {
                drawCell(g, l, c);
            }
        }
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
    private void drawCell(Graphics g, Level l, Cell c) {
        drawCellTile(g, l, c);
    }

    /**
     * Draws the base tile of given cell.
     *
     * @param g graphics
     * @param c cell
     * @param path path to the folder of the image
     */
    private void drawCellTile(Graphics g, Level l, Cell c) {
        /**
         * Destination coordinates A.K.A. where the image will be drawn
         *
         * (dstx1, dsty1) : upper left corner (dstx2, dsty2) : lower right
         * corner width, height : self-explanatory
         */
        drawImage(g, "tile0", c.getX(), c.getY() - c.getHeight());
    }

    /**
     * Handles drawing of cell's contents
     *
     * @param g graphics
     * @param c cell in question
     */
    private void drawCellContents(Graphics g, Level l) {
        /**
         * TO DO : )
         *
         * ArrayList<Cell> orderedCells = grid.getCells();
         *
         * for (Cell c : orderedCells) { if (c.getContent() != null) {
         * drawImage(g, i, c.getX(), c.getY() + c.getHeight() -
         * i.getHeight(null), i.getWidth(null), i.getHeight(null)); } }
         */
    }

    private void drawBackgroundTopLayers(Graphics g, Level l) {
        drawImage(g, "bg2", 0, 0);
        drawImage(g, "bg3", 0, 0);
    }

    private void drawBackgroundBottomLayers(Graphics g, Level l) {
        drawImage(g, "bg0", 0, 0);
        drawImage(g, "bg1", 0, 0);
    }

    private void drawImage(Graphics g, String image,
            int x, int y) {

        Image i = images.get(image);
        
        int width = i.getWidth(null);
        int height = i.getHeight(null);

        int dstx1 = x;
        int dsty1 = y;

        int dstx2 = dstx1;
        int dsty2 = dsty1;

        g.drawImage(i,
                dstx1, dsty1,
                dstx2, dsty2,
                0, 0,
                width, height, null);
    }
}
