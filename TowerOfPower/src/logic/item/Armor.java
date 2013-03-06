/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.item;

/**
 *
 * @author lassi
 */
public class Armor extends Item {

    /**
     * How much damage the armor outright reduces.
     */
    private int protectionValue;
    /**
     * Affects the dodging capabilities of the user.
     */
    private int dodgeValue;

    public Armor(String name, int protectionValue, int dodgeValue) {
        super(name);
        this.protectionValue = protectionValue;
        this.dodgeValue = dodgeValue;
    }

    public int getProtectionValue() {
        return protectionValue;
    }

    public int getDodgeValue() {
        return dodgeValue;
    }
}
