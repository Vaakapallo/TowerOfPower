/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package towerofpower;

import randomGenerators.WeaponNameGenerator;

/**
 *
 * @author lassi
 */
public class TowerOfPower {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(WeaponNameGenerator.generateMeleeWeaponName());
            System.out.println(WeaponNameGenerator.generateRangedWeaponName());
        }
    }
}