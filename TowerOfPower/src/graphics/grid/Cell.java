/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics.grid;

import logic.Location;
import logic.level.CellContent;
import randomGenerators.RandomInteger;

/**
 * A class that is used to contain information related to a single cell of which
 * grids consist.
 *
 * @author 41407
 */
public class Cell extends Location implements Comparable<Cell> {

    /**
     * Should Cell be drawn?
     */
    private boolean visible;
    /**
     * What, if anything, cell contains
     */
    private CellContent content;
    /**
     * Cell's height
     */
    private int height;
    /**
     * Tile variant, which is a random number
     */
    private final int tileVariant;

    public Cell(int x, int y) {
        super(x, y);
        this.visible = true;
        this.content = null;
        this.tileVariant = RandomInteger.getRandom();
    }

    public void setVisibility(boolean visible) {
        this.visible = visible;
    }

    public boolean isVisible() {
        return visible;
    }

    @Override
    public int compareTo(Cell cell) {
        return this.getY() - cell.getY();
    }

    public void setContent(CellContent c) {
        this.content = c;
    }

    public CellContent getContent() {
        return content;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getTileVariant() {
        return tileVariant;
    }
}