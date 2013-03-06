/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.item;

import logic.item.Item;

/**
 *
 * @author lassi
 */
class Armor extends Item {

    private int protectionValue;
    private int dodgeValue;

    public Armor(String name, int protectionValue, int dodgeValue) {
        super(name);
        this.protectionValue = protectionValue;
        this.dodgeValue = dodgeValue;
    }
}
