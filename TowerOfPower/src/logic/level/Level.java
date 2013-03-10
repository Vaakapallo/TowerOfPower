/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.level;

import graphics.draw.level.LevelImages;
import graphics.grid.Grid;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

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

    private HashMap<String, Image> images;
    
    private String backgroundImage;
    
    public Level(int x, int y) {
        this.xMargin = 156;
        this.yMargin = 222;
        this.backgroundImage = "bg00";
                this.grid = new Grid(x, y);
        grid.setCellSize(54);
        grid.moveGrid(xMargin, yMargin);
        int levelNumber = 0;
        this.images = (HashMap<String, Image>) new LevelImages(levelNumber).getImages();
    }

    public HashMap<String, Image> getLevelImages() {
        return images;
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
