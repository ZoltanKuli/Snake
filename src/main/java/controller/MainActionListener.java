package main.java.controller;

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
import main.java.view.menu.item.button.DirectlyExitToMainMenuButton;
import main.java.view.menu.item.button.ExitToMainMenuButton;
import main.java.view.menu.item.button.NoToExitToMainMenuButton;
import main.java.view.menu.item.button.PlayAgainButton;
import main.java.view.menu.item.button.QuitGameButton;
import main.java.view.menu.item.button.ResumeGameButton;
import main.java.view.menu.item.button.SetPlayerNameButton;
import main.java.view.menu.item.button.ShowLeaderboardButton;
import main.java.view.menu.item.button.StartNewGameButton;
import main.java.view.menu.item.button.YesToExitToMainMenuButton;
import main.java.view.menu.item.input.GetPlayerNameTextField;

import java.awt.event.ActionEvent;

public final class MainActionListener implements java.awt.event.ActionListener {

    private final PlayerNameMenuController playerNameMenuController;
    private final MainMenuController mainMenuController;
    private final PlaybackController playbackController;
    private final GameController gameController;
    private final InGameMenuController inGameMenuController;

    private GetPlayerNameTextField getPlayerNameTextFieldHorizontal;
    private SetPlayerNameButton setPlayerNameButton;

    public MainActionListener(PlayerNameMenuController playerNameMenuController,
                              MainMenuController mainMenuController, PlaybackController playbackController,
                              GameController gameController, InGameMenuController inGameMenuController) {
        this.playerNameMenuController = playerNameMenuController;
        this.mainMenuController = mainMenuController;
        this.playbackController = playbackController;
        this.gameController = gameController;
        this.inGameMenuController = inGameMenuController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source instanceof GameCanvasTimer) {
            gameController.updateGameCanvas();
        } else if (source instanceof GameControllerTimer) {
            gameController.updateGame();
        } else if (source instanceof PlaybackCanvasTimer) {
            playbackController.updatePlaybackCanvas();
        } else if (source instanceof PlaybackControllerTimer) {
            playbackController.updatePlayback();
        } else if (source instanceof SetPlayerNameButton) {
            SetPlayerNameButton setPlayerNameButton = (SetPlayerNameButton) source;

            setPlayerNameButton.setPlayerName(playerNameMenuController);
            playerNameMenuController.enterMainMenu();
        } else if (source instanceof StartNewGameButton) {
            gameController.setGameDefaults();

            StartNewGameButton startNewGameButton = (StartNewGameButton) source;

            startNewGameButton.startNewGame(mainMenuController);
        } else if (source instanceof ShowLeaderboardButton) {
            ShowLeaderboardButton showLeaderboardButton = (ShowLeaderboardButton) source;

            showLeaderboardButton.openLeaderBoard(mainMenuController);
        } else if (source instanceof QuitGameButton) {
            QuitGameButton quitGameButton = (QuitGameButton) source;

            quitGameButton.quitGame(mainMenuController);
        } else if (source instanceof DirectlyExitToMainMenuButton) {
            DirectlyExitToMainMenuButton directlyExitToMainMenuButton = (DirectlyExitToMainMenuButton) source;

            directlyExitToMainMenuButton.directlyExitToMainMenuMenu(inGameMenuController);
        } else if (source instanceof PlayAgainButton) {
            gameController.setGameDefaults();

            PlayAgainButton playAgainButton = (PlayAgainButton) source;

            playAgainButton.playAgain(inGameMenuController);
        } else if (source instanceof ResumeGameButton) {
            ResumeGameButton resumeGameButton = (ResumeGameButton) source;

            resumeGameButton.resumeGame(inGameMenuController);
        } else if (source instanceof ExitToMainMenuButton) {
            ExitToMainMenuButton exitToMainMenuButton = (ExitToMainMenuButton) source;

            exitToMainMenuButton.openExitToMainMenuMenu(inGameMenuController);
        } else if (source instanceof NoToExitToMainMenuButton) {
            NoToExitToMainMenuButton noToExitToMainMenuButton = (NoToExitToMainMenuButton) source;

            noToExitToMainMenuButton.continueGame(inGameMenuController);
        } else if (source instanceof YesToExitToMainMenuButton) {
            YesToExitToMainMenuButton yesToExitToMainMenuButton = (YesToExitToMainMenuButton) source;

            yesToExitToMainMenuButton.exitToMainMenu(inGameMenuController);
        } else if (source instanceof LeaderboardTimer) {
            mainMenuController.updateLeaderboardRecords();
        } else if (source != null && source == getPlayerNameTextFieldHorizontal) {
            setPlayerNameButton.doClick();
        }
    }

    public void setSetPlayerNameButtonActivationOnEnter(GetPlayerNameTextField getPlayerNameTextFieldHorizontal,
                                                        SetPlayerNameButton setPlayerNameButton) {
        this.getPlayerNameTextFieldHorizontal = getPlayerNameTextFieldHorizontal;
        this.setPlayerNameButton = setPlayerNameButton;
    }
}
