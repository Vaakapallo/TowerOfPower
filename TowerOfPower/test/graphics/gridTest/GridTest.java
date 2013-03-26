/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics.gridTest;

import graphics.grid.Grid;
import graphics.grid.Cell;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 41407
 */
public class GridTest {

    public GridTest() {
    }

    @Test
    public void fourByThreeGridAssignsCorrectIsometricPositionalValues() {
        Grid g = new Grid(4, 3);
        assertEquals("(0, 3)(2, 4)(4, 5)(2, 2)(4, 3)(6, 4)(4, 1)(6, 2)(8, 3)"
                + "(6, 0)(8, 1)(10, 2)", g.toString());
    }

    @Test
    public void gridReturnsSortedArrayList() {
        Grid g = new Grid(4, 3);
        ArrayList<Cell> a = g.getCells();
        String s = "";
        for (Cell gridCell : a) {
            s += gridCell.toString();
        }
        assertEquals("(6, 0)(4, 1)(8, 1)(2, 2)(6, 2)(10, 2)(0, 3)(4, 3)(8, 3)"
                + "(2, 4)(6, 4)(4, 5)", s);

    }
}