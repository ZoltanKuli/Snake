package main.java.view.menu.item.button;

import main.java.controller.menu.InGameMenuController;

import java.awt.Dimension;

import static main.java.resources.menu.MenuTexts.EXIT_TO_MAIN_MENU_BUTTON_TEXT;

public final class ExitToMainMenuButton extends MenuButton {
    public ExitToMainMenuButton(Dimension windowDimension, Dimension dimension) {
        super(EXIT_TO_MAIN_MENU_BUTTON_TEXT, windowDimension, dimension);
    }

    public void openExitToMainMenuMenu(InGameMenuController inGameMenuController) {
        inGameMenuController.openExitToMainMenuMenu();
    }
}
