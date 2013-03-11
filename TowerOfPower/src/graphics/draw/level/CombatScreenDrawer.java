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
public class CombatScreenDrawer {

    private HashMap<String, Image> images;

    public CombatScreenDrawer(Level l) {
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

        /**
         * Point of this is to solve the amount of different tile graphic files
         * drawn for current level
         */
        int amountOfTileVariants = 0;
        while (images.containsKey("tile" + amountOfTileVariants)) {
            amountOfTileVariants++;
        }

        for (Cell c : orderedCells) {
            if (c.isVisible()) {
                drawCellTile(g, c, amountOfTileVariants);
            }
        }
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
         * Selects the tile graphic to be used for this cell
         */
        int tileVariant = c.getTileVariant() % amountOfTileVariants;
        String tileToUse = "tile" + tileVariant;

        /**
         * The last parameter here uses cell->variant as a randomization source
         * for the 3d height of the tile. The upside of this approach is that
         * each cell will have a fixed 3d height so that units and other cell
         * contents will be drawn correctly according to tile height.
         */
        drawImage(g, tileToUse, c.getX(), c.getY() + c.getTileVariant() % 4);
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
                drawImage(g, c.getContent().toString(),
                        c.getX(),
                        c.getY() -
                        images.get(c.getContent().toString()).getHeight(null)
                        + c.getHeight());
            }
        }
    }

    /**
     * For now, draws the top two of the static background images.
     * 
     * @param g Graphics
     */
    private void drawBackgroundTopLayers(Graphics g) {
        drawImage(g, "bg2", 0, 0);
        drawImage(g, "bg3", 0, 0);
    }
    
    /**
     * For now, draws the bottom two of the static background images.
     * 
     * @param g Graphics
     */
    private void drawBackgroundBottomLayers(Graphics g) {
        drawImage(g, "bg0", 0, 0);
        drawImage(g, "bg1", 0, 0);
    }

    /**
     * If the parameter image has been loaded, draws it at parameter
     * coordinates, scaled 1:1
     * 
     * @param g Graphics
     * @param image Source image
     * @param x Destination x
     * @param y Destination y
     */
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
