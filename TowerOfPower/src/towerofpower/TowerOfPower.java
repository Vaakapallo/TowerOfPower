/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package towerofpower;

import graphics.draw.level.LevelPanel;
import graphics.ui.GameWindow;
import logic.level.Level;
import logic.level.ParseLevel;
import randomGenerators.EquipmentNameGenerator;

/**
 *
 * @author lassi
 */
public class TowerOfPower {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println(EquipmentNameGenerator.generateMeleeWeaponName());
            System.out.println(EquipmentNameGenerator.generateRangedWeaponName());
        }
        ParseLevel p = new ParseLevel("level0");
        Level a = p.getL();

        a.getGrid().getCellAt(5, 5).setVisibility(false);
        a.getGrid().getCellAt(5, 6).setVisibility(false);
        a.getGrid().getCellAt(6, 5).setVisibility(false);
        a.getGrid().getCellAt(6, 6).setVisibility(false);

        LevelPanel l = new LevelPanel(a);
        GameWindow w = new GameWindow(l);
        w.setSize(1024, 768);
    }
}