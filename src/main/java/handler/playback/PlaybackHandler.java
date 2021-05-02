package main.java.handler.playback;

import main.java.model.board.Board;
import main.java.model.game.object.Apple;
import main.java.model.game.object.Coordinates;
import main.java.model.game.object.Snake;
import main.java.model.playback.PlaybackRecord;
import main.java.resources.general.Direction;

import java.awt.Dimension;
import java.util.List;

import static main.java.resources.game.GameConstants.SNAKE_GROW_BY_MULTIPLIER;
import static main.java.resources.general.Direction.UP;

public class PlaybackHandler {

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
    private PlaybackRecord playbackRecord;

    public PlaybackHandler(Dimension gameCanvasDimension) {
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

    public synchronized void setPlaybackDefaults(PlaybackRecord playbackRecord) {
        snake.setDefaults(largestXCoordinate / 2,
                largestYCoordinate / 2);
        isSnakeAlive = true;
        direction = UP;

        this.playbackRecord = playbackRecord;

        snake.incrementGrowBy(startingSnakeLength);
        apple.setCoordinates(playbackRecord.getCurrentAppleCoordinates());
        playbackRecord.prepareNextAppleCoordinates();
    }

    public synchronized void updatePlayback() {
        if (playbackRecord != null) {
            setIsSnakeAlive();

            if (isSnakeAlive) {
                snake.move(direction);

                if (snake.getComponentsCoordinates().get(0).equals(
                        playbackRecord.getCurrentDirectionChangeCoordinates())) {
                    direction = playbackRecord.getCurrentDirection();
                    playbackRecord.prepareNextAction();
                }

                if (hasSnakeEatenApple()) {
                    snake.incrementGrowBy(snakeGrowBy);
                    apple.setCoordinates(playbackRecord.getCurrentAppleCoordinates());
                    playbackRecord.prepareNextAppleCoordinates();
                }
            }
        }
    }

    private synchronized boolean hasSnakeEatenApple() {
        return getSnakeComponentsCoordinates().get(0).equals(apple.getCoordinates());
    }

    private synchronized void setIsSnakeAlive() {
        isSnakeAlive = !snake.hasBittenTail() && willSnakeBeInBounds();
    }

    public synchronized boolean getIsSnakeAlive() {
        return isSnakeAlive;
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

    private synchronized void setSnakeGrowBy() {
        double multiple = maxLength * SNAKE_GROW_BY_MULTIPLIER;
        double multipleSquaredOnce = Math.sqrt(multiple);
        snakeGrowBy = (int) Math.floor(Math.sqrt(multipleSquaredOnce));
    }

    private synchronized void setStartingSnakeLength() {
        startingSnakeLength = maxLength % snakeGrowBy;
    }

    public synchronized List<Coordinates> getSnakeComponentsCoordinates() {
        return snake.getComponentsCoordinates();
    }

    public synchronized Coordinates getAppleCoordinates() {
        return apple.getCoordinates();
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
}
