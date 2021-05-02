package main.java.controller.menu;

import main.java.app.MainFrame;

public final class InGameMenuController {

    private final MainFrame mainFrame;

    public InGameMenuController(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public void playAgain() {
        mainFrame.playAgain();
    }

    public void resumeGame() {
        mainFrame.resumeGame();
    }

    public void openExitToMainMenuMenu() {
        mainFrame.openExitToMainMenuMenu();
    }

    public void exitToMainMenu() {
        mainFrame.exitToMainMenu();
    }

    public void directlyExitToMainMenu() {
        mainFrame.directlyExitToMainMenu();
    }

    public void continueGame() {
        mainFrame.continueGame();
    }
}
