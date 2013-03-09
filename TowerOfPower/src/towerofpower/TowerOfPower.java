/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package towerofpower;

import graphics.GameWindow;
import graphics.draw.level.LevelPanel;
import java.util.logging.Logger;
import logic.Champion;
import logic.Race;
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
        
        Champion c = new Champion("Pekka", 30, 20, Race.Fighter);
        
        Champion d = new Champion("Makkonen", 1, 800, Race.Bowman);
        a.getGrid().getCellAt(15,0).setContent(d);
        
        a.getGrid().getCellAt(10,4).setContent(c);
        a.getGrid().getCellAt(3,8).setContent(d);
        LevelPanel l = new LevelPanel(a);
        GameWindow window = new GameWindow(l);
    }
}