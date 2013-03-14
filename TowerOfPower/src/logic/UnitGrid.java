/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author Lassi
 */
public class UnitGrid {

    Unit[][] units;

    public UnitGrid(int xDimension, int yDimension) {
        this.units = new Unit[xDimension][yDimension];
    }

    /**
     * Adds an unit to the grid, if possible.
     * 
     * Returns false if there is already an unit in the array.
     * 
     * @param unit Unit to add
     * @param location Location to add
     * @return 
     */
    public boolean addUnit(Unit unit, Location location) {
        if (units[location.getX()][location.getY()] != null) {
            return false;
        } else {
            units[location.getX()][location.getY()] = unit;
            return true;
        }
    }

    /**
     * Moves the specified unit to target location, if possible.
     * 
     * @param unit which unit to move
     * @param destination where to move it
     * @return 
     */
    public boolean moveUnit(Unit unit, Location destination) {
        Location startingLocation = findUnitLocation(unit);
        if(startingLocation == null){
            //Exception UnitNotOnGridException?
            return false;
        } else {
            if(moveisLegal(unit, startingLocation,destination)){
                
            }
        }
        
    }

    
    /**
     * Returns a Location-object of a unit in the grid.
     * 
     * Null if the unit doesn't exist on the grid.
     * 
     * @param unitToFind
     * @return 
     */
    private Location findUnitLocation(Unit unitToFind) {
        for (int i = 0; i < units.length; i++) {
            for (int j = 0; j < units[0].length; j++) {
                if (units[i][j] == unitToFind) {
                    return new Location(i, j);
                }
            }
        }
        return null;
    }

    private boolean moveisLegal(Unit unit, Location startingLocation, Location destination) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
