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
    
    /**
     * Distance between the top of the panel to the left and top borders of the
     * grid, respectively
     */
    private int xMargin,
                yMargin;

    private String backgroundImage;
    
    public Level(int x, int y) {
        this.grid = new Grid(x, y);
        this.xMargin = 156;
        this.yMargin = 222;
        this.backgroundImage = "bg00";
    }

    public int getxMargin() {
        return xMargin;
    }

    public int getyMargin() {
        return yMargin;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public Grid getGrid() {
        return grid;
    }
}
