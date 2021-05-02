package main.java.view.menu.item.button;

import main.java.controller.menu.InGameMenuController;

import java.awt.Dimension;

import static main.java.resources.menu.MenuTexts.DIRECTLY_EXIT_TO_MAIN_MENU_BUTTON_TEXT;

public final class DirectlyExitToMainMenuButton extends MenuButton {
    public DirectlyExitToMainMenuButton(Dimension windowDimension, Dimension dimension) {
        super(DIRECTLY_EXIT_TO_MAIN_MENU_BUTTON_TEXT, windowDimension, dimension);
    }

    public void directlyExitToMainMenuMenu(InGameMenuController inGameMenuController) {
        inGameMenuController.directlyExitToMainMenu();
    }
}
