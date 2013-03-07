/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

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
     * Assign the locations of individual grid cells for isometric
     * configuration
     */
    private void assignLocations() {
        int xAdd;
        int yAdd;
        for (int x = 0; x < grid.length; x++) {
            xAdd = 2*x;
            yAdd = -x;
            for (int y = 0; y < grid[0].length; y++) {
                grid[x][y] = new GridCell(xAdd, y+yAdd);
                xAdd+=2;
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
        int offsetAmount = grid.length-1;
        for (GridCell[] gridCells : grid) {
            for (GridCell gridCell : gridCells) {
                gridCell.move(0, offsetAmount);
            }
        }
    }
    
    public void fitToWidth(int width) {
        int xRightmost =
                grid[grid.length-1][grid[0].length-1].getX();
        int newXRightmost = 0;
        int i = 1;
        while(newXRightmost <= width) {
            i+=2;
            newXRightmost = xRightmost * i;
        }
        zoomGrid(i-1);
    }
    
    public void fitToHeight(int height) {
        
    }
    
    public void fitToSize(int width, int height) {
        
    }

    private void zoomGrid(int i) {
        int x;
        int y;
        for (GridCell[] gridCells : grid) {
            for (GridCell gridCell : gridCells) {
                x = gridCell.getX();
                y = gridCell.getY();
                gridCell.setXY(x*i, y*i);
            }
        }
    }
}