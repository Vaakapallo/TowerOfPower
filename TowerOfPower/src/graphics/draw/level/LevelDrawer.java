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

    public LevelDrawer(Level l) {
        this.images = l.getLevelImages();
    }

    public void drawLevel(Level l, Graphics g) {
        drawBackgroundBottomLayers(g);
        drawGrid(g, l);
        drawCellContents(g, l);
        drawBackgroundTopLayers(g);
    }

    /**
     * Draws parameter grid
     *
     * @param grid
     * @param g Graphics
     */
    void drawGrid(Graphics g, Level l) {
        ArrayList<Cell> orderedCells = l.getGrid().getCells();
        int amountOfTileVariants = 0;
        while (images.containsKey("tile" + amountOfTileVariants)) {
            amountOfTileVariants++;
        }

        for (Cell c : orderedCells) {
            if (c.isVisible()) {
                drawCell(g, c, amountOfTileVariants);
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
    private void drawCell(Graphics g, Cell c, int amountOfTileVariants) {
        drawCellTile(g, c, amountOfTileVariants);
    }

    /**
     * Draws the base tile of given cell.
     *
     * @param g graphics
     * @param c cell
     * @param path path to the folder of the image
     */
    private void drawCellTile(Graphics g, Cell c, int amountOfTileVariants) {
        /**
         * Destination coordinates A.K.A. where the image will be drawn
         *
         * (dstx1, dsty1) : upper left corner (dstx2, dsty2) : lower right
         * corner width, height : self-explanatory
         */
        String tileToUse = "tile" + c.getTileVariant() % amountOfTileVariants;

        drawImage(g, tileToUse, c.getX(), c.getY()+c.getTileVariant()%4);
    }

    /**
     * Handles drawing of cell's contents
     *
     * @param g graphics
     * @param c cell in question
     */
    private void drawCellContents(Graphics g, Level l) {


        ArrayList<Cell> orderedCells = l.getGrid().getCells();

        for (Cell c : orderedCells) {
            if (c.getContent() != null) {
                
            }
        }

    }

    private void drawBackgroundTopLayers(Graphics g) {
        drawImage(g, "bg2", 0, 0);
        drawImage(g, "bg3", 0, 0);
    }

    private void drawBackgroundBottomLayers(Graphics g) {
        drawImage(g, "bg0", 0, 0);
        drawImage(g, "bg1", 0, 0);
    }

    private void drawImage(Graphics g, String image,
            int x, int y) {
        if (images.containsKey(image)) {
            Image i = images.get(image);

            int width = i.getWidth(null);
            int height = i.getHeight(null);

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
}
