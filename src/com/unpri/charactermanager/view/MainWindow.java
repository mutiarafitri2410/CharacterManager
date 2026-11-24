
package com.unpri.charactermanager.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.util.ArrayList;

import com.unpri.charactermanager.model.Character;

public class MainWindow extends JFrame {

    private JPanel mainPanel;
    private ArrayList<Character> characterList;
    private JLabel averageLabel;

    public MainWindow(ArrayList<Character> characterList) {
        super("Character Manager v0.3");

        this.characterList = characterList;

        initComponents();

        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initComponents() {

        mainPanel = new JPanel(new BorderLayout(10, 15));

        mainPanel.setBorder(
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        );

        // Judul
        JLabel titleLabel = new JLabel("CHARACTER MANAGER");

        titleLabel.setFont(
            new Font("Arial", Font.BOLD, 22)
        );

        titleLabel.setForeground(
            new Color(40, 70, 120)
        );

        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Panel daftar karakter
        JPanel listPanel = new JPanel();

        listPanel.setLayout(
            new BoxLayout(listPanel, BoxLayout.Y_AXIS)
        );

        // Menampilkan data secara dinamis
        int totalLevel = 0;

        for (Character character : characterList) {

            JLabel characterLabel = new JLabel(
                "<html><b>" + character.getName() + "</b>"
                + "<br>Tipe: " + character.getType()
                + "<br>Level: " + character.getLevel()
                + "</html>"
            );

            characterLabel.setFont(
                new Font("Arial", Font.PLAIN, 14)
            );

            characterLabel.setBorder(
                BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.LIGHT_GRAY),
                    BorderFactory.createEmptyBorder(10, 10, 10, 10)
                )
            );

            characterLabel.setAlignmentX(LEFT_ALIGNMENT);

            listPanel.add(characterLabel);

            listPanel.add(
                javax.swing.Box.createVerticalStrut(10)
            );

            totalLevel += character.getLevel();
        }

        // Menghitung rata-rata level
        double average = characterList.isEmpty()
            ? 0.0
            : (double) totalLevel / characterList.size();

        // Panel statistik
        averageLabel = new JLabel(
            String.format("Rata-rata Level: %.2f", average)
        );

        averageLabel.setFont(
            new Font("Arial", Font.BOLD, 16)
        );

        averageLabel.setForeground(
            new Color(30, 120, 70)
        );

        averageLabel.setBorder(
            BorderFactory.createEmptyBorder(10, 0, 0, 0)
        );

        // Scroll daftar karakter
        JScrollPane scrollPane = new JScrollPane(listPanel);

        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Statistik di bagian bawah
        mainPanel.add(averageLabel, BorderLayout.SOUTH);

        setContentPane(mainPanel);
    }
}
