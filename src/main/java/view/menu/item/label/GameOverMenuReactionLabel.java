package main.java.view.menu.item.label;

import main.java.resources.menu.SizeCalculator;

import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Font;

import static main.java.resources.menu.MenuConstants.GAME_OVER_MENU_REACTION_LABEL_FONT_MULTIPLIER;
import static main.java.resources.menu.MenuTexts.GAME_OVER_MENU_REACTION_LABEL_TEXT_LEVEL_0;
import static main.java.resources.menu.MenuTexts.GAME_OVER_MENU_REACTION_LABEL_TEXT_LEVEL_1;
import static main.java.resources.menu.MenuTexts.GAME_OVER_MENU_REACTION_LABEL_TEXT_LEVEL_10;
import static main.java.resources.menu.MenuTexts.GAME_OVER_MENU_REACTION_LABEL_TEXT_LEVEL_2;
import static main.java.resources.menu.MenuTexts.GAME_OVER_MENU_REACTION_LABEL_TEXT_LEVEL_3;
import static main.java.resources.menu.MenuTexts.GAME_OVER_MENU_REACTION_LABEL_TEXT_LEVEL_4;
import static main.java.resources.menu.MenuTexts.GAME_OVER_MENU_REACTION_LABEL_TEXT_LEVEL_5;
import static main.java.resources.menu.MenuTexts.GAME_OVER_MENU_REACTION_LABEL_TEXT_LEVEL_6;
import static main.java.resources.menu.MenuTexts.GAME_OVER_MENU_REACTION_LABEL_TEXT_LEVEL_7;
import static main.java.resources.menu.MenuTexts.GAME_OVER_MENU_REACTION_LABEL_TEXT_LEVEL_8;
import static main.java.resources.menu.MenuTexts.GAME_OVER_MENU_REACTION_LABEL_TEXT_LEVEL_9;

public final class GameOverMenuReactionLabel extends JLabel {
    public GameOverMenuReactionLabel(Dimension windowDimension) {
        super();
        setHorizontalAlignment(CENTER);
        setFont(new Font(getFont().getFontName(), Font.BOLD,
                SizeCalculator.calculateSizeBasedOnWindowDimension(windowDimension,
                        GAME_OVER_MENU_REACTION_LABEL_FONT_MULTIPLIER)));
    }

    private static String getCorrespondingReactionText(double snakeLengthPercent) {
        int level = (int) (snakeLengthPercent / 10.0);
        return switch (level) {
            case 0 -> GAME_OVER_MENU_REACTION_LABEL_TEXT_LEVEL_0;
            case 1 -> GAME_OVER_MENU_REACTION_LABEL_TEXT_LEVEL_1;
            case 2 -> GAME_OVER_MENU_REACTION_LABEL_TEXT_LEVEL_2;
            case 3 -> GAME_OVER_MENU_REACTION_LABEL_TEXT_LEVEL_3;
            case 4 -> GAME_OVER_MENU_REACTION_LABEL_TEXT_LEVEL_4;
            case 5 -> GAME_OVER_MENU_REACTION_LABEL_TEXT_LEVEL_5;
            case 6 -> GAME_OVER_MENU_REACTION_LABEL_TEXT_LEVEL_6;
            case 7 -> GAME_OVER_MENU_REACTION_LABEL_TEXT_LEVEL_7;
            case 8 -> GAME_OVER_MENU_REACTION_LABEL_TEXT_LEVEL_8;
            case 9 -> GAME_OVER_MENU_REACTION_LABEL_TEXT_LEVEL_9;
            case 10 -> GAME_OVER_MENU_REACTION_LABEL_TEXT_LEVEL_10;
            default -> null;
        };
    }

    public void updateText(double snakeLengthPercent) {
        setText(getCorrespondingReactionText(snakeLengthPercent));
    }
}
