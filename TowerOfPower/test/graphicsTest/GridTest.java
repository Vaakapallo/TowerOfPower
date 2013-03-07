/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphicsTest;

import graphics.Grid;
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
public class GridTest {

    public GridTest() {
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

    @Test
    public void fourByThreeGridAssignsCorrectIsometricPositionalValues() {
        Grid g = new Grid(4, 3);
        assertEquals("(0, 3)(2, 4)(4, 5)(2, 2)(4, 3)(6, 4)(4, 1)(6, 2)(8, 3)"
                + "(6, 0)(8, 1)(10, 2)", g.toString());
    }

    @Test
    public void gridFitToWidthFunctionsNicely() {
        Grid g = new Grid(4, 3);
        g.fitToWidth(128);
        assertEquals("(0, 36)(24, 48)(48, 60)(24, 24)(48, 36)(72, 48)(48, 12)"
                + "(72, 24)(96, 36)(72, 0)(96, 12)(120, 24)", g.toString());
    }
}