
package com.unpri.charactermanager.model;

import java.util.Objects;

public class Character {

    private String name;
    private CharacterType type;
    private int level;

    private static int totalCharacterCreated = 0;

    public Character(String name, CharacterType type, int level) {
        setName(name);
        setType(type);
        setLevel(level);

        totalCharacterCreated++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Nama karakter tidak boleh kosong!"
            );
        }

        String cleanName = name.trim();

        if (cleanName.length() > 30) {
            throw new IllegalArgumentException(
                "Nama karakter maksimal 30 karakter!"
            );
        }

        this.name = cleanName;
    }

    public CharacterType getType() {
        return type;
    }

    public void setType(CharacterType type) {
        if (type == null) {
            throw new IllegalArgumentException(
                "Role karakter harus dipilih!"
            );
        }

        this.type = type;

        // Validasi ulang level jika role berubah
        validateLevelForRole(this.level);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {

        if (level < 1 || level > 99) {
            throw new IllegalArgumentException(
                "Level harus berada antara 1 sampai 99!"
            );
        }

        validateLevelForRole(level);
        this.level = level;
    }

    // Mini-Challenge: MAGE maksimal level 60
    private void validateLevelForRole(int level) {

        if (type == CharacterType.MAGE && level > 60) {
            throw new IllegalArgumentException(
                "Karakter MAGE tidak boleh memiliki level di atas 60!"
            );
        }
    }

    public static int getTotalCharacterCreated() {
        return totalCharacterCreated;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Character other = (Character) obj;

        return name.equalsIgnoreCase(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase());
    }

    @Override
    public String toString() {
        return "Nama: " + name
                + " | Tipe: " + type
                + " | Level: " + level;
    }
}
