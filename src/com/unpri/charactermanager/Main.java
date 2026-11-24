
package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.view.MainWindow;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        CharacterManager manager = new CharacterManager();

        manager.addCharacter(new Character("Arjuna", CharacterType.WARRIOR, 15));
        manager.addCharacter(new Character("Merlin", CharacterType.MAGE, 25));
        manager.addCharacter(new Character("Athena", CharacterType.ARCHER, 20));
        manager.addCharacter(new Character("Luna", CharacterType.HEALER, 18));
        manager.addCharacter(new Character("Hercules", CharacterType.WARRIOR, 35));
        manager.addCharacter(new Character("Gandalf", CharacterType.MAGE, 40));
        manager.addCharacter(new Character("Srikandi", CharacterType.ARCHER, 30));
        manager.addCharacter(new Character("Aurora", CharacterType.HEALER, 22));

        SwingUtilities.invokeLater(() -> {
            MainWindow window = new MainWindow(manager);
            window.setVisible(true);
        });
    }
}
