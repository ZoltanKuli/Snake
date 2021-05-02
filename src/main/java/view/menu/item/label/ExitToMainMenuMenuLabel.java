package main.java.view.menu.item.label;

import main.java.resources.menu.SizeCalculator;

import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Font;

import static main.java.resources.menu.MenuConstants.EXIT_TO_MAIN_MENU_MENU_LABEL_FONT_MULTIPLIER;
import static main.java.resources.menu.MenuTexts.EXIT_TO_MAIN_MENU_MENU_LABEL_TEXT;

public final class ExitToMainMenuMenuLabel extends JLabel {
    public ExitToMainMenuMenuLabel(Dimension windowDimension) {
        super(EXIT_TO_MAIN_MENU_MENU_LABEL_TEXT);
        setHorizontalAlignment(CENTER);
        setFont(new Font(getFont().getFontName(), Font.BOLD,
                SizeCalculator.calculateSizeBasedOnWindowDimension(windowDimension,
                        EXIT_TO_MAIN_MENU_MENU_LABEL_FONT_MULTIPLIER)));
    }
}
