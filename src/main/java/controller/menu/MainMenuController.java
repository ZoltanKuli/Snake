package main.java.controller.menu;

import main.java.app.MainFrame;
import main.java.handler.data.DataHandler;
import main.java.view.menu.Leaderboard;

public final class MainMenuController {

    private final MainFrame mainFrame;
    private final Leaderboard leaderboard;

    private final DataHandler dataHandler;

    public MainMenuController(MainFrame mainFrame, Leaderboard leaderboard, DataHandler dataHandler) {
        this.mainFrame = mainFrame;
        this.leaderboard = leaderboard;

        this.dataHandler = dataHandler;
    }

    public void updateLeaderboardRecords() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                dataHandler.queryLeaderboardRecords();
            }
        });

        thread.start();
    }

    public void toggleMainMenu() {
        mainFrame.toggleMainMenu();
    }

    public void startNewGame() {
        mainFrame.startNewGame();
    }

    public void openLeaderBoard() {
        leaderboard.setComponents();
        mainFrame.openLeaderboard();
    }

    public void exitLeaderboard() {
        mainFrame.exitLeaderboard();
    }

    public void quitGame() {
        mainFrame.quitGame();
    }
}
