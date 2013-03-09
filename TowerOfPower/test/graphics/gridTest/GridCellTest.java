/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics.gridTest;

import graphics.grid.Cell;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 41407
 */
public class GridCellTest {

    public GridCellTest() {
    }

    @Test
    public void GridCellComparesRight() {
        Cell a = new Cell(10, 50);
        Cell b = new Cell(15, 100);
        Cell c = new Cell(20, 100);
        assertTrue("A should be less than B", a.compareTo(b) < 0);
        assertTrue("B should be more than A", b.compareTo(a) > 0);
        assertTrue("B should be equal to C", b.compareTo(c) == 0);
    }
}