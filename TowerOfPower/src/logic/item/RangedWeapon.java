/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.item;

/**
 *
 * @author lassi
 */
public class RangedWeapon extends Weapon {

    private int range;

    public RangedWeapon(int range, int minDamage, int maxDamage, String name) {
        super(minDamage, maxDamage, name);
        this.range = range;
    }
}
