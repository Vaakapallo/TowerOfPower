/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics.draw.level;

import graphics.ImageLoader;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;
import logic.level.CellContent;

/**
 * A class that loads images that will be needed to draw a level.
 *
 * @author 41407
 */
public class CombatScreenImages {

    /**
     * The map in which the images will be stored
     */
    private Map<String, Image> images;
    /**
     * Level number will be needed to solve which tileset + backdrop to use
     */
    private int levelNumber;
    /**
     * Path to the level specific directory
     */
    private String levelDirectory;

    /**
     * Constructor takes the level number as a parameter, and loads required
     * images.
     * 
     * @param levelNumber 
     */
    public CombatScreenImages(int levelNumber) {
        this.images = new HashMap();
        this.levelNumber = levelNumber;
        this.levelDirectory = "resources/level/" + levelNumber + "/";
        loadImages();
    }

    /**
     * Calls methods to load tiles and background images.
     */
    private void loadImages() {
        loadTiles();
        loadBackground();
    }

    /**
     * Loads level specific tiles
     */
    private void loadTiles() {
        String imageName = "tile";
        String path = this.levelDirectory + imageName;
        int i = 0;
        while (true) {
            ImageLoader imageLoader = new ImageLoader(path + i + ".png");
            if (imageLoader.getImage() != null) {
                images.put(imageName + i, imageLoader.getImage());
            } else {
                break;
            }
            i++;
        }
    }

    /**
     * Loads level specific background images
     */
    private void loadBackground() {
        String imageName = "bg";
        String path = this.levelDirectory + imageName;
        for (int i = 0; i < 4; i++) {
            ImageLoader imageLoader = new ImageLoader(path + i + ".png");
            if (imageLoader.getImage() != null) {
                images.put(imageName + i, imageLoader.getImage());
            }
        }
    }

    /**
     * Loads parameter cellContent
     * 
     * @param c CellContent
     */
    public void loadCellContent(CellContent c) {
        String path = "resources/level/" + c.getPath();
        ImageLoader imageLoader = new ImageLoader(path + ".png");
        if (imageLoader.getImage() != null) {
            images.put(c.toString(), imageLoader.getImage());
        }
    }
    
    public Map<String, Image> getImages() {
        return images;
    }
}
