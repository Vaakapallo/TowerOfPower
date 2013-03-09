/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics.draw.level;

import graphics.ImageLoader;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

/**
 *
 * @author 41407
 */
public class UIPanel extends JPanel {
    private final Image img;

    public UIPanel() {
        ImageLoader i = new ImageLoader("resources/ui/gameplay/tooltipBase.png");
        this.img = i.getImage();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int dstx1 = 0;
        int dsty1 = /*this.getHeight() - 200*/ 300;
        int dstx2 = dstx1 + img.getWidth(null);
        int dsty2 = dsty1 + img.getHeight(null);
       
        g.drawImage(img,
                dstx1, dsty1,
                dstx2, dsty2,
                0, 0,
                img.getWidth(this),
                img.getHeight(this), null);
    }
}
