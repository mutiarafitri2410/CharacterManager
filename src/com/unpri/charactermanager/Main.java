
package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

public class Main {

    public static void main(String[] args) {

        // Membuat tiga karakter
        Character c1 = new Character("Aragorn", CharacterType.WARRIOR);
        Character c2 = new Character("Gandalf", CharacterType.MAGE, 3);
        Character c3 = new Character("Legolas", CharacterType.ARCHER, 2);

        // Menampilkan informasi karakter
        System.out.println("===== CHARACTER MANAGER =====");
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

        // Demonstrasi level up
        System.out.println("\n===== DEMO LEVEL UP =====");

        System.out.println("Sebelum level up:");
        System.out.println(c1);

        c1.levelUp();

        System.out.println("Setelah level up:");
        System.out.println(c1);

        // Mini-Challenge
        System.out.println("\n===== MINI-CHALLENGE =====");

        Character c4 = new Character("Dara", CharacterType.HEALER, 2);

        c4.setMana(80);

        System.out.println(c4);

        System.out.println("Dara masih hidup: " + c4.isAlive());
    }
}
