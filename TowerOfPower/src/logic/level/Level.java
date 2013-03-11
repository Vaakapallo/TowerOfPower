/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.level;

import graphics.draw.level.CombatScreenImages;
import graphics.grid.Cell;
import graphics.grid.Grid;
import java.awt.Image;
import java.util.ArrayList;
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
    private int levelNumber,
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
        this.images = new HashMap();
        this.xMargin = xMargin;
        this.yMargin = yMargin;

        initializeGrid();
    }

    private void initializeGrid() {
        this.grid = new Grid(xDimension, yDimension);
        grid.setCellSize(cellSize);
        grid.moveGrid(xMargin, yMargin);
    }

    /**
     * Method that loads level images. Must be called before combat panel is
     * created!
     */
    public void loadImages() {
        CombatScreenImages c = new CombatScreenImages(levelNumber);
        
        ArrayList<CellContent> contents = new ArrayList();
        ArrayList<Cell> cells = grid.getCells();
        for (Cell cell : cells) {
            if (cell.getContent() != null) {
                c.loadCellContent(cell.getContent());
            }
        }
        this.images = (HashMap<String, Image>) c.getImages();
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
