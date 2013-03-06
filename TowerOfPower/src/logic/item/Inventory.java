/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.item;

import java.util.ArrayList;

/**
 *
 * @author 41407
 */
public class Inventory {

    private ArrayList<Item> items;

    public Inventory() {
        this.items = new ArrayList();
    }

    /**
     * Adds an item to inventory.
     *
     * @param item to be added
     */
    public void addItem(Item item) {
        this.items.add(item);
    }

    /**
     * Removes the parameter item from inventory.
     *
     * @param item
     * @return true if item was removed, false if the item wasn't found in the
     * inventory
     */
    public boolean removeItem(Item item) {
        if (this.items.contains(item)) {
            items.remove(item);
            return true;
        }
        return false;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     *
     * @return Returns toStrings() of contained items on their separate lines
     * If the inventory is empty, returns "Inventory is empty."
     */
    @Override
    public String toString() {
        String itemStrings = "";
        if (!items.isEmpty()) {
            for (Item item : items) {
                itemStrings += item.toString() + "\n";
            }
        } else {
            itemStrings = "Inventory is empty.";
        }
        return itemStrings;
    }
}
