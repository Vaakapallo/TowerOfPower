/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicTest;

import logic.item.Item;
import logic.item.RangedWeapon;
import logic.item.Weapon;
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
        Item crossbow = new RangedWeapon("Awesomebow of Grilling", 2, 5, 3, 10);
        assertEquals("Awesomebow of Grilling", crossbow.getName());
    }

    @Test
    public void weaponToStringPrintsRight() {
        Item axe = new Weapon("Supersledge of Crushing", 5, 8);
        assertEquals("Supersledge of Crushing (Damage: 5-8)", axe.toString());
    }

    @Test
    public void weaponConstructorDoesntCareAboutTheOrderOfMinAndMax() {
        Item axe = new Weapon("Supersledge of Crushing", 5, 8);
        Item hammer = new Weapon("Supersledge of Crushing", 8, 5);
        assertEquals(axe.toString(), hammer.toString());
    }

    @Test
    public void rangedWeaponsUseWeaponToStringProperly() {
        Item crossbow = new RangedWeapon("Awesomebow of Grilling", 2, 5, 3, 10);
        assertEquals("Awesomebow of Grilling (Damage: 2-5)", crossbow.toString());
    }

    @Test
    public void weaponAttackWorks() {
        Weapon weapon = new Weapon(5, 8);
        int damage = weapon.attack();
        assertTrue(damage <= 8 && damage >= 5);
    }
}