
package com.unpri.charactermanager.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;

public class MainWindow extends JFrame {

    private CharacterManager manager;

    private JPanel mainPanel;
    private JPanel listPanel;

    private JLabel averageLabel;
    private JScrollPane scrollPane;

    public MainWindow(CharacterManager manager) {

        super("Character Manager v0.6");

        this.manager = manager;

        initComponents();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pack();
        setLocationRelativeTo(null);
    }

    private void initComponents() {

        mainPanel = new JPanel(new BorderLayout(10, 15));

        mainPanel.setBackground(AppTheme.BACKGROUND_COLOR);
        mainPanel.setBorder(AppTheme.MAIN_BORDER);

        // Judul
        JLabel titleLabel = new JLabel("CHARACTER MANAGER");

        titleLabel.setFont(AppTheme.TITLE_FONT);
        titleLabel.setForeground(AppTheme.TEXT_COLOR);

        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Form input karakter
        CharacterFormPanel formPanel =
            new CharacterFormPanel(manager, this::refreshList);

        mainPanel.add(formPanel, BorderLayout.WEST);

        // Daftar karakter
        listPanel = new JPanel();

        listPanel.setLayout(
            new BoxLayout(listPanel, BoxLayout.Y_AXIS)
        );

        listPanel.setBackground(AppTheme.BACKGROUND_COLOR);

        scrollPane = new JScrollPane(listPanel);

        scrollPane.setPreferredSize(new Dimension(380, 350));

        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Statistik
        averageLabel = new JLabel();

        averageLabel.setFont(AppTheme.EMPHASIS_FONT);
        averageLabel.setForeground(AppTheme.TEXT_COLOR);

        mainPanel.add(averageLabel, BorderLayout.SOUTH);

        setContentPane(mainPanel);

        refreshList();
    }

    // Memperbarui daftar karakter
    public void refreshList() {

        listPanel.removeAll();

        ArrayList<Character> characters =
            manager.getAllCharacters();

        int totalLevel = 0;

        for (Character character : characters) {

            JPanel card = new JPanel(new BorderLayout(10, 5));

            card.setOpaque(true);

            card.setBackground(
                AppTheme.colorFor(character.getType())
            );

            card.setBorder(
                AppTheme.borderFor(character.getType())
            );

            JLabel nameLabel =
                new JLabel(character.getName());

            nameLabel.setFont(AppTheme.EMPHASIS_FONT);

            JLabel infoLabel = new JLabel(
                "Role: " + character.getType()
                + " | Level: " + character.getLevel()
            );

            infoLabel.setFont(AppTheme.BODY_FONT);

            card.add(nameLabel, BorderLayout.NORTH);
            card.add(infoLabel, BorderLayout.CENTER);

            card.setToolTipText(
                "Nama: " + character.getName()
                + ", Role: " + character.getType()
                + ", Level: " + character.getLevel()
            );

            listPanel.add(card);

            listPanel.add(
                Box.createVerticalStrut(8)
            );

            totalLevel += character.getLevel();
        }

        double average = characters.isEmpty()
            ? 0.0
            : (double) totalLevel / characters.size();

        averageLabel.setText(
            String.format(
                "Total Karakter: %d | Rata-rata Level: %.2f",
                characters.size(),
                average
            )
        );

        listPanel.revalidate();
        listPanel.repaint();

        mainPanel.revalidate();
        mainPanel.repaint();

        pack();
    }
}
