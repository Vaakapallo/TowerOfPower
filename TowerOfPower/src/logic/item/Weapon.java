/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.item;

import randomGenerators.EquipmentNameGenerator;
import randomGenerators.RandomInteger;

/**
 *
 * @author lassi
 */
public class Weapon extends Item {

    private int minDamage;
    private int maxDamage;

    /**
     * The Constructor makes sure that minDamage is lower than maxDamage.
     *
     * Also that maxDamage is larger than minDamage.
     *
     * @param minDamage
     * @param maxDamage
     * @param name
     */
    public Weapon(String name, int minDamage, int maxDamage) {
        super(name);
        this.minDamage = Math.min(minDamage, maxDamage);
        this.maxDamage = Math.max(minDamage, maxDamage);
    }

    public Weapon(int minDamage, int maxDamage) {
        this(EquipmentNameGenerator.generateMeleeWeaponName(), minDamage, maxDamage);
    }

    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public int attack() {
        return RandomInteger.getRandomInt(maxDamage - minDamage) + minDamage;
    }

    @Override
    public String toString() {
        return super.toString() + " (Damage: " + minDamage + "-" + maxDamage + ")";
    }
}
