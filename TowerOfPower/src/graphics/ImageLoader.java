/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Loads an image from file.
 * 
 * @author 41407
 */
public class ImageLoader {

    private Image i;

    public ImageLoader(String path) {
        this.i = loadImage(path);
        System.out.println(this.i.getHeight(null));
        System.out.println(this.i.getWidth(null));
    }

    public Image getImage() {
        return i;
    }

    private Image loadImage(String path) {
        try {
            BufferedImage img = null;
            img = ImageIO.read(new File(path));
            return img;
        } catch (IOException e) {
            return null;
        }
    }
}
