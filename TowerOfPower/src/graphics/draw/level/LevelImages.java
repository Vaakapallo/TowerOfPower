/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics.draw.level;

import graphics.ImageLoader;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 41407
 */
public class LevelImages {

    private Map<String, Image> images;
    private int levelNumber;
    private String levelDirectory;

    public LevelImages(int levelNumber) {
        this.images = new HashMap();
        this.levelNumber = levelNumber;
        this.levelDirectory = "resources/level/" + levelNumber + "/";
        loadImages();
    }

    private void loadImages() {
        loadTiles();
        loadBackground();
    }

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

    public Map<String, Image> getImages() {
        return images;
    }
}
