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

    public Weapon(int minDamage, int maxDamage, String name) {
        super(name);
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    @Override
    public String toString() {
        return super.toString() + "( " + minDamage + "-" + maxDamage + ")";
    }
}
