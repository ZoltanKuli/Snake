package main.java.view.menu.item.button;

import main.java.controller.menu.MainMenuController;

import java.awt.Dimension;

import static main.java.resources.menu.MenuTexts.START_NEW_GAME_BUTTON_TEXT;

public final class StartNewGameButton extends MenuButton {
    public StartNewGameButton(Dimension windowDimension, Dimension dimension) {
        super(START_NEW_GAME_BUTTON_TEXT, windowDimension, dimension);
    }

    public void startNewGame(MainMenuController mainMenuController) {
        mainMenuController.startNewGame();
    }
}
