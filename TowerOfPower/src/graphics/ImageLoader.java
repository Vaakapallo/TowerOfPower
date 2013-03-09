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

    public Image getImage() {
        return i;
    }

    /**
     * Attempts to load image file from path. If file does not exist, returns an
     * error image and system-outs an error line.
     *
     * If error image doesn't exist, system-outs an error line and returns null.
     *
     * @param path Path to image file
     * @return Desired Image, debug image or null.
     */
    private Image loadImage(String path) {
        System.out.print(path);
        try {
            System.out.println(" OK");
            BufferedImage img;
            img = ImageIO.read(new File(path));
            return img;
        } catch (IOException e) {
            try {
                System.out.println(" NOT FOUND");
                BufferedImage img;
                img = ImageIO.read(new File("resources/notfound.png"));
                return img;
            } catch (IOException f) {
                System.out.println(" NOT FOUND");
                return null;
            }
        }
    }
}
