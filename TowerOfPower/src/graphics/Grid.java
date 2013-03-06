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
    
    public void getCoordinate(int x, int y) {
        
    }

    @Override
    public String toString() {
        String returnString = "";
        for (GridCell[] gridCells : grid) {
            for (GridCell gridCell : gridCells) {
                returnString += gridCell.toString() + "\n";
            }
        }
        return returnString;
    }
    
}
