/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package towerofpower;

import graphics.GameWindow;
import graphics.draw.level.LevelPanel;
import java.util.logging.Logger;
import logic.level.Level;
import randomGenerators.WeaponNameGenerator;

/**
 *
 * @author lassi
 */
public class TowerOfPower {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(WeaponNameGenerator.generateMeleeWeaponName());
            System.out.println(WeaponNameGenerator.generateRangedWeaponName());
        }

        Level a = new Level(12, 7);
        a.getGrid().fitToSize(800, 600);
        LevelPanel l = new LevelPanel(a);
        GameWindow window = new GameWindow(l);

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
                a = new Level(10 + i, 5 + i);

                a.getGrid().fitToSize(800, 600);
                l.setL(a);
                window.update();
                if (i == 9) {
                    i = 0;
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(TowerOfPower.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }


    }
}
