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
    private int maxAmmo;
    private int currentAmmo;

    public RangedWeapon(String name, int minDamage, int maxDamage, int range, int maxAmmo) {
        super(name, minDamage, maxDamage);
        this.range = range;
        this.maxAmmo = maxAmmo;
        currentAmmo = maxAmmo;
    }

    public void shoot() {
        currentAmmo--;
    }

    public void reload() {
        currentAmmo = maxAmmo;
    }
}
