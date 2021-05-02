package main.java.view.menu.item.button;

import main.java.controller.menu.InGameMenuController;

import java.awt.Dimension;

import static main.java.resources.menu.MenuTexts.YES_TO_EXIT_TO_MAIN_MENU_BUTTON_TEXT;

public final class YesToExitToMainMenuButton extends MenuButton {
    public YesToExitToMainMenuButton(Dimension windowDimension, Dimension dimension) {
        super(YES_TO_EXIT_TO_MAIN_MENU_BUTTON_TEXT, windowDimension, dimension);
    }

    public void exitToMainMenu(InGameMenuController inGameMenuController) {
        inGameMenuController.exitToMainMenu();
    }
}
