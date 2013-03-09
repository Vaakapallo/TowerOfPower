/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics.grid;

import logic.Location;
import logic.level.CellProperty;

/**
 *
 * @author 41407
 */
public class Cell extends Location implements Comparable<Cell> {

    private boolean visible;
    private boolean accessible;

    public Cell(int x, int y) {
        super(x, y);
        this.visible = true;
        this.accessible = false;
    }

    public void setVisibility(boolean visible) {
        this.visible = visible;
        this.accessible = false;
    }

    public boolean isVisible() {
        return visible;
    }

    @Override
    public int compareTo(Cell cell) {
        return this.getY() - cell.getY();
    }
}
