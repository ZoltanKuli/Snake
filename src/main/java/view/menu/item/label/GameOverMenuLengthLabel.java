package main.java.view.menu.item.label;

import main.java.resources.menu.SizeCalculator;

import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Font;

import static main.java.resources.menu.MenuConstants.GAME_OVER_MENU_LENGTH_LABEL_FONT_MULTIPLIER;
import static main.java.resources.menu.MenuTexts.GAME_OVER_MENU_LENGTH_LABEL_TEXT_ABOVE_LEVEL_3;
import static main.java.resources.menu.MenuTexts.GAME_OVER_MENU_LENGTH_LABEL_TEXT_UNTIL_LEVEL_3;

public final class GameOverMenuLengthLabel extends JLabel {
    public GameOverMenuLengthLabel(Dimension windowDimension) {
        super();
        setHorizontalAlignment(CENTER);
        setFont(new Font(getFont().getFontName(), Font.BOLD,
                SizeCalculator.calculateSizeBasedOnWindowDimension(windowDimension,
                        GAME_OVER_MENU_LENGTH_LABEL_FONT_MULTIPLIER)));
    }

    public void updateText(double snakeLengthPercent) {
        if (snakeLengthPercent / 10.0 < 4.0) {
            setText(String.format(beautifyNumberFormattingInText(GAME_OVER_MENU_LENGTH_LABEL_TEXT_UNTIL_LEVEL_3,
                    snakeLengthPercent), snakeLengthPercent));
        } else {
            setText(String.format(beautifyNumberFormattingInText(GAME_OVER_MENU_LENGTH_LABEL_TEXT_ABOVE_LEVEL_3,
                    snakeLengthPercent), snakeLengthPercent));
        }
    }

    private String beautifyNumberFormattingInText(String text, double snakeLengthPercent) {
        if (snakeLengthPercent % 1.0 == 0) {
            return text.replace("%.2f", "%.0f");
        } else if ((int) (snakeLengthPercent * 100.0) / 10.0 % 1.0 == 0) {
            return text.replace("%.2f", "%.1f");
        }

        return text;
    }
}
