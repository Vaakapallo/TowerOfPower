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
public class EquipmentNameGenerator {

    //THESE WILL ALL BE MOVED INTO TEXTFILES. Just trying out quick and dirty stuff now.
    /**
     * The Bottom Level is a nasty and dirty place.
     */
    private static String[] bottomLevelAdjectives = {"Shitty ", "Slimy ", "Glistening ", "Sticky ", "Brittle ", "Crappy ", "Sucky ", "Gross ", "Cracked ", "Slick ", "Rusty ", "Grimy ", "Dirty "};
    private static String[] bottomLevelMeleeWeaponNouns = {"Shank", "Hammer", "Rock", "Brick", "Keg", "Stick", "Sickle", "Mallet", "Piece", "Pipe"};
    private static String[] bottomLevelRangedWeaponHolders = {"Keg", "Jug", "Box", "Bag", "Pouch"};
    private static String[] bottomLevelMeleeWeaponEndingNouns = {"Muck", "Garbage", "Mud", "Beer", "Decay", "Maggots", "Shame", "Shit", "Shame"};
    private static String[] bottomLevelRangedWeaponAmmo = {"Garbage", "Bricks", "Maggots", "Roaches", "Plates", "Rocks"};
    private static String[] meleeWeaponNameEndingNouns = {"axe", "hammer", "saber", "sickle", "mace", "sword"};
    private static String[] rangedWeaponNameEndingNouns = {"bow", "sling", "crossbow", "shotgun"};
    private static Random random = new Random();
    
    public static String generateMeleeWeaponName() {
        return randomWordFromArray(bottomLevelAdjectives) + randomWordFromArray(bottomLevelMeleeWeaponNouns) + " of " + randomWordFromArray(bottomLevelMeleeWeaponEndingNouns);
    }
    
    public static String generateRangedWeaponName() {
        return randomWordFromArray(bottomLevelRangedWeaponHolders) + " of " + randomWordFromArray(bottomLevelAdjectives) + randomWordFromArray(bottomLevelRangedWeaponAmmo);
    }
    
    private static String randomWordFromArray(String[] array) {
        return array[random.nextInt(array.length)];
    }
}
