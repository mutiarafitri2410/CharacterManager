
package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

import java.util.ArrayList;

public class CharacterManager {

    private final ArrayList<Character> characters;

    public CharacterManager() {
        characters = new ArrayList<>();
    }

    // BAGIAN A: Menambahkan karakter
    public boolean addCharacter(Character character) {

        if (character == null) {
            return false;
        }

        if (findByName(character.getName()) != null) {
            System.out.println(
                "Gagal! Nama " + character.getName()
                + " sudah terdaftar."
            );
            return false;
        }

        characters.add(character);
        return true;
    }

    // BAGIAN A: Mencari berdasarkan nama
    public Character findByName(String name) {

        if (name == null) {
            return null;
        }

        for (Character character : characters) {
            if (character.getName().equalsIgnoreCase(name.trim())) {
                return character;
            }
        }

        return null;
    }

    // BAGIAN A: Menghapus karakter
    public boolean removeCharacter(String name) {

        Character character = findByName(name);

        if (character == null) {
            return false;
        }

        characters.remove(character);
        return true;
    }

    // BAGIAN A: Menghitung karakter dalam manager
    public int getTotalCharacters() {
        return characters.size();
    }

    // BAGIAN A: Mengembalikan salinan ArrayList
    public ArrayList<Character> getAllCharacters() {
        return new ArrayList<>(characters);
    }

    // BAGIAN B: Menghitung rata-rata level
    public double getAverageLevel() {

        if (characters.isEmpty()) {
            return 0.0;
        }

        int totalLevel = 0;

        for (Character character : characters) {
            totalLevel += character.getLevel();
        }

        return (double) totalLevel / characters.size();
    }

    // BAGIAN B: Mencari seluruh karakter berdasarkan tipe
    public ArrayList<Character> findByType(CharacterType type) {

        ArrayList<Character> result = new ArrayList<>();

        if (type == null) {
            return result;
        }

        for (Character character : characters) {
            if (character.getType() == type) {
                result.add(character);
            }
        }

        return result;
    }

    /**
     * Mencari karakter dengan level tertinggi.
     * Jika level sama, karakter pertama yang ditemukan dikembalikan.
     * @return karakter dengan level tertinggi atau null jika kosong.
     */
    public Character findStrongest() {

        if (characters.isEmpty()) {
            return null;
        }

        Character strongest = characters.get(0);

        for (Character character : characters) {
            if (character.getLevel() > strongest.getLevel()) {
                strongest = character;
            }
        }

        return strongest;
    }
}
