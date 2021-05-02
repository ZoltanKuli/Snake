package main.java.view.menu.item.button;

import main.java.controller.menu.InGameMenuController;

import java.awt.Dimension;

import static main.java.resources.menu.MenuTexts.NO_TO_EXIT_TO_MAIN_MENU_BUTTON_TEXT;

public final class NoToExitToMainMenuButton extends MenuButton {
    public NoToExitToMainMenuButton(Dimension windowDimension, Dimension dimension) {
        super(NO_TO_EXIT_TO_MAIN_MENU_BUTTON_TEXT, windowDimension, dimension);
    }

    public void continueGame(InGameMenuController inGameMenuController) {
        inGameMenuController.continueGame();
    }
}
