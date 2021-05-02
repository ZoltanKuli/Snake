package main.java.controller;

import main.java.controller.game.GameController;
import main.java.controller.menu.MainMenuController;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;

import static main.java.resources.general.Direction.DOWN;
import static main.java.resources.general.Direction.LEFT;
import static main.java.resources.general.Direction.RIGHT;
import static main.java.resources.general.Direction.UP;

public final class MainKeyEventDispatcher implements KeyEventDispatcher {
    private final MainMenuController mainMenuController;
    private final GameController gameController;

    public MainKeyEventDispatcher(MainMenuController mainMenuController, GameController gameController) {
        this.mainMenuController = mainMenuController;
        this.gameController = gameController;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        if (e.getID() == KeyEvent.KEY_PRESSED && e.getModifiersEx() == 0) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT, KeyEvent.VK_A -> gameController.setDirection(LEFT);
                case KeyEvent.VK_RIGHT, KeyEvent.VK_D -> gameController.setDirection(RIGHT);
                case KeyEvent.VK_UP, KeyEvent.VK_W -> gameController.setDirection(UP);
                case KeyEvent.VK_DOWN, KeyEvent.VK_S -> gameController.setDirection(DOWN);
                case KeyEvent.VK_ESCAPE -> handleEscapeKeyPress();
                case KeyEvent.VK_H -> mainMenuController.toggleMainMenu();
            }
        }

        return false;
    }

    private void handleEscapeKeyPress() {
        gameController.toggleInGameMenu();
        mainMenuController.exitLeaderboard();
    }
}
