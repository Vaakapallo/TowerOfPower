/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import logic.item.Armor;
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
    private Armor armor;
    private Race race;

    public Stats(String name, int maxHitPoints, int maxMana, Weapon weapon, Armor armor, Race race) {
        this.name = name;
        this.maxHitPoints = maxHitPoints;
        this.maxMana = maxMana;
        this.weapon = weapon;
        this.armor = armor;
        this.race = race;
        this.currentHitPoints = maxHitPoints;
        this.currentMana = maxMana;
    }

    Stats(String name, int maxHitPoints, int maxMana, Race race) {
        this.name = name;
        this.maxHitPoints = maxHitPoints;
        this.maxMana = maxMana;
        this.weapon = null;
        this.armor = null;
        this.race = race;
        this.currentHitPoints = maxHitPoints;
        this.currentMana = maxMana;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxHitPoints() {
        return maxHitPoints;
    }

    public void setMaxHitPoints(int maxHitPoints) {
        this.maxHitPoints = maxHitPoints;
    }

    public int getCurrentHitPoints() {
        return currentHitPoints;
    }

    public void setCurrentHitPoints(int currentHitPoints) {
        this.currentHitPoints = currentHitPoints;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public int getCurrentMana() {
        return currentMana;
    }

    public void setCurrentMana(int currentMana) {
        this.currentMana = currentMana;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    @Override
    public String toString() {
        return name + " the " + race;
    }
}
