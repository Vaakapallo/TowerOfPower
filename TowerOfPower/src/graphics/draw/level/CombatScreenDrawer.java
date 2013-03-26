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

    /**
     * Hashmap that stores the images used in the combat screen.
     */
    private HashMap<String, Image> images;

    /**
     * Constructor takes a level as a parameter and stores its images into the
     * field images.
     *
     * @param l level to be drawn
     */
    public CombatScreenDrawer(Level l) {
        this.images = l.getLevelImages();
    }

    /**
     * Draws the parameter level
     *
     * @param l level
     * @param g Graphics
     */
    public void drawLevel(Level l, Graphics g) {
        /**
         * By ordering drawn contents as follows, z-index is implemented.
         *
         * First, the bottom layer of the backdrop
         */
        drawBackgroundBottomLayers(g);
        /**
         * Grid / playing field / board
         */
        drawGrid(g, l);
        /**
         * Units and such
         */
        drawCellContents(g, l);
        /**
         * Top layers of the background scenery
         */
        drawBackgroundTopLayers(g);
    }

    /**
     * Draws the grid defined by the parameter level
     *
     * @param g Graphics
     * @param l Level
     */
    void drawGrid(Graphics g, Level l) {

        /**
         * Store level's grid cells in correct order
         */
        ArrayList<Cell> orderedCells = l.getGrid().getCells();

        /**
         * Point of this is to solve the amount of different tile graphic files
         * that exist for current level
         */
        int amountOfTileVariants = 0;
        while (images.containsKey("tile" + amountOfTileVariants)) {
            amountOfTileVariants++;
        }

        /**
         * The actual drawing
         */
        for (Cell c : orderedCells) {
            if (c.isVisible()) {
                drawCellTile(g, c, amountOfTileVariants);
            }
        }
    }

    /**
     * Draws the base tile of given cell
     *
     * @param g Graphics
     * @param c Cell
     * @param amountOfTileVariants
     */
    private void drawCellTile(Graphics g, Cell c, int amountOfTileVariants) {
        /**
         * Selects the tile graphic to be used for this cell by using cell's
         * attribute tileVariant, which is a random number specific to the cell
         */
        int tileVariant = c.getTileVariant() % amountOfTileVariants;
        String tileToUse = "tile" + tileVariant;

        /**
         * The last parameter here uses cell->variant as a randomization source
         * for the 3d height of the tile. The upside of this approach is that
         * each cell will have a fixed 3d height so that units and other cell
         * contents will be drawn correctly according to tile height.
         *
         * TODO
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
        /**
         * Store sorted cells into an arraylist
         */
        ArrayList<Cell> orderedCells = l.getGrid().getCells();

        /**
         * Simply call the draw function for each cellContent found
         */
        for (Cell c : orderedCells) {
            if (c.getContent() != null) {
                drawImage(g, c.getContent().toString(),
                        c.getX(),
                        c.getY()
                        - images.get(c.getContent().toString()).getHeight(null)
                        + c.getHeight());
            }
        }
    }

    /**
     * Draws the top two of the static background images.
     *
     * Animation, or some sort of programmed motion will probably be added.
     * Maybe in form of another layer to keep things simple.
     *
     * @param g Graphics
     */
    private void drawBackgroundTopLayers(Graphics g) {
        drawImage(g, "bg2", 0, 0);
        drawImage(g, "bg3", 0, 0);
    }

    /**
     * Draws the bottom two of the static background images.
     *
     * Animation, or some sort of programmed motion will probably be added.
     * Maybe in form of another layer to keep things simple.
     *
     * @param g Graphics
     */
    private void drawBackgroundBottomLayers(Graphics g) {
        drawImage(g, "bg0", 0, 0);
        drawImage(g, "bg1", 0, 0);
    }

    /**
     * If the parameter image has been loaded, draws it at parameter
     * coordinates, scaled 1:1.
     * 
     * If image isn't loaded, nothing will be drawn.
     *
     * @param g Graphics
     * @param image Source image
     * @param x Destination x for the upper left hand corner of the image
     * @param y Destination y for the upper left hand corner of the image
     */
    private void drawImage(Graphics g, String image,
            int x, int y) {
        if (images.containsKey(image)) {
            Image i = images.get(image);

            /**
             * The following two variables are used to define both source and
             * destination point for the lower right hand corner of the image,
             * and are taken from the image data.
             */
            int width = i.getWidth(null);
            int height = i.getHeight(null);

            /**
             * Destination x and y position for the upper left corner
             */
            int dstx1 = x;
            int dsty1 = y;

            /**
             * Destination x and y for the lower right corner
             */
            int dstx2 = dstx1 + width;
            int dsty2 = dsty1 + height;

            /**
             * Function call for Graphics.drawImage
             */
            g.drawImage(i,
                    dstx1, dsty1,
                    dstx2, dsty2,
                    0, 0,
                    width, height, null);
        }
    }
}
