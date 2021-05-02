package main.java.view.menu.item.button;

import main.java.resources.menu.SizeCalculator;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import static main.java.resources.menu.MenuConstants.MENU_BUTTON_BACKGROUND_ALPHA_VALUE;
import static main.java.resources.menu.MenuConstants.MENU_BUTTON_FONT_MULTIPLIER;

class MenuButton extends JButton {
    protected MenuButton(String text, Dimension windowDimension, Dimension dimension) {
        super(text);
        setPreferredSize(dimension);
        setAesthetic();
        setStyle(windowDimension);
    }

    private void setAesthetic() {
        setDefaultCapable(false);
        setFocusPainted(false);
        setBorderPainted(false);
    }

    private void setStyle(Dimension windowDimension) {
        setBackground(new Color(getBackground().getRed(), getBackground().getGreen(),
                getBackground().getBlue(), MENU_BUTTON_BACKGROUND_ALPHA_VALUE));
        setFont(new Font(getFont().getFontName(), Font.BOLD,
                SizeCalculator.calculateSizeBasedOnWindowDimension(windowDimension,
                        MENU_BUTTON_FONT_MULTIPLIER)));
    }
}
