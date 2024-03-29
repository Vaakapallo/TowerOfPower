/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package randomGenerators;

/**
 *
 * @author lassi
 */
public class EquipmentNameGenerator {

    //THESE WILL ALL BE MOVED INTO TEXTFILES. Just trying out quick and dirty stuff now.
    /**
     * The Bottom Level is a nasty and dirty place.
     * 
     * Sock filled with garbage. Make the generation more adaptive and less wordy.
     */
    private static String[] bottomLevelAdjectives = {"Shitty ", "Slimy ", "Glistening ", "Sticky ", "Brittle ", "Crappy ", "Sucky ", "Gross ", "Cracked ", "Slick ", "Rusty ", "Grimy ", "Dirty ", "Gnarly " , "Nasty ", "Bloody ", "Greasy "};
    private static String[] bottomLevelMeleeWeaponNouns = {"Shank", "Hammer", "Rock", "Brick", "Keg", "Stick", "Sickle", "Mallet", "Piece", "Pipe", "Spoon"};
    private static String[] bottomLevelRangedWeaponHolders = {"Keg", "Jug", "Box", "Bag", "Pouch", "Barrel"};
    private static String[] bottomLevelMeleeWeaponEndingNouns = {"Muck", "Garbage", "Mud", "Beer", "Decay", "Maggots", "Shame", "Shit"};
    private static String[] bottomLevelRangedWeaponAmmo = {"Garbage", "Bricks", "Maggots", "Roaches", "Plates", "Rocks", "Spiders" , "Goo", "Doorknobs", "Nails"};
    private static String[] meleeWeaponNameEndingNouns = {"axe", "hammer", "saber", "sickle", "mace", "sword"};
    private static String[] rangedWeaponNameEndingNouns = {"bow", "sling", "crossbow", "shotgun"};

    public static String generateMeleeWeaponName() {
        return randomWordFromArray(bottomLevelAdjectives) + randomWordFromArray(bottomLevelMeleeWeaponNouns) + " of " + randomWordFromArray(bottomLevelMeleeWeaponEndingNouns);
    }

    public static String generateRangedWeaponName() {
        return randomWordFromArray(bottomLevelRangedWeaponHolders) + " of " + randomWordFromArray(bottomLevelAdjectives) + randomWordFromArray(bottomLevelRangedWeaponAmmo);
    }

    private static String randomWordFromArray(String[] array) {
        return array[RandomInteger.getRandomInt(array.length)];
    }
}
