/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicTest;

import logic.item.Item;
import logic.item.RangedWeapon;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lassi
 */
public class WeaponTest {

    @Before
    public void setUp() {
    }

    @Test
    public void rangedWeaponConstructorWorks() {
        Item crossbow = new RangedWeapon(3, 5, 8, "Awesomebow of Grilling");
        assertEquals("Awesomebow of Grilling", crossbow.getName());
    }
}