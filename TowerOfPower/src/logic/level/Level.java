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
    private int 
            levelNumber,
            xMargin,
            yMargin,
            xDimension,
            yDimension,
            cellSize;
    
    private HashMap<String, Image> images;

    public Level(int levelNumber, int xDimension, int yDimension, int cellSize, int xMargin, int yMargin) {
        this.levelNumber = levelNumber;
        this.xDimension = xDimension;
        this.yDimension = yDimension;
        this.cellSize = cellSize;

        this.xMargin = xMargin;
        this.yMargin = yMargin;

        this.images = (HashMap<String, Image>) new LevelImages(levelNumber).getImages();
        initializeGrid();
    }

    private void initializeGrid() {
        this.grid = new Grid(xDimension, yDimension);
        grid.setCellSize(cellSize);
        grid.moveGrid(xMargin, yMargin);
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

    public Grid getGrid() {
        return grid;
    }
}

