/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicTest;

import java.util.ArrayList;
import logic.item.Inventory;
import logic.item.Item;
import logic.item.Weapon;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 41407
 */
public class InventoryTest {

    private ArrayList<Item> items;

    public InventoryTest() {
        items = new ArrayList();
        items.add(new Weapon("Sword", 1, 6));
        items.add(new Weapon("Staff", 1, 3));
        items.add(new Weapon("Dagger", 3, 4));
        items.add(new Weapon("Electric Eel", 1, 6));
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    private Inventory addStuff() {
        Inventory i = new Inventory();
        for (Item item : items) {
            i.addItem(item);
        }
        return i;
    }

    @Test
    public void itemsGetAdded() {
        Inventory i = this.addStuff();
        assertFalse("Inventory is empty", i.getItems().isEmpty());
    }

    @Test
    public void toStringWorksWithMeleeWeapons() {
        Inventory i = this.addStuff();
        assertEquals("Sword (Damage: 1-6)\n"
                + "Staff (Damage: 1-3)\n"
                + "Dagger (Damage: 3-4)\n"
                + "Electric Eel (Damage: 1-6)", i.toString());
    }

    @Test
    public void toStringWorksWithEmptyInventory() {
        Inventory i = new Inventory();
        assertEquals("Inventory is empty.", i.toString());
    }
}