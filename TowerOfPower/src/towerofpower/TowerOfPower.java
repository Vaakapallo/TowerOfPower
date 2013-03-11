/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package towerofpower;

import graphics.draw.level.CombatPanel;
import graphics.ui.GameWindow;
import logic.Race;
import logic.Unit;
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
        Level a = p.getLevel();
        Unit u = new Unit("Boutros", 20, 10, Race.Fighter);
        Unit n = new Unit("KAukalo", 20, 10, Race.Bowman);
        Unit y = new Unit("Amelie", 20, 10, Race.Sharpshooter);
        a.getGrid().getCellAt(10, 3).setContent(u);
        a.getGrid().getCellAt(8, 7).setContent(n);
        a.getGrid().getCellAt(4, 5).setContent(y);
        a.getGrid().getCellAt(5, 5).setVisibility(false);
        a.getGrid().getCellAt(5, 6).setVisibility(false);
        a.getGrid().getCellAt(6, 5).setVisibility(false);
        a.getGrid().getCellAt(6, 6).setVisibility(false);
        a.loadImages();

        CombatPanel l = new CombatPanel(a);
        GameWindow w = new GameWindow(l);
        w.setSize(1024, 768);
    }
}