/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package randomGenerators;

import java.util.Random;

/**
 *
 * @author lassi
 */
public class WeaponNameGenerator {

    private static String[] startingNouns = {"Awesome", "Sweet ", "Super", "Mega", "Fire", "Ice", "Lightning" ,"Runed ", "Glistening "};
    private static String[] meleeWeaponNameEndingNouns = {"sledge", "axe", "hammer", "saber", "sickle", "mace", "sword"};
    private static String[] rangedWeaponNameEndingNouns = {"bow", "sling", "crossbow", "shotgun"};
    private static String[] adverbsAndEpicNouns = {"Grilling", "Crushing", "Smoldering", "Soul-searching", "Shoe-gazing", "Giants", "Gorgons", "Crabs", "Sloths", "Sleepiness"};
    private static Random random = new Random();

    public static String generateMeleeWeaponName() {
        return randomWordFromArray(startingNouns) + randomWordFromArray(meleeWeaponNameEndingNouns) + " of " + randomWordFromArray(adverbsAndEpicNouns);
    }

    public static String generateRangedWeaponName() {
        return randomWordFromArray(startingNouns) + randomWordFromArray(rangedWeaponNameEndingNouns) + " of " + randomWordFromArray(adverbsAndEpicNouns);
    }

    private static String randomWordFromArray(String[] array) {
        return array[random.nextInt(array.length)];
    }
}
