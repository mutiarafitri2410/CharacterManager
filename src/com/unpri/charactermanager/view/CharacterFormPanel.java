
package com.unpri.charactermanager.view;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;



import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;

public class CharacterFormPanel extends JPanel {

    private JTextField nameField;
    private JComboBox<CharacterType> roleCombo;
    private JSpinner levelSpinner;

    private JLabel errorLabel;

    private Border originalNameBorder;

    private CharacterManager manager;
    private Runnable refreshCallback;

    public CharacterFormPanel(
            CharacterManager manager,
            Runnable refreshCallback) {

        this.manager = manager;
        this.refreshCallback = refreshCallback;

        initComponents();
    }

    private void initComponents() {

        setLayout(new GridBagLayout());
        setOpaque(true);
        setBackground(AppTheme.BACKGROUND_COLOR);
        setBorder(AppTheme.MAIN_BORDER);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel title = new JLabel("Tambah Karakter Baru");
        title.setFont(AppTheme.TITLE_FONT);
        title.setForeground(AppTheme.TEXT_COLOR);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(title, gbc);

        // Nama karakter
        gbc.gridwidth = 1;
        gbc.gridy++;

        add(new JLabel("Nama:"), gbc);

        nameField = new JTextField(18);
        originalNameBorder = nameField.getBorder();

        gbc.gridx = 1;
        add(nameField, gbc);

        // Role karakter
        gbc.gridx = 0;
        gbc.gridy++;

        add(new JLabel("Role:"), gbc);

        roleCombo = new JComboBox<>(CharacterType.values());

        gbc.gridx = 1;
        add(roleCombo, gbc);

        // Level karakter
        gbc.gridx = 0;
        gbc.gridy++;

        add(new JLabel("Level:"), gbc);

        levelSpinner = new JSpinner(
            new SpinnerNumberModel(1, 1, 99, 1)
        );

        gbc.gridx = 1;
        add(levelSpinner, gbc);

        // Pesan error
        errorLabel = new JLabel(" ");

        errorLabel.setForeground(Color.RED);
        errorLabel.setFont(AppTheme.BODY_FONT);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;

        add(errorLabel, gbc);

        // Tombol tambah
        JButton addButton = new JButton("Tambah Karakter");

        addButton.setFont(AppTheme.EMPHASIS_FONT);

        gbc.gridy++;
        add(addButton, gbc);

        addButton.addActionListener(e -> addCharacter());
    }

    // Validasi nama: kelengkapan, panjang, format, keunikan
    private String validateName(String name) {

        if (name.isEmpty()) {
            return "Nama karakter wajib diisi!";
        }

        if (name.length() > 30) {
            return "Nama maksimal 30 karakter!";
        }

        if (name.matches(".*\\s{2,}.*")) {
            return "Nama tidak boleh memiliki spasi ganda!";
        }

        if (manager.isNameTaken(name)) {
            return "Nama karakter sudah digunakan!";
        }

        return null;
    }

    private void addCharacter() {

        // Reset tampilan validasi
        errorLabel.setText(" ");
        nameField.setBorder(originalNameBorder);

        // Bersihkan input nama
        String name = nameField.getText().trim();

        // Validasi nama
        String validationMessage = validateName(name);

        if (validationMessage != null) {

            showNameError(validationMessage);
            return;
        }

        // Commit perubahan spinner sebelum mengambil nilai
        try {

            levelSpinner.commitEdit();

        } catch (java.text.ParseException ex) {

            showError("Level harus berupa angka yang valid!");
            levelSpinner.requestFocusInWindow();
            return;
        }

        CharacterType role =
            (CharacterType) roleCombo.getSelectedItem();

        int level =
            ((Number) levelSpinner.getValue()).intValue();

        // Membuat dan menyimpan karakter
        try {

            Character character =
                new Character(name, role, level);

            manager.addCharacter(character);

            // Berhasil
            errorLabel.setForeground(new Color(30, 130, 70));
            errorLabel.setText("Karakter berhasil ditambahkan!");

            nameField.setText("");
            levelSpinner.setValue(1);

            nameField.requestFocusInWindow();

            // Perbarui daftar pada MainWindow
            refreshCallback.run();

        } catch (IllegalArgumentException ex) {

            // Pesan dari Model langsung ditampilkan
            showError(ex.getMessage());
        }
    }

    private void showNameError(String message) {

        nameField.setBorder(
            BorderFactory.createLineBorder(Color.RED, 2)
        );

        showError(message);

        nameField.requestFocusInWindow();
    }

    private void showError(String message) {

        errorLabel.setForeground(Color.RED);
        errorLabel.setText(message);
    }
}
