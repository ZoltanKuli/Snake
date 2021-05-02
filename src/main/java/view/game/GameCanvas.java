package main.java.view.game;

import main.java.handler.game.GameHandler;
import main.java.model.game.object.Coordinates;
import main.java.resources.general.CustomColors;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

public class GameCanvas extends JPanel {
    private final GameHandler gameHandler;

    private final int horizontalFieldNumber;
    private final int verticalFieldNumber;

    private final int fieldSize;
    private final int fieldMargin;
    private final int horizontalRemainderSize;
    private final int verticalRemainderSize;

    private boolean isVisible;

    public GameCanvas(GameHandler gameHandler, boolean isVisible) {
        super();
        setBackground(CustomColors.UNPLAYABLE_AREA_COLOR);
        setSize(gameHandler.getGameCanvasDimension());

        this.gameHandler = gameHandler;
        horizontalFieldNumber = gameHandler.getHorizontalFieldNumber();
        verticalFieldNumber = gameHandler.getVerticalFieldNumber();

        fieldSize = gameHandler.getFieldSize();
        fieldMargin = gameHandler.getFieldMargin();
        horizontalRemainderSize = gameHandler.getHorizontalRemainderSize();
        verticalRemainderSize = gameHandler.getVerticalRemainderSize();

        setVisible(isVisible);
    }

    public synchronized void updateGameCanvas() {
        repaint();
    }

    @Override
    public synchronized void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;

        drawBackground(graphics2D);
        drawApple(graphics2D);
        drawSnake(graphics2D);
    }

    private synchronized void drawBackground(Graphics2D graphics2D) {
        graphics2D.setColor(CustomColors.PLAYABLE_AREA_COLOR);

        int width = fieldSize * horizontalFieldNumber;
        int height = fieldSize * verticalFieldNumber;

        graphics2D.fillRect(horizontalRemainderSize, verticalRemainderSize,
                width + fieldMargin, height + fieldMargin);
    }

    private synchronized void drawApple(Graphics2D graphics2D) {
        graphics2D.setColor(CustomColors.APPLE_COLOR);
        Coordinates appleCoordinates = gameHandler.getAppleCoordinates();
        graphics2D.fillRect(appleCoordinates.getXCoordinate() * fieldSize + fieldMargin + horizontalRemainderSize,
                appleCoordinates.getYCoordinate() * fieldSize + fieldMargin + verticalRemainderSize,
                fieldSize - fieldMargin * 2, fieldSize - fieldMargin * 2);
    }

    private synchronized void drawSnake(Graphics2D graphics2D) {
        graphics2D.setColor(CustomColors.SNAKE_COLOR);
        List<Coordinates> snakeComponentsCoordinates = gameHandler.getSnakeComponentsCoordinates();
        for (Coordinates snakeCoordinates : snakeComponentsCoordinates) {
            graphics2D.fillRect(snakeCoordinates.getXCoordinate() * fieldSize + fieldMargin + horizontalRemainderSize,
                    snakeCoordinates.getYCoordinate() * fieldSize + fieldMargin + verticalRemainderSize,
                    fieldSize - fieldMargin * 2, fieldSize - fieldMargin * 2);
        }
    }

    @Override
    public synchronized void setVisible(boolean aFlag) {
        super.setVisible(aFlag);

        isVisible = aFlag;

        revalidate();
    }

    public synchronized boolean getIsVisible() {
        return isVisible;
    }
}
