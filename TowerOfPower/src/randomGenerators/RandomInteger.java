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
    public static int getRandom() {
        Random random = new Random();
        return random.nextInt(20000);
    }
}
