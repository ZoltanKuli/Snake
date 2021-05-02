package main.java.view.menu.item.button;

import main.java.controller.menu.MainMenuController;

import java.awt.Dimension;

import static main.java.resources.menu.MenuTexts.SHOW_LEADERBOARD_BUTTON_TEXT;

public final class ShowLeaderboardButton extends MenuButton {
    public ShowLeaderboardButton(Dimension windowDimension, Dimension dimension) {
        super(SHOW_LEADERBOARD_BUTTON_TEXT, windowDimension, dimension);
    }

    public void openLeaderBoard(MainMenuController mainMenuMenuController) {
        mainMenuMenuController.openLeaderBoard();
    }
}
