
package com.unpri.charactermanager.model;

import java.util.ArrayList;

public class CharacterManager {

    private ArrayList<Character> characters;

    public CharacterManager() {
        characters = new ArrayList<>();
    }

    public void addCharacter(Character character) {

        if (character == null) {
            throw new IllegalArgumentException(
                "Karakter tidak boleh null!"
            );
        }

        if (isNameTaken(character.getName())) {
            throw new IllegalArgumentException(
                "Nama karakter sudah digunakan!"
            );
        }

        // Aturan tambahan: maksimal 20 karakter
        if (characters.size() >= 20) {
            throw new IllegalArgumentException(
                "Jumlah karakter maksimal 20!"
            );
        }

        characters.add(character);
    }

    public boolean isNameTaken(String name) {

        if (name == null) {
            return false;
        }

        String cleanName = name.trim();

        for (Character character : characters) {

            if (character.getName().equalsIgnoreCase(cleanName)) {
                return true;
            }
        }

        return false;
    }

    public ArrayList<Character> getAllCharacters() {
        return new ArrayList<>(characters);
    }

    public int getCharacterCount() {
        return characters.size();
    }
}
