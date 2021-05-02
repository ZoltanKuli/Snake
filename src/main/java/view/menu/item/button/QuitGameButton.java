package main.java.view.menu.item.button;

import main.java.controller.menu.MainMenuController;

import java.awt.Dimension;

import static main.java.resources.menu.MenuTexts.QUIT_GAME_BUTTON_TEXT;

public final class QuitGameButton extends MenuButton {
    public QuitGameButton(Dimension windowDimension, Dimension dimension) {
        super(QUIT_GAME_BUTTON_TEXT, windowDimension, dimension);
    }

    public void quitGame(MainMenuController mainMenuController) {
        mainMenuController.quitGame();
    }
}
