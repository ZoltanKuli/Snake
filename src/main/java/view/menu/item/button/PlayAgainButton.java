package main.java.view.menu.item.button;

import main.java.controller.menu.InGameMenuController;

import java.awt.Dimension;

import static main.java.resources.menu.MenuTexts.PLAY_AGAIN_BUTTON_TEXT;

public final class PlayAgainButton extends MenuButton {
    public PlayAgainButton(Dimension windowDimension, Dimension dimension) {
        super(PLAY_AGAIN_BUTTON_TEXT, windowDimension, dimension);
    }

    public void playAgain(InGameMenuController inGameMenuController) {
        inGameMenuController.playAgain();
    }
}
