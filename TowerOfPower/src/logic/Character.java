/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import logic.item.Armor;
import logic.item.Weapon;

/**
 *
 * @author lassi
 */
public class Character {

    private Stats stats;

    public Character(String name, int maxHitPoints, int maxMana, Race race) {
        stats = new Stats(name, maxHitPoints, maxMana, race);
    }

    /**
     * Changes the weapon of the character.
     *
     * @param weapon new weapon
     * @return Returns the last weapon held by the character. If none, returns
     * null.
     */
    public Weapon giveWeapon(Weapon weapon) {
        Weapon lastWeapon = stats.getWeapon();
        stats.setWeapon(weapon);
        return lastWeapon;
    }

    /**
     * Changes the armor of the character.
     *
     * @param weapon new armor
     * @return Returns the last armor held by the character. If none, returns
     * null.
     */
    public Armor giveArmor(Armor armor) {
        Armor lastArmor = stats.getArmor();
        stats.setArmor(armor);
        return lastArmor;
    }

    /**
     * Makes the character take damage.
     *
     * @param damage
     * @return Remaining hitpoints on character.
     */
    public int takeDamage(int damage) {
        stats.adjustCurrentHitPoints(-calculateDamage(damage));
        return stats.getCurrentHitPoints();
    }

    /**
     * Adjusts the damage based on the characters armor.
     *
     * @param damage original damage
     * @return reduced damage, but never less than zero
     */
    private int calculateDamage(int damage) {
        return Math.max(0, damage - stats.getArmor().getProtectionValue());
    }
}
