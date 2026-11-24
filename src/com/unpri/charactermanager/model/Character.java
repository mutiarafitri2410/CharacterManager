package com.unpri.charactermanager.model;

public class Character {

    // Atribut karakter
    private String name;
    private CharacterType type;
    private int level;
    private int hitPoints;
    private int attack;
    private int mana;

    // Constructor pertama: level default 1
    public Character(String name, CharacterType type) {
        this(name, type, 1);
    }

    // Constructor kedua: level dapat ditentukan
    public Character(String name, CharacterType type, int level) {
        this.name = name;
        this.type = type;
        setLevel(level);
        this.mana = 0;
    }

    // Getter name
    public String getName() {
        return name;
    }

    // Setter name
    public void setName(String name) {
        this.name = name;
    }

    // Getter type
    public CharacterType getType() {
        return type;
    }

    // Setter type
    public void setType(CharacterType type) {
        this.type = type;
    }

    // Getter level
    public int getLevel() {
        return level;
    }

    // Setter level dengan validasi dan perhitungan HP serta attack
    public void setLevel(int level) {
        if (level < 1) {
            throw new IllegalArgumentException("Level harus minimal 1.");
        }

        this.level = level;
        this.hitPoints = level * 100;
        this.attack = level * 10;
    }

    // Getter hitPoints
    public int getHitPoints() {
        return hitPoints;
    }

    // Getter attack
    public int getAttack() {
        return attack;
    }

    // Getter mana
    public int getMana() {
        return mana;
    }

    // Setter mana dengan validasi
    public void setMana(int mana) {
        if (mana < 0) {
            throw new IllegalArgumentException("Mana tidak boleh negatif.");
        }

        this.mana = mana;
    }

    // Mengecek apakah karakter masih hidup
    public boolean isAlive() {
        return hitPoints > 0;
    }

    // Method untuk meningkatkan level
    public void levelUp() {
        setLevel(level + 1);
    }

    // Menampilkan informasi karakter
    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", level=" + level +
                ", hitPoints=" + hitPoints +
                ", attack=" + attack +
                ", mana=" + mana +
                ", alive=" + isAlive() +
                '}';
    }
 {
 }
}
