package main.java.app;

import main.java.controller.MainActionListener;
import main.java.controller.MainKeyEventDispatcher;
import main.java.controller.game.GameCanvasTimer;
import main.java.controller.game.GameController;
import main.java.controller.game.GameControllerTimer;
import main.java.controller.menu.InGameMenuController;
import main.java.controller.menu.LeaderboardTimer;
import main.java.controller.menu.MainMenuController;
import main.java.controller.menu.PlayerNameMenuController;
import main.java.controller.playback.PlaybackCanvasTimer;
import main.java.controller.playback.PlaybackController;
import main.java.controller.playback.PlaybackControllerTimer;
import main.java.handler.data.DataHandler;
import main.java.handler.game.GameHandler;
import main.java.handler.playback.PlaybackHandler;
import main.java.view.game.GameCanvas;
import main.java.view.game.PlaybackCanvas;
import main.java.view.menu.ExitToMainMenuMenu;
import main.java.view.menu.GameOverMenu;
import main.java.view.menu.InGameMenu;
import main.java.view.menu.Leaderboard;
import main.java.view.menu.MainMenu;
import main.java.view.menu.PlayerNameMenu;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.KeyboardFocusManager;

import static main.java.resources.general.CustomColors.MAIN_BACKGROUND_COLOR;
import static main.java.resources.menu.MenuTexts.TITLE;

public final class MainFrame extends JFrame {

    private static final String APP_ICON_PATH = "/main/resources/images/main_icon.png";

    private JLayeredPane layeredPane;
    private PlayerNameMenu playerNameMenu;
    private PlaybackCanvas playbackCanvas;
    private MainMenu mainMenu;
    private Leaderboard leaderboard;
    private GameCanvas gameCanvas;
    private GameOverMenu gameOverMenu;
    private InGameMenu inGameMenu;
    private ExitToMainMenuMenu exitToMainMenuMenu;

    private PlaybackCanvasTimer playbackCanvasTimer;
    private PlaybackControllerTimer playbackControllerTimer;
    private GameCanvasTimer gameCanvasTimer;
    private GameControllerTimer gameControllerTimer;
    private LeaderboardTimer leaderboardTimer;

    public MainFrame() {
        super(TITLE);
        setAesthetic();
        setSize();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBackground(MAIN_BACKGROUND_COLOR);
        setComponents();
        setLayers();
        setVisible(true);
    }

    private void setAesthetic() {
        setIconImage(loadJFrameIcon());
        setUndecorated(true);
    }

    private Image loadJFrameIcon() {
        return new ImageIcon(getClass().getResource(APP_ICON_PATH)).getImage();
    }

    private Dimension getScreenDimension() {
        DisplayMode displayMode = GraphicsEnvironment.getLocalGraphicsEnvironment().
                getDefaultScreenDevice().getDisplayMode();

        return new Dimension(displayMode.getWidth(), displayMode.getHeight());
    }

    private void setSize() {
        setSize(getScreenDimension());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
    }

    private void setComponents() {
        DataHandler dataHandler = new DataHandler();
        PlayerNameMenuController playerNameMenuController = new PlayerNameMenuController(
                this, dataHandler);

        leaderboard = new Leaderboard(getScreenDimension(), false, dataHandler);
        MainMenuController mainMenuController = new MainMenuController(this, leaderboard, dataHandler);

        PlaybackHandler playbackHandler = new PlaybackHandler(getScreenDimension());
        playbackCanvas = new PlaybackCanvas(playbackHandler, false);
        PlaybackController playbackController = new PlaybackController(playbackCanvas, playbackHandler, dataHandler);

        GameHandler gameHandler = new GameHandler(getScreenDimension());
        gameCanvas = new GameCanvas(gameHandler, false);
        GameController gameController = new GameController(this, gameCanvas, gameHandler, dataHandler);
        InGameMenuController inGameMenuController = new InGameMenuController(this);

        MainActionListener mainActionListener = new MainActionListener(playerNameMenuController,
                mainMenuController, playbackController, gameController, inGameMenuController);

        playbackCanvasTimer = new PlaybackCanvasTimer(mainActionListener);
        playbackControllerTimer = new PlaybackControllerTimer(playbackController, mainActionListener);
        gameCanvasTimer = new GameCanvasTimer(mainActionListener);
        gameControllerTimer = new GameControllerTimer(gameController, mainActionListener);
        leaderboardTimer = new LeaderboardTimer(mainActionListener);
        leaderboardTimer.start();

        layeredPane = getLayeredPane();
        playerNameMenu = new PlayerNameMenu(getScreenDimension(), true, mainActionListener);
        mainMenu = new MainMenu(getScreenDimension(), false, mainActionListener);
        gameOverMenu = new GameOverMenu(getScreenDimension(), false, mainActionListener);
        inGameMenu = new InGameMenu(getScreenDimension(), false, mainActionListener);
        exitToMainMenuMenu = new ExitToMainMenuMenu(getScreenDimension(), false, mainActionListener);

        MainKeyEventDispatcher mainKeyEventDispatcher = new MainKeyEventDispatcher(
                mainMenuController, gameController);
        KeyboardFocusManager.getCurrentKeyboardFocusManager().
                addKeyEventDispatcher(mainKeyEventDispatcher);
    }

    private void setLayers() {
        layeredPane.add(playerNameMenu, Integer.valueOf(0));
        layeredPane.add(playbackCanvas, Integer.valueOf(1));
        layeredPane.add(mainMenu, Integer.valueOf(2));
        layeredPane.add(leaderboard, Integer.valueOf(3));
        layeredPane.add(gameCanvas, Integer.valueOf(4));
        layeredPane.add(gameOverMenu, Integer.valueOf(5));
        layeredPane.add(exitToMainMenuMenu, Integer.valueOf(6));
        layeredPane.add(inGameMenu, Integer.valueOf(7));
        layeredPane.add(exitToMainMenuMenu, Integer.valueOf(8));
    }

    public void enterMainMenu() {
        leaderboardTimer.start();

        playerNameMenu.setVisible(false);
        playbackCanvas.setVisible(true);
        mainMenu.setVisible(true);

        playbackCanvasTimer.start();
        playbackControllerTimer.start();
    }

    public void toggleMainMenu() {
        if (playbackCanvas.getIsVisible()) {
            mainMenu.setVisible(!mainMenu.getIsVisible());
        }
    }

    public void startNewGame() {
        leaderboardTimer.stop();
        playbackCanvasTimer.stop();
        playbackControllerTimer.stop();

        playbackCanvas.setVisible(false);
        mainMenu.setVisible(false);
        gameCanvas.setVisible(true);

        gameCanvasTimer.start();
        gameControllerTimer.start();
    }

    public void openLeaderboard() {
        playbackCanvasTimer.stop();
        playbackControllerTimer.stop();

        playbackCanvas.setVisible(false);
        mainMenu.setVisible(false);
        leaderboard.setVisible(true);
    }

    public void exitLeaderboard() {
        if (leaderboard.getIsVisible()) {
            playbackCanvas.setVisible(true);
            mainMenu.setVisible(true);
            leaderboard.setVisible(false);

            playbackCanvasTimer.start();
            playbackControllerTimer.start();
        }
    }

    public void quitGame() {
        leaderboardTimer.stop();
        playbackCanvasTimer.stop();
        playbackControllerTimer.stop();

        System.exit(0);
    }

    public void directlyExitToMainMenu() {
        exitToMainMenu();

        gameOverMenu.setVisible(false);
    }

    public void playAgain() {
        gameCanvas.setVisible(true);
        gameOverMenu.setVisible(false);

        gameCanvasTimer.start();
        gameControllerTimer.start();
    }

    public void openGameOverMenu(double snakeLengthPercentage) {
        gameCanvasTimer.stop();
        gameControllerTimer.stop();

        gameOverMenu.updateTexts(snakeLengthPercentage);
        gameCanvas.setVisible(false);
        gameOverMenu.setVisible(true);
    }

    public void toggleInGameMenu() {
        if (gameCanvas.getIsVisible()) {
            inGameMenu.setVisible(!inGameMenu.getIsVisible());

            if (inGameMenu.getIsVisible()) {
                gameCanvasTimer.stop();
                gameControllerTimer.stop();
            } else {
                gameCanvasTimer.start();
                gameControllerTimer.start();
            }
        }
    }

    public void resumeGame() {
        inGameMenu.setVisible(false);

        gameCanvasTimer.start();
        gameControllerTimer.start();
    }

    public void openExitToMainMenuMenu() {
        gameCanvas.setVisible(false);
        inGameMenu.setVisible(false);
        exitToMainMenuMenu.setVisible(true);
    }

    public void exitToMainMenu() {
        leaderboardTimer.start();

        playbackCanvas.setVisible(true);
        mainMenu.setVisible(true);
        gameCanvas.setVisible(false);
        inGameMenu.setVisible(false);
        exitToMainMenuMenu.setVisible(false);

        playbackCanvasTimer.start();
        playbackControllerTimer.start();
    }

    public void continueGame() {
        gameCanvas.setVisible(true);
        inGameMenu.setVisible(false);
        exitToMainMenuMenu.setVisible(false);

        gameCanvasTimer.start();
        gameControllerTimer.start();
    }
}
