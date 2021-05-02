package main.java.view.menu.item.label;

import main.java.resources.menu.SizeCalculator;

import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Font;

import static main.java.resources.menu.MenuConstants.UNABLE_TO_LOAD_LEADERBOARD_RECORDS_LABEL_FONT_MULTIPLIER;
import static main.java.resources.menu.MenuTexts.UNABLE_TO_LOAD_LEADERBOARD_RECORDS;

public final class UnableToLoadLeaderboardRecords extends JLabel {
    public UnableToLoadLeaderboardRecords(Dimension windowDimension) {
        super(UNABLE_TO_LOAD_LEADERBOARD_RECORDS);
        setHorizontalAlignment(CENTER);
        setFont(new Font(getFont().getFontName(), Font.BOLD,
                SizeCalculator.calculateSizeBasedOnWindowDimension(windowDimension,
                        UNABLE_TO_LOAD_LEADERBOARD_RECORDS_LABEL_FONT_MULTIPLIER)));
    }
}
