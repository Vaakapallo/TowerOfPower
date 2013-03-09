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

        
        Level a = new Level(16, 14);
        a.getGrid().setCellSize(50);
        
        a.getGrid().getCellAt(3, 3).setVisibility(false);
        a.getGrid().getCellAt(4, 3).setVisibility(false);
        a.getGrid().getCellAt(3, 4).setVisibility(false);
        a.getGrid().getCellAt(4, 4).setVisibility(false);
        
        LevelPanel l = new LevelPanel(a);
        GameWindow window = new GameWindow(l);
    }
}