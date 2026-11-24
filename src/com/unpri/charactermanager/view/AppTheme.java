
package com.unpri.charactermanager.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

import com.unpri.charactermanager.model.CharacterType;

public final class AppTheme {

    // Mencegah objek AppTheme dibuat
    private AppTheme() {
    }

    // ==============================
    // WARNA APLIKASI
    // ==============================

    public static final Color BACKGROUND_COLOR =
            new Color(245, 247, 250);

    public static final Color TEXT_COLOR =
            new Color(45, 52, 65);

    public static final Color GOLD_COLOR =
            new Color(184, 134, 11);

    public static final Color WARRIOR_COLOR =
            new Color(255, 228, 220);

    public static final Color MAGE_COLOR =
            new Color(225, 220, 255);

    public static final Color ARCHER_COLOR =
            new Color(220, 245, 225);

    public static final Color HEALER_COLOR =
            new Color(220, 240, 250);

    // ==============================
    // FONT APLIKASI
    // ==============================

    public static final Font TITLE_FONT =
            new Font(Font.SANS_SERIF, Font.BOLD, 22);

    public static final Font BODY_FONT =
            new Font(Font.SANS_SERIF, Font.PLAIN, 14);

    public static final Font EMPHASIS_FONT =
            new Font(Font.SANS_SERIF, Font.BOLD, 14);

    public static final Font HIGH_LEVEL_FONT =
            new Font(Font.SANS_SERIF, Font.BOLD, 16);

    // ==============================
    // BORDER APLIKASI
    // ==============================

    public static final Border MAIN_BORDER =
            BorderFactory.createEmptyBorder(20, 20, 20, 20);

    public static final Border WARRIOR_BORDER =
            BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(WARRIOR_COLOR.darker(), 2),
                    BorderFactory.createEmptyBorder(10, 12, 10, 12)
            );

    public static final Border MAGE_BORDER =
            BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(MAGE_COLOR.darker(), 2),
                    BorderFactory.createEmptyBorder(10, 12, 10, 12)
            );

    public static final Border ARCHER_BORDER =
            BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(ARCHER_COLOR.darker(), 2),
                    BorderFactory.createEmptyBorder(10, 12, 10, 12)
            );

    public static final Border HEALER_BORDER =
            BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(HEALER_COLOR.darker(), 2),
                    BorderFactory.createEmptyBorder(10, 12, 10, 12)
            );

    // ==============================
    // METHOD WARNA BERDASARKAN ROLE
    // ==============================

    public static Color colorFor(CharacterType role) {

        if (role == null) {
            return BACKGROUND_COLOR;
        }

        switch (role) {

            case WARRIOR:
                return WARRIOR_COLOR;

            case MAGE:
                return MAGE_COLOR;

            case ARCHER:
                return ARCHER_COLOR;

            case HEALER:
                return HEALER_COLOR;

            default:
                return BACKGROUND_COLOR;
        }
    }

    // ==============================
    // BORDER BERDASARKAN ROLE
    // ==============================

    public static Border borderFor(CharacterType role) {

        if (role == null) {
            return MAIN_BORDER;
        }

        switch (role) {

            case WARRIOR:
                return WARRIOR_BORDER;

            case MAGE:
                return MAGE_BORDER;

            case ARCHER:
                return ARCHER_BORDER;

            case HEALER:
                return HEALER_BORDER;

            default:
                return MAIN_BORDER;
        }
    }
}
