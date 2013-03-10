/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics.grid;

import logic.Location;
import logic.level.CellContent;
import randomGenerators.RandomInteger;

/**
 *
 * @author 41407
 */
public class Cell extends Location implements Comparable<Cell> {

    private boolean visible;
    private boolean accessible;
    private CellContent content;
    private int height;
    private int tileVariant;

    public Cell(int x, int y) {
        super(x, y);
        this.visible = true;
        this.accessible = false;
        this.content = null;
        this.tileVariant = RandomInteger.getRandom();
    }

    public void setVisibility(boolean visible) {
        this.visible = visible;
        this.accessible = false;
    }

    public boolean isVisible() {
        return visible;
    }

    @Override
    public int compareTo(Cell cell) {
        return this.getY() - cell.getY();
    }

    public void setContent(CellContent c) {
        this.content = c;
    }

    public CellContent getContent() {
        return content;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
