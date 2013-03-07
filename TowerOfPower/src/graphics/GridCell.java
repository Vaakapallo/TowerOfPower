/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import logic.Location;

/**
 *
 * @author 41407
 */
public class GridCell extends Location implements Comparable<GridCell> {

    public GridCell(int x, int y) {
        super(x, y);
    }

    @Override
    public int compareTo(GridCell cell) {
        return this.getY() - cell.getY();
    }
}
