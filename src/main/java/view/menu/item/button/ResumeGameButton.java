package main.java.view.menu.item.button;

import main.java.controller.menu.InGameMenuController;

import java.awt.Dimension;

import static main.java.resources.menu.MenuTexts.RESUME_GAME_BUTTON_TEXT;

public final class ResumeGameButton extends MenuButton {
    public ResumeGameButton(Dimension windowDimension, Dimension dimension) {
        super(RESUME_GAME_BUTTON_TEXT, windowDimension, dimension);
    }

    public void resumeGame(InGameMenuController inGameMenuController) {
        inGameMenuController.resumeGame();
    }
}
