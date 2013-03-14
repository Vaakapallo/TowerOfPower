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

    private Unit[][] units;

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
        if (locationFull(location)) {
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
    public boolean moveUnit(Unit unit, Location destination) throws UnitNotOnGridException {
        Location startingLocation = findUnitLocation(unit);
        if (startingLocation == null) {
            throw new UnitNotOnGridException("Tried to move unit that was not found from UnitGrid");
        } else {
            if (moveisLegal(unit, startingLocation, destination)) {
                removeUnit(unit);
                addUnit(unit, destination);
                return true;
            } else {
                return false;
            }
        }

    }

    /**
     * Returns a Location-object of a unit in the grid.
     *
     * Null if the unit isn't found from the grid.
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

    private void removeUnit(Unit unit) {
        Location deleteFromLocation = findUnitLocation(unit);
        units[deleteFromLocation.getX()][deleteFromLocation.getY()] = null;
    }

    /**
     * WIP!
     * 
     * Checks the legality of the move. Doesn't yet support Unit Speed or diagonals properly!
     * 
     * @param unit unit being moved.
     * @param startingLocation From where
     * @param destination to where
     * @return 
     */
    private boolean moveisLegal(Unit unit, Location startingLocation, Location destination) {
        if (locationFull(destination)) {
            return false;
        } // Unit speed?
        else if (Math.abs(startingLocation.getX() - destination.getX()) > 3
                || Math.abs(startingLocation.getY() - destination.getY()) > 3) {
            return false;
        } else {
            return true;
        }
    }

    private boolean locationFull(Location location) {
        return units[location.getX()][location.getY()] != null;
    }
}
