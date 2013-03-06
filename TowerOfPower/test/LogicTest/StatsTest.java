/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicTest;

import logic.Race;
import logic.Stats;
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
public class StatsTest {

    @Before
    public void setUp() {
    }

    @Test
    public void statsToStringPrintsTheNameRight() {
        Stats stats = new Stats("John", 3, 4, null, null, Race.Fighter);
        assertEquals("John the Fighter", stats.toString());
    }
}