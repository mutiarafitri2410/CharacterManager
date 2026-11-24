
package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        CharacterManager manager = new CharacterManager();

        System.out.println("==================================");
        System.out.println(" CHARACTER MANAGER SPRINT #2");
        System.out.println("==================================");

        // MEMBUAT DATA KARAKTER
        Character c1 = new Character(
            "Aragorn", CharacterType.WARRIOR, 85
        );

        Character c2 = new Character(
            "Gandalf", CharacterType.MAGE, 95
        );

        Character c3 = new Character(
            "Legolas", CharacterType.ARCHER, 80
        );

        Character c4 = new Character(
            "Merlin", CharacterType.MAGE, 90
        );

        Character c5 = new Character(
            "Dara", CharacterType.HEALER, 75
        );

        Character c6 = new Character(
            "Gorn", CharacterType.WARRIOR, 70
        );

        // BAGIAN A: ADD CHARACTER
        System.out.println("\n--- A. ADD CHARACTER ---");

        manager.addCharacter(c1);
        manager.addCharacter(c2);
        manager.addCharacter(c3);
        manager.addCharacter(c4);
        manager.addCharacter(c5);
        manager.addCharacter(c6);

        for (Character c : manager.getAllCharacters()) {
            System.out.println(c);
        }

        // UJI DUPLIKAT
        System.out.println("\n--- UJI DUPLIKAT ---");

        Character duplicate = new Character(
            "Aragorn", CharacterType.MAGE, 50
        );

        boolean duplicateResult = manager.addCharacter(duplicate);

        System.out.println("Berhasil ditambahkan: " + duplicateResult);
        System.out.println("Total karakter: "
                + manager.getTotalCharacters());

        // FIND BY NAME
        System.out.println("\n--- FIND BY NAME ---");

        Character found = manager.findByName("Gandalf");

        System.out.println(
            found != null ? found : "Karakter tidak ditemukan."
        );

        // REMOVE CHARACTER
        System.out.println("\n--- REMOVE CHARACTER ---");

        System.out.println(
            "Berhasil dihapus: " + manager.removeCharacter("Gorn")
        );

        System.out.println(
            "Total setelah hapus: " + manager.getTotalCharacters()
        );

        // BAGIAN B: AVERAGE LEVEL
        System.out.println("\n--- B. AVERAGE LEVEL ---");

        System.out.println(
            "Rata-rata level: " + manager.getAverageLevel()
        );

        // UJI EMPTY LIST
        CharacterManager emptyManager = new CharacterManager();

        System.out.println(
            "Rata-rata list kosong: "
            + emptyManager.getAverageLevel()
        );

        // FIND BY TYPE
        System.out.println("\n--- FIND BY TYPE: MAGE ---");

        ArrayList<Character> mages =
                manager.findByType(CharacterType.MAGE);

        for (Character mage : mages) {
            System.out.println(mage);
        }

        // BAGIAN C: FIND STRONGEST
        System.out.println("\n--- C. FIND STRONGEST ---");

        Character strongest = manager.findStrongest();

        if (strongest != null) {
            System.out.println("Karakter terkuat:");
            System.out.println(strongest);
        }

        // BAGIAN A: UJI DEFENSIVE COPY
        System.out.println("\n--- UJI DEFENSIVE COPY ---");

        ArrayList<Character> copy = manager.getAllCharacters();

        System.out.println("Jumlah sebelum copy.clear(): "
                + manager.getTotalCharacters());

        copy.clear();

        System.out.println("Jumlah data di copy setelah clear(): "
                + copy.size());

        System.out.println("Jumlah asli setelah copy.clear(): "
                + manager.getTotalCharacters());

        // UJI REFERENCE
        System.out.println("\n--- UJI REFERENCE ---");

        Character a = new Character(
            "ReferenceA", CharacterType.WARRIOR, 5
        );

        Character b = a;

        b.setLevel(8);

        System.out.println("Level a: " + a.getLevel());
        System.out.println("a == b: " + (a == b));

        // MEMBUAT OBJEK INDEPENDEN
        Character independent = new Character(
            a.getName(), a.getType(), a.getLevel()
        );

        independent.setLevel(20);

        System.out.println("Level a: " + a.getLevel());
        System.out.println("Level independent: "
                + independent.getLevel());

        // UJI EQUALS
        System.out.println("\n--- UJI EQUALS ---");

        Character test1 = new Character(
            "Hero", CharacterType.MAGE, 10
        );

        Character test2 = new Character(
            "hero", CharacterType.ARCHER, 30
        );

        System.out.println(
            "Nama sama menurut equals(): " + test1.equals(test2)
        );

        // STATIC COUNTER
        System.out.println("\n--- STATIC COUNTER ---");

        System.out.println(
            "Total objek Character dibuat: "
            + Character.getTotalCharacterCreated()
        );

        System.out.println("\n==================================");
        System.out.println(" PROGRAM SELESAI");
        System.out.println("==================================");
    }
}
