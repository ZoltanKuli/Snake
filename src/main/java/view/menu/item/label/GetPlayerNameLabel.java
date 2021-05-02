package main.java.view.menu.item.label;

import main.java.resources.menu.SizeCalculator;

import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Font;

import static main.java.resources.menu.MenuConstants.GET_PLAYER_NAME_LABEL_FONT_MULTIPLIER;
import static main.java.resources.menu.MenuTexts.GET_PLAYER_NAME_LABEL_TEXT;

public final class GetPlayerNameLabel extends JLabel {
    public GetPlayerNameLabel(Dimension windowDimension) {
        super(GET_PLAYER_NAME_LABEL_TEXT);
        setHorizontalAlignment(CENTER);
        setFont(new Font(getFont().getFontName(), Font.BOLD,
                SizeCalculator.calculateSizeBasedOnWindowDimension(windowDimension,
                        GET_PLAYER_NAME_LABEL_FONT_MULTIPLIER)));
    }
}
