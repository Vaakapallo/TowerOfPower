/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package towerofpower;

import graphics.draw.level.LevelPanel;
import graphics.grid.Cell;
import graphics.ui.GameWindow;
import logic.Champion;
import logic.Race;
import logic.level.Level;
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
        Level a = new Level(14, 14);
        LevelPanel l = new LevelPanel(a);
        GameWindow w = new GameWindow(l);
        w.setSize(1024, 768);
        Champion d = new Champion("Brian", 10, 20, Race.Fighter);
        a.getGrid().getCellAt(3, 9).setContent(d);
        Level b = new Level(26, 18);
        l = new LevelPanel(b);
        w.repaint();
        l.repaint();
    }
}