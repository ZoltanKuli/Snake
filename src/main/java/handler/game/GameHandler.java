package main.java.handler.game;

import main.java.model.board.Board;
import main.java.model.game.object.Apple;
import main.java.model.game.object.Coordinates;
import main.java.model.game.object.Snake;
import main.java.resources.general.Direction;

import java.awt.Dimension;
import java.util.List;
import java.util.Random;

import static main.java.resources.game.GameConstants.SNAKE_GROW_BY_MULTIPLIER;
import static main.java.resources.general.Direction.UP;

public class GameHandler {

    private final Board board;
    private final Snake snake;
    private final Apple apple;
    private final int smallestXCoordinate;
    private final int largestXCoordinate;
    private final int smallestYCoordinate;
    private final int largestYCoordinate;
    private final int maxLength;
    private boolean isSnakeAlive;
    private Direction direction;
    private int startingSnakeLength;
    private int snakeGrowBy;
    private StringBuilder actions;
    private StringBuilder appleCoordinates;

    public GameHandler(Dimension gameCanvasDimension) {
        board = new Board(gameCanvasDimension);
        snake = new Snake();
        apple = new Apple();

        smallestXCoordinate = 0;
        largestXCoordinate = board.getHorizontalFieldNumber() - 1;
        smallestYCoordinate = 0;
        largestYCoordinate = board.getVerticalFieldNumber() - 1;
        maxLength = largestXCoordinate * largestYCoordinate;
        setSnakeGrowBy();
        setStartingSnakeLength();
    }

    public synchronized void setGameDefaults() {
        snake.setDefaults(largestXCoordinate / 2,
                largestYCoordinate / 2);
        isSnakeAlive = true;
        direction = UP;
        actions = new StringBuilder();
        appleCoordinates = new StringBuilder();
        snake.incrementGrowBy(startingSnakeLength);
        setUnoccupiedCoordinatesForApple();
    }

    public synchronized void updateGame() {
        setIsSnakeAlive();

        if (isSnakeAlive) {
            snake.move(direction);

            if (hasSnakeEatenApple()) {
                snake.incrementGrowBy(snakeGrowBy);
                setUnoccupiedCoordinatesForApple();
            }
        }
    }

    private synchronized boolean hasSnakeEatenApple() {
        return getSnakeComponentsCoordinates().get(0).equals(apple.getCoordinates());
    }

    private synchronized void setUnoccupiedCoordinatesForApple() {
        Random random = new Random(System.currentTimeMillis());

        Coordinates newCoordinates = new Coordinates(
                random.nextInt(largestXCoordinate + 1),
                random.nextInt(largestYCoordinate + 1));

        while (areCoordinatesOccupied(newCoordinates)) {
            newCoordinates.setXCoordinate(random.nextInt(largestXCoordinate + 1));
            newCoordinates.setYCoordinate(random.nextInt(largestYCoordinate + 1));
        }

        appleCoordinates.append(newCoordinates.getXCoordinate()).append(",").
                append(newCoordinates.getYCoordinate()).append(";");

        apple.setCoordinates(newCoordinates);
    }

    private synchronized boolean areCoordinatesOccupied(Coordinates coordinatesToBeChecked) {
        List<Coordinates> snakeComponentsCoordinates = snake.getComponentsCoordinates();

        for (Coordinates snakeComponentCoordinates : snakeComponentsCoordinates) {
            if (coordinatesToBeChecked.equals(snakeComponentCoordinates)) {
                return true;
            }
        }

        return false;
    }

    private synchronized void setIsSnakeAlive() {
        isSnakeAlive = !snake.hasBittenTail() && willSnakeBeInBounds();
    }

    private synchronized boolean willSnakeBeInBounds() {
        Coordinates snakeHeadCoordinates = getSnakeComponentsCoordinates().get(0);
        Coordinates futureSnakeHeadCoordinates = switch (direction) {
            case LEFT -> new Coordinates(snakeHeadCoordinates.getXCoordinate() - 1,
                    snakeHeadCoordinates.getYCoordinate());
            case RIGHT -> new Coordinates(snakeHeadCoordinates.getXCoordinate() + 1,
                    snakeHeadCoordinates.getYCoordinate());
            case UP -> new Coordinates(snakeHeadCoordinates.getXCoordinate(),
                    snakeHeadCoordinates.getYCoordinate() - 1);
            case DOWN -> new Coordinates(snakeHeadCoordinates.getXCoordinate(),
                    snakeHeadCoordinates.getYCoordinate() + 1);
        };

        return smallestXCoordinate <= futureSnakeHeadCoordinates.getXCoordinate() &&
                futureSnakeHeadCoordinates.getXCoordinate() <= largestXCoordinate &&
                smallestYCoordinate <= futureSnakeHeadCoordinates.getYCoordinate() &&
                futureSnakeHeadCoordinates.getYCoordinate() <= largestYCoordinate;
    }

    public synchronized boolean getIsSnakeAlive() {
        return isSnakeAlive;
    }

    private synchronized void setSnakeGrowBy() {
        double multiple = maxLength * SNAKE_GROW_BY_MULTIPLIER;
        double multipleSquaredOnce = Math.sqrt(multiple);
        snakeGrowBy = (int) Math.floor(Math.sqrt(multipleSquaredOnce));
    }

    private synchronized void setStartingSnakeLength() {
        startingSnakeLength = maxLength % snakeGrowBy;
    }

    public synchronized void setDirection(Direction direction) {
        Coordinates snakeHeadCoordinates = getSnakeComponentsCoordinates().get(0);
        Coordinates futureSnakeHeadCoordinates = switch (direction) {
            case LEFT -> new Coordinates(snakeHeadCoordinates.getXCoordinate() - 1,
                    snakeHeadCoordinates.getYCoordinate());
            case RIGHT -> new Coordinates(snakeHeadCoordinates.getXCoordinate() + 1,
                    snakeHeadCoordinates.getYCoordinate());
            case UP -> new Coordinates(snakeHeadCoordinates.getXCoordinate(),
                    snakeHeadCoordinates.getYCoordinate() - 1);
            case DOWN -> new Coordinates(snakeHeadCoordinates.getXCoordinate(),
                    snakeHeadCoordinates.getYCoordinate() + 1);
        };

        if (snake.getLength() == 1 || (snake.getLength() > 1 &&
                !futureSnakeHeadCoordinates.equals(getSnakeComponentsCoordinates().get(1)))) {

            this.direction = direction;

            appendActions();
        }
    }

    private synchronized void appendActions() {
        String directionString = "";
        switch (direction) {
            case LEFT -> directionString = "L";
            case RIGHT -> directionString = "R";
            case UP -> directionString = "U";
            case DOWN -> directionString = "D";
        }

        actions.append(directionString).append(",");
        actions.append(snake.getComponentsCoordinates().get(0).getXCoordinate()).append(",").
                append(snake.getComponentsCoordinates().get(0).getYCoordinate()).append(";");
    }

    public synchronized List<Coordinates> getSnakeComponentsCoordinates() {
        return snake.getComponentsCoordinates();
    }

    public synchronized Coordinates getAppleCoordinates() {
        return apple.getCoordinates();
    }

    public synchronized double getSnakeLengthPercentage() {
        return snake.getLength() / (double) maxLength * 100;
    }

    public synchronized Dimension getGameCanvasDimension() {
        return board.getCanvasDimension();
    }

    public synchronized int getHorizontalFieldNumber() {
        return board.getHorizontalFieldNumber();
    }

    public synchronized int getVerticalFieldNumber() {
        return board.getVerticalFieldNumber();
    }

    public synchronized int getFieldSize() {
        return board.getFieldSize();
    }

    public synchronized int getFieldMargin() {
        return board.getFieldMargin();
    }

    public synchronized int getHorizontalRemainderSize() {
        return board.getHorizontalRemainderSize();
    }

    public synchronized int getVerticalRemainderSize() {
        return board.getVerticalRemainderSize();
    }

    public synchronized String getActionsString() {
        return actions.toString();
    }

    public synchronized String getAppleCoordinatesString() {
        return appleCoordinates.toString();
    }
}
