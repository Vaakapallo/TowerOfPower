/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.item;

import randomGenerators.EquipmentNameGenerator;

/**
 *
 * @author lassi
 */
public class RangedWeapon extends Weapon {

    /**
     * How far can you shoot with this thing.
     */
    private int range;
    /**
     * Max ammo possible in the gun.
     */
    private int maxAmmo;
    /**
     * How many rounds left in the gun.
     */
    private int currentAmmo;

    public RangedWeapon(String name, int minDamage, int maxDamage, int range, int maxAmmo) {
        super(name, minDamage, maxDamage);
        this.range = range;
        this.maxAmmo = maxAmmo;
        currentAmmo = maxAmmo;
    }

    public RangedWeapon(int minDamage, int maxDamage, int range, int maxAmmo) {
        this(EquipmentNameGenerator.generateRangedWeaponName(), minDamage, maxDamage, range, maxAmmo);
    }

    /**
     * AKA Shoot. Reduces current ammo by one.
     */
    @Override
    public void attack() {
        currentAmmo--;
    }

    /**
     * Adjusts current ammo back to maximum ammunition.
     */
    public void reload() {
        currentAmmo = maxAmmo;
    }
}
