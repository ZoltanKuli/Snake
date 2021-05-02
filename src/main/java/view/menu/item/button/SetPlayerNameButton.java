package main.java.view.menu.item.button;

import main.java.controller.menu.PlayerNameMenuController;
import main.java.view.menu.item.input.GetPlayerNameTextField;

import java.awt.Dimension;

import static main.java.resources.menu.MenuTexts.SET_PLAYER_NAME_BUTTON_TEXT;

public final class SetPlayerNameButton extends MenuButton {
    private final GetPlayerNameTextField getPlayerNameTextField;

    public SetPlayerNameButton(Dimension windowDimension, Dimension dimension, GetPlayerNameTextField getPlayerNameTextField) {
        super(SET_PLAYER_NAME_BUTTON_TEXT, windowDimension, dimension);

        this.getPlayerNameTextField = getPlayerNameTextField;

        setEnabled(false);
    }

    public void setPlayerName(PlayerNameMenuController playerNameMenuController) {
        playerNameMenuController.setPlayerName(getPlayerNameTextField.getText());
    }

    public void setStateValidPlayerName(boolean isValid) {
        setEnabled(isValid);
        revalidate();
    }
}
