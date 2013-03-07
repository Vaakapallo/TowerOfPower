/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author 41407
 */
public class Grid {

    private GridCell[][] grid;
    private int xSize;
    private int ySize;

    public Grid(int x, int y) {
        this.grid = new GridCell[x][y];
        assignLocations();
        normalizeCoordinates();
    }

    /**
     * Assign the locations of individual grid cells for isometric configuration
     *
     * See documentation for details
     */
    private void assignLocations() {
        int xAdd;
        int yAdd;
        for (int x = 0; x < grid.length; x++) {
            xAdd = 2 * x;
            yAdd = -x;
            for (int y = 0; y < grid[0].length; y++) {
                grid[x][y] = new GridCell(xAdd, y + yAdd);
                xAdd += 2;
            }
        }
    }

    public void setSize(int x, int y) {
        this.xSize = x;
        this.ySize = y;
    }

    /**
     * Returns the grid cell at given array coordinate
     *
     * @param x
     * @param y
     */
    public GridCell getCellAt(int x, int y) {
        return grid[x][y];
    }

    @Override
    public String toString() {
        String returnString = "";
        for (GridCell[] gridCells : grid) {
            for (GridCell gridCell : gridCells) {
                returnString += gridCell.toString();
            }
        }
        return returnString;
    }

    /**
     * Adjusts each grid cell so that none of grid's y locations are negative
     */
    private void normalizeCoordinates() {
        int offsetAmount = grid.length - 1;
        for (GridCell[] gridCells : grid) {
            for (GridCell gridCell : gridCells) {
                gridCell.move(0, offsetAmount);
            }
        }
    }

    /**
     * Enlarges the grid so that its width will be less or equal to the
     * parameter width
     *
     * If given width is less than the grid's current width, this method does
     * nothing.
     *
     * @param width Desired maximum width of the grid.
     */
    public void fitToWidth(int width) {
        int xRightmost =
                grid[grid.length - 1][grid[0].length - 1].getX();
        if (width > xRightmost) {
            zoomGrid(greatestCommonFactor(xRightmost, width));
        }
    }

    /**
     * Enlarges the grid so that its height will be less or equal to the
     * parameter height
     *
     * If given height is less than the grid's current height, this method does
     * nothing.
     *
     * @param width Desired maximum height of the grid.
     */
    public void fitToHeight(int height) {
        int yBottom =
                grid[0][grid[0].length - 1].getY();
        if (height > yBottom) {
            zoomGrid(greatestCommonFactor(yBottom, height));
        }
    }

    /**
     * Enlarges the grid so that its width and height will be less or equal to
     * the parameter size.
     *
     * Resulting grid size will not exceed either of the parameter values.
     *
     * If given size is less than the grid's current size, this method does
     * nothing.
     *
     * @param width Desired maximum width of the grid.
     * @param height Desired maximum height of the grid.
     */
    public void fitToSize(int width, int height) {
        int xRightmost =
                grid[grid.length - 1][grid[0].length - 1].getX();
        int yBottom =
                grid[0][grid[0].length - 1].getY();
        if (width > xRightmost && height > yBottom) {
            int zoomFactor = Math.min(greatestCommonFactor(xRightmost, width),
                    greatestCommonFactor(yBottom, height));

            zoomGrid(zoomFactor);
        }
    }

    /**
     * Finds out how many times a can be multiplied so that a is less than or
     * equal to b.
     *
     * In other words, finds i for
     *
     * a * i ≤ b
     *
     * @param a
     * @param b
     * @return s
     */
    private int greatestCommonFactor(int a, int b) {
        int a1 = 0;
        int i = 1;
        while (a1 <= b) {
            i += 1;
            a1 = a * i;
        }
        return i - 1;
    }

    /**
     * Multiplies each gridCell's location value by parameter i
     *
     * @param i
     */
    private void zoomGrid(int i) {
        int x;
        int y;
        for (GridCell[] gridCells : grid) {
            for (GridCell gridCell : gridCells) {
                x = gridCell.getX();
                y = gridCell.getY();
                gridCell.setXY(x * i, y * i);
            }
        }
    }

    /**
     * Returns cells by their z index, in descending order.
     *
     * @return Sorted arrayList of cells.
     */
    public ArrayList<GridCell> getCells() {
        ArrayList<GridCell> cells = new ArrayList();
        for (GridCell[] gridCells : grid) {
            cells.addAll(Arrays.asList(gridCells));
        }
        Collections.sort(cells);
        return cells;
    }
}