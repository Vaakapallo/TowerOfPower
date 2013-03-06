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

    public RangedWeapon(String name, int minDamage, int maxDamage, int range) {
        super(name, minDamage, maxDamage);
        this.range = range;
    }
}
