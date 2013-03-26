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

    /**
     * Constructor loads image and stores it
     *
     * @param path
     */
    public ImageLoader(String path) {
        this.i = loadImage(path);
    }

    /**
     * Attempts to load image file from path. If file does not exist, returns
     * null and system-outs an error line.
     *
     * @param path Path to image file
     * @return Desired Image or null.
     */
    private Image loadImage(String path) {
        System.out.print(path);
        try {
            BufferedImage img;
            img = ImageIO.read(new File(path));
            System.out.println(" OK");
            return img;
        } catch (IOException e) {
            System.out.println(" NOT FOUND");
            return null;
        }
    }

    public Image getImage() {
        return i;
    }
}
