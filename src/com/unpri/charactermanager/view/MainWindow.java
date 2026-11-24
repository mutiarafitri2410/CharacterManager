
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class MainWindow extends JFrame {

    private final CharacterManager manager;

    private JPanel characterGrid;
    private JPanel statsPanel;
    private JLabel totalLabel;
    private JLabel averageLabel;
    private JLabel highestLabel;
    private JLabel lowestLabel;

    public MainWindow(CharacterManager manager) {
        this.manager = manager;

        setTitle("Character Manager - Sprint #5");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(12, 12));
        getContentPane().setBackground(AppTheme.BACKGROUND_COLOR);

        add(createNorthPanel(), BorderLayout.NORTH);
        add(createCharacterScrollPane(), BorderLayout.CENTER);
        add(createLegendPanel(), BorderLayout.EAST);
        add(createStatusBar(), BorderLayout.SOUTH);

        refreshList();

        setMinimumSize(new Dimension(700, 500));
        pack();
        setLocationRelativeTo(null);
    }

    // NORTH: header dan panel statistik
    private JPanel createNorthPanel() {
        JPanel northPanel = new JPanel(new BorderLayout(8, 8));
        northPanel.setBackground(AppTheme.BACKGROUND_COLOR);
        northPanel.setBorder(new EmptyBorder(15, 15, 5, 15));

        JLabel titleLabel = new JLabel("CHARACTER MANAGER");
        titleLabel.setFont(AppTheme.TITLE_FONT);
        titleLabel.setForeground(AppTheme.GOLD_COLOR);

        JLabel subtitleLabel = new JLabel(
                "Kelola karakter, role, dan level dengan mudah"
        );
        subtitleLabel.setFont(AppTheme.BODY_FONT);
        subtitleLabel.setForeground(AppTheme.TEXT_COLOR);

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        titlePanel.setBackground(AppTheme.BACKGROUND_COLOR);
        titlePanel.add(titleLabel);
        titlePanel.add(Box.createVerticalStrut(5));
        titlePanel.add(subtitleLabel);

        northPanel.add(titlePanel, BorderLayout.NORTH);
        northPanel.add(createStatsPanel(), BorderLayout.SOUTH);

        return northPanel;
    }

    // Panel tambahan: GridLayout 2 x 2
    private JPanel createStatsPanel() {
        statsPanel = new JPanel(new GridLayout(2, 2, 10, 5));
        statsPanel.setBackground(AppTheme.BACKGROUND_COLOR);
        statsPanel.setBorder(new EmptyBorder(10, 0, 5, 0));

        totalLabel = createStatLabel("Total karakter: 0");
        averageLabel = createStatLabel("Rata-rata level: 0");
        highestLabel = createStatLabel("Level tertinggi: 0");
        lowestLabel = createStatLabel("Level terendah: 0");

        statsPanel.add(totalLabel);
        statsPanel.add(averageLabel);
        statsPanel.add(highestLabel);
        statsPanel.add(lowestLabel);

        return statsPanel;
    }

    private JLabel createStatLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(AppTheme.EMPHASIS_FONT);
        label.setForeground(AppTheme.TEXT_COLOR);
        label.setBorder(new EmptyBorder(7, 10, 7, 10));
        return label;
    }

    // CENTER: JScrollPane berisi panel pembungkus
    private JScrollPane createCharacterScrollPane() {
        JPanel wrapperPanel = new JPanel(new BorderLayout());
        wrapperPanel.setBackground(AppTheme.BACKGROUND_COLOR);
        wrapperPanel.setBorder(new EmptyBorder(10, 15, 10, 10));

        characterGrid = new JPanel(new GridLayout(0, 2, 12, 12));
        characterGrid.setBackground(AppTheme.BACKGROUND_COLOR);

        // Grid kartu ditempatkan di NORTH panel pembungkus
        wrapperPanel.add(characterGrid, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(wrapperPanel);
        scrollPane.setPreferredSize(new Dimension(600, 380));
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        return scrollPane;
    }

    // EAST: legenda dibuat dari CharacterType.values()
    private JPanel createLegendPanel() {
        JPanel legendPanel = new JPanel();
        legendPanel.setLayout(new BoxLayout(legendPanel, BoxLayout.Y_AXIS));
        legendPanel.setBackground(AppTheme.BACKGROUND_COLOR);
        legendPanel.setBorder(new EmptyBorder(15, 10, 15, 15));

        JLabel legendTitle = new JLabel("LEGENDA ROLE");
        legendTitle.setFont(AppTheme.EMPHASIS_FONT);
        legendTitle.setForeground(AppTheme.GOLD_COLOR);
        legendTitle.setAlignmentX(Component.LEFT_ALIGNMENT);

        legendPanel.add(legendTitle);
        legendPanel.add(Box.createVerticalStrut(15));

        for (CharacterType type : CharacterType.values()) {
            JLabel roleLabel = new JLabel("●  " + type.name());
            roleLabel.setFont(AppTheme.BODY_FONT);
            roleLabel.setForeground(AppTheme.colorFor(type));
            roleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

            legendPanel.add(roleLabel);
            legendPanel.add(Box.createVerticalStrut(12));
        }

        legendPanel.add(Box.createVerticalGlue());
        legendPanel.setPreferredSize(new Dimension(150, 250));

        return legendPanel;
    }

    // SOUTH: teks kiri dan versi kanan
    private JPanel createStatusBar() {
        JPanel statusPanel = new JPanel(new BorderLayout());
        statusPanel.setBackground(AppTheme.BACKGROUND_COLOR);
        statusPanel.setBorder(new EmptyBorder(8, 15, 10, 15));

        JLabel statusText = new JLabel("Character Manager | Siap digunakan");
        statusText.setFont(AppTheme.BODY_FONT);
        statusText.setForeground(AppTheme.TEXT_COLOR);

        JLabel versionText = new JLabel("v0.5");
        versionText.setFont(AppTheme.EMPHASIS_FONT);
        versionText.setForeground(AppTheme.GOLD_COLOR);

        statusPanel.add(statusText, BorderLayout.WEST);
        statusPanel.add(versionText, BorderLayout.EAST);

        return statusPanel;
    }

    // Memperbarui kartu dan statistik
    public void refreshList() {
        ArrayList<Character> characters = manager.getAllCharacters();

        characterGrid.removeAll();

        int totalLevel = 0;
        int highestLevel = 0;
        int lowestLevel = characters.isEmpty() ? 0 : Integer.MAX_VALUE;

        for (Character character : characters) {
            characterGrid.add(createCharacterCard(character));

            int level = character.getLevel();
            totalLevel += level;
            highestLevel = Math.max(highestLevel, level);
            lowestLevel = Math.min(lowestLevel, level);
        }

        int total = characters.size();
        double average = total == 0 ? 0 : (double) totalLevel / total;

        totalLabel.setText("Total karakter: " + total);
        averageLabel.setText(String.format("Rata-rata level: %.2f", average));
        highestLabel.setText("Level tertinggi: " + highestLevel);
        lowestLabel.setText("Level terendah: " + lowestLevel);

        characterGrid.revalidate();
        characterGrid.repaint();

        statsPanel.revalidate();
        statsPanel.repaint();
    }

    private JPanel createCharacterCard(Character character) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(AppTheme.BACKGROUND_COLOR);
        card.setBorder(AppTheme.borderFor(character.getType()));
        card.setPreferredSize(new Dimension(220, 100));
        card.setBorder(BorderFactory.createCompoundBorder(
                AppTheme.borderFor(character.getType()),
                new EmptyBorder(10, 12, 10, 12)
        ));

        JLabel nameLabel = new JLabel(character.getName());
        nameLabel.setFont(AppTheme.EMPHASIS_FONT);
        nameLabel.setForeground(AppTheme.GOLD_COLOR);

        JLabel roleLabel = new JLabel("Role: " + character.getType());
        roleLabel.setFont(AppTheme.BODY_FONT);
        roleLabel.setForeground(AppTheme.colorFor(character.getType()));

        JLabel levelLabel = new JLabel("Level: " + character.getLevel());
        levelLabel.setFont(AppTheme.BODY_FONT);
        levelLabel.setForeground(AppTheme.TEXT_COLOR);

        card.add(nameLabel);
        card.add(Box.createVerticalStrut(5));
        card.add(roleLabel);
        card.add(levelLabel);

        return card;
    }
}
