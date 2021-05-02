package main.java.controller.menu;

import main.java.app.MainFrame;
import main.java.handler.data.DataHandler;

public final class PlayerNameMenuController {

    private final MainFrame mainFrame;

    private final DataHandler dataHandler;

    public PlayerNameMenuController(MainFrame mainFrame, DataHandler dataHandler) {
        this.mainFrame = mainFrame;

        this.dataHandler = dataHandler;
    }

    public void setPlayerName(String playerName) {
        dataHandler.setPlayerName(playerName);
    }

    public void enterMainMenu() {
        mainFrame.enterMainMenu();
    }
}
