package main.java.view.menu.item.input;

import main.java.view.menu.item.button.SetPlayerNameButton;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public final class GetPlayerNameTextFieldListener implements DocumentListener {
    private final GetPlayerNameTextField getPlayerNameTextField;
    private final SetPlayerNameButton setPlayerNameButton;

    public GetPlayerNameTextFieldListener(GetPlayerNameTextField getPlayerNameTextField, SetPlayerNameButton setPlayerNameButton) {
        this.getPlayerNameTextField = getPlayerNameTextField;
        this.setPlayerNameButton = setPlayerNameButton;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        updatePlayerNameTextField();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        updatePlayerNameTextField();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        updatePlayerNameTextField();
    }

    private void updatePlayerNameTextField() {
        setPlayerNameButton.setStateValidPlayerName(
                getPlayerNameTextField.checkPayerNameValidity());
    }
}
