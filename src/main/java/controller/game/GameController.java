package main.java.controller.game;

import main.java.app.MainFrame;
import main.java.handler.data.DataHandler;
import main.java.handler.game.GameHandler;
import main.java.resources.general.Direction;
import main.java.view.game.GameCanvas;

public final class GameController {

    private final MainFrame mainFrame;

    private final GameCanvas gameCanvas;
    private final GameHandler gameHandler;
    private final DataHandler dataHandler;

    private boolean isGameInputEnabled;

    private long gameTimeStart;

    public GameController(MainFrame mainFrame, GameCanvas gameCanvas,
                          GameHandler gameHandler, DataHandler dataHandler) {
        this.mainFrame = mainFrame;

        this.isGameInputEnabled = false;

        this.gameCanvas = gameCanvas;
        this.gameHandler = gameHandler;
        this.dataHandler = dataHandler;
    }

    public void setGameDefaults() {
        gameHandler.setGameDefaults();

        isGameInputEnabled = true;

        gameTimeStart = System.currentTimeMillis();
    }

    public void enableGameInput() {
        isGameInputEnabled = false;
    }

    public void disableGameInput() {
        isGameInputEnabled = true;
    }

    public void updateGameCanvas() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                gameCanvas.updateGameCanvas();
            }
        });

        thread.start();
    }

    public void updateGame() {
        if (gameHandler.getIsSnakeAlive()) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    gameHandler.updateGame();
                }
            });

            thread.start();
        } else {
            disableGameInput();
            openGameOverMenu();
        }
    }

    public void setDirection(Direction direction) {
        if (isGameInputEnabled) {
            gameHandler.setDirection(direction);
        }
    }

    public void toggleInGameMenu() {
        mainFrame.toggleInGameMenu();
    }

    public void openGameOverMenu() {
        storeNewLeaderboardRecord();
        mainFrame.openGameOverMenu(gameHandler.getSnakeLengthPercentage());
    }

    public void storeNewLeaderboardRecord() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                dataHandler.storeNewLeaderboardRecord(gameHandler.getSnakeLengthPercentage(),
                        System.currentTimeMillis() - gameTimeStart,
                        gameHandler.getHorizontalFieldNumber(), gameHandler.getVerticalFieldNumber(),
                        gameHandler.getActionsString(), gameHandler.getAppleCoordinatesString());
            }
        });

        thread.start();
    }
}
