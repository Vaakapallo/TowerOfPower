/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package randomGenerators;

import java.util.Random;

/**
 *
 * @author 41407
 */
public class RandomInteger {

    private static Random random = new Random();

    /**
     * Just calls random.nextInt() with the given parameter.
     *
     * Saves us from generating Random-objects everywhere.
     *
     * @param range
     * @return
     */
    public static int getRandomInt(int range) {
        return random.nextInt(range);
    }
    
    public static double getRandomDouble(double range) {
        return random.nextDouble(range);
    }
    
    public static int getRandom() {
        return getRandomInt(Integer.MAX_VALUE);
    }
}
