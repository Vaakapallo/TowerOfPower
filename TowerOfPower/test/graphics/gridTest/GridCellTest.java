/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics.gridTest;

import graphics.grid.GridCell;
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
        GridCell a = new GridCell(10, 50);
        GridCell b = new GridCell(15, 100);
        GridCell c = new GridCell(20, 100);
        assertTrue("A should be less than B", a.compareTo(b) < 0);
        assertTrue("B should be more than A", b.compareTo(a) > 0);
        assertTrue("B should be equal to C", b.compareTo(c) == 0);
    }
}