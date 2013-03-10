/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.level;

import filehandling.FileReader;
import java.util.ArrayList;

/**
 *
 * @author 41407
 */
public class ParseLevel {

    Level l;

    public ParseLevel(String level) {
        FileReader reader = new FileReader("src/level0");
        parseLines(reader.getRivit());
    }

    public Level getL() {
        return l;
    }

    private void parseLines(ArrayList<String> rivit) {
        int levelNumber = 0,
                xMargin = 100,
                yMargin = 100,
                cellSize = 54,
                xDimension = 10,
                yDimension = 10;
        String[] current;
        for (String string : rivit) {
            current = string.split(":");
            switch (current[0]) {
                case "levelNumber":
                    levelNumber = Integer.parseInt(current[1]);
                    break;
                case "xMargin":
                    xMargin = Integer.parseInt(current[1]);
                    break;
                case "yMargin":
                    yMargin = Integer.parseInt(current[1]);
                    break;
                case "cellSize":
                    cellSize = Integer.parseInt(current[1]);
                    break;
                case "xDimension":
                    xDimension = Integer.parseInt(current[1]);
                    break;
                case "yDimension":
                    yDimension = Integer.parseInt(current[1]);
                    break;
            }
        }
        l = new Level(levelNumber, xDimension, yDimension, cellSize,
                xMargin, yMargin);
    }
}
