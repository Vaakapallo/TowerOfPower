/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics.grid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Isometric grid that consists of Cells
 * 
 * @author 41407
 */
public class Grid {

    /**
     * Array to store grid Cells
     */
    private Cell[][] grid;
    
    /**
     * Grid's position in pixels
     */
    private int xPosition;
    private int yPosition;

    /**
     * Creates a grid of specific dimensions.
     * 
     * @param xDimension
     * @param yDimension 
     */
    public Grid(int xDimension, int yDimension) {
        this.grid = new Cell[xDimension][yDimension];
        assignLocations();
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
                grid[x][y] = new Cell(xAdd, y + yAdd);
                xAdd += 2;
            }
        }
        normalizeCoordinates();
    }

    public void setDimension(int x, int y) {
        this.xPosition = x;
        this.yPosition = y;
    }

    /**
     * Returns the grid cell at given array coordinate
     *
     * @param x x index of the cell
     * @param y y index of the cell
     */
    public Cell getCellAt(int x, int y) {
        return grid[x][y];
    }

    /**
     * Adjusts each grid cell so that none of grid's y locations are negative
     */
    private void normalizeCoordinates() {
        int offsetAmount = grid.length - 1;
        for (Cell[] gridCells : grid) {
            for (Cell gridCell : gridCells) {
                gridCell.move(0, offsetAmount);
            }
        }
    }

    /**
     * Resizes the cells to be certain size, disregarding any size constraints.
     *
     * @param width Desired cell width
     */
    public void setCellSize(int width) {
        if (width < 1) {
            return;
        }
        zoomGrid(width/4);
    }

    /**
     * Multiplies each gridCell's location value by parameter i
     *
     * @param i
     */
    private void zoomGrid(int i) {
        assignLocations();
        int x;
        int y;
        for (Cell[] gridCells : grid) {
            for (Cell gridCell : gridCells) {
                x = gridCell.getX();
                y = gridCell.getY();
                gridCell.setXY(x * i, y * i);
                gridCell.setHeight(i*2);
            }
        }
    }

    /**
     * Returns cells by their z index, in descending order.
     *
     * @return Sorted arrayList of cells.
     */
    public ArrayList<Cell> getCells() {
        ArrayList<Cell> cells = new ArrayList();
        for (Cell[] gridCells : grid) {
            cells.addAll(Arrays.asList(gridCells));
        }
        Collections.sort(cells);
        return cells;
    }

    /**
     * Returns the Cell at given grid coordinates.
     *
     * @param x
     * @param y
     * @return Cell at parameter coordinate, or null if coordinate out of bounds
     */
    public Cell getCell(int x, int y) {
        if (x < grid.length && y < grid[0].length) {
            return grid[x][y];
        } else {
            return null;
        }
    }

    /**
     * Moves the grid as defined by parameter dx, dy
     *
     * @param dx
     * @param dy
     */
    public void moveGrid(int dx, int dy) {
        for (Cell[] cells : grid) {
            for (Cell cell : cells) {
                cell.move(dx, dy);
            }
        }
    }

    /**
     * Mostly (solely) for testing purposes
     *
     * @return
     */
    @Override
    public String toString() {
        String returnString = "";
        for (Cell[] gridCells : grid) {
            for (Cell gridCell : gridCells) {
                returnString += gridCell.toString();
            }
        }
        return returnString;
    }
}