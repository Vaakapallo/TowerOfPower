/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import logic.item.Item;
import logic.item.Weapon;

/**
 *
 * @author lassi
 */
public class Stats {

    private String name;
    private int maxHitPoints;
    private int currentHitPoints;
    private int maxMana;
    private int currentMana;
    private Weapon weapon;
    private Item armor;
    private Class characterClass;

    public Stats(String name, int maxHitPoints, int maxMana, Weapon weapon, Item armor, Class characterClass) {
        this.name = name;
        this.maxHitPoints = maxHitPoints;
        this.maxMana = maxMana;
        this.weapon = weapon;
        this.armor = armor;
        this.characterClass = characterClass;
        this.currentHitPoints = maxHitPoints;
        this.currentMana = maxMana;
    }

    @Override
    public String toString() {
        return "Character{" + "name=" + name + ", characterClass=" + characterClass + '}';
    }
}
