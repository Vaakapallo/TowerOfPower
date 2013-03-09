/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.level;

import graphics.grid.Grid;

/**
 *
 * @author lassi
 */
public class Level {

    private Grid grid;

    public Level(int x, int y) {
        this.grid = new Grid(x, y);
    }

    public Grid getGrid() {
        return grid;
    }
}
