/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

/**
 *
 * @author 41407
 */
public class GridCell {

    private int x;
    private int y;

    public GridCell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public GridCell() {
        this.x = 0;
        this.y = 0;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "x=" + x + ", y=" + y + "\n";
    }
}
