/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.item;

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
     * @param minDamage
     * @param maxDamage
     * @param name
     */
    public Weapon(String name, int minDamage, int maxDamage) {
        super(name);
        this.minDamage = Math.min(minDamage, maxDamage);
        this.maxDamage = Math.max(minDamage, maxDamage);
    }

    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    @Override
    public String toString() {
        return super.toString() + " (Damage: " + minDamage + "-" + maxDamage + ")";
    }
}
