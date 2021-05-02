package main.java.view.menu.item.input;

import main.java.resources.menu.SizeCalculator;

import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.Font;

import static main.java.model.leaderboard.Player.MAX_PLAYER_NAME_LENGTH;
import static main.java.model.leaderboard.Player.MIN_PLAYER_NAME_LENGTH;
import static main.java.resources.menu.MenuConstants.GET_PLAYER_NAME_TEXT_FIELD_FONT_MULTIPLIER;

public final class GetPlayerNameTextField extends JTextField {
    public GetPlayerNameTextField(Dimension windowDimension) {
        super(MAX_PLAYER_NAME_LENGTH);
        setHorizontalAlignment(CENTER);
        setFont(new Font(getFont().getFontName(), Font.BOLD,
                SizeCalculator.calculateSizeBasedOnWindowDimension(windowDimension,
                        GET_PLAYER_NAME_TEXT_FIELD_FONT_MULTIPLIER)));
    }

    public String getPlayerName() {
        return getText();
    }

    public boolean checkPayerNameValidity() {
        return MIN_PLAYER_NAME_LENGTH < getPlayerNameLength() &&
                getPlayerNameLength() < MAX_PLAYER_NAME_LENGTH;
    }

    private int getPlayerNameLength() {
        return getPlayerName().length();
    }
}
