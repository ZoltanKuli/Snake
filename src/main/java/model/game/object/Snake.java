package main.java.model.game.object;

import main.java.resources.general.Direction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static main.java.resources.game.GameConstants.DEFAULT_SNAKE_GROW_BY;

public final class Snake {

    private List<Coordinates> componentsCoordinates;
    private int growBy;

    public synchronized void setDefaults(int headXCoordinate, int headYCoordinate) {
        setDefaults(new Coordinates(headXCoordinate, headYCoordinate));
    }

    public synchronized void setDefaults(Coordinates snakeHeadCoordinates) {
        componentsCoordinates = Collections.synchronizedList(new ArrayList<>());
        componentsCoordinates.add(snakeHeadCoordinates);
        growBy = 0;
    }

    public synchronized void move(Direction direction) {
        Coordinates currentHeadCoordinates = new Coordinates(
                componentsCoordinates.get(0).getXCoordinate(),
                componentsCoordinates.get(0).getYCoordinate());

        moveHead(direction);

        moveTail(currentHeadCoordinates);
    }

    private synchronized void moveHead(Direction direction) {
        Coordinates headCoordinates = componentsCoordinates.get(0);

        switch (direction) {
            case LEFT -> headCoordinates.setXCoordinate(headCoordinates.getXCoordinate() - 1);
            case RIGHT -> headCoordinates.setXCoordinate(headCoordinates.getXCoordinate() + 1);
            case UP -> headCoordinates.setYCoordinate(headCoordinates.getYCoordinate() - 1);
            case DOWN -> headCoordinates.setYCoordinate(headCoordinates.getYCoordinate() + 1);
        }
    }

    private synchronized void moveTail(Coordinates previousHeadCoordinates) {
        Coordinates previousComponentCoordinates = previousHeadCoordinates;

        for (int i = 1; i < componentsCoordinates.size(); i++) {
            if (componentsCoordinates.get(i).equals(previousComponentCoordinates) && growBy != 0) {
                growBy--;
                break;
            }

            Coordinates tmpCoordinates = new Coordinates(
                    componentsCoordinates.get(i).getXCoordinate(),
                    componentsCoordinates.get(i).getYCoordinate());

            componentsCoordinates.get(i).setXCoordinate(
                    previousComponentCoordinates.getXCoordinate());
            componentsCoordinates.get(i).setYCoordinate(
                    previousComponentCoordinates.getYCoordinate());

            previousComponentCoordinates = tmpCoordinates;
        }
    }

    public synchronized void incrementGrowBy() {
        incrementGrowBy(DEFAULT_SNAKE_GROW_BY);
    }

    public synchronized void incrementGrowBy(int growBy) {
        this.growBy += growBy;

        for (int i = 0; i < growBy; i++) {
            componentsCoordinates.add(new Coordinates(
                    componentsCoordinates.get(componentsCoordinates.size() - 1).getXCoordinate(),
                    componentsCoordinates.get(componentsCoordinates.size() - 1).getYCoordinate()));
        }
    }

    public synchronized List<Coordinates> getComponentsCoordinates() {
        return componentsCoordinates;
    }

    public synchronized boolean hasBittenTail() {
        if (componentsCoordinates.size() <= growBy + 1) {
            return false;
        }

        for (int i = 1; i < componentsCoordinates.size(); i++) {
            if (componentsCoordinates.get(0).equals(componentsCoordinates.get(i))) {
                return true;
            }
        }

        return false;
    }

    public synchronized int getLength() {
        return componentsCoordinates.size();
    }
}
