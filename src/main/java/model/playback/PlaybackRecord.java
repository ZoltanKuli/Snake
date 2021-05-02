package main.java.model.playback;

import main.java.model.game.object.Coordinates;
import main.java.resources.general.Direction;

import static main.java.resources.general.Direction.DOWN;
import static main.java.resources.general.Direction.LEFT;
import static main.java.resources.general.Direction.RIGHT;
import static main.java.resources.general.Direction.UP;

public class PlaybackRecord {
    private final String[] actions;
    private final String[] appleCoordinates;
    private int currentActionIndex;
    private int currentAppleCoordinatesIndex;

    public PlaybackRecord(String actions, String appleCoordinates) {
        this.actions = actions.split(";");
        currentActionIndex = 0;
        this.appleCoordinates = appleCoordinates.split(";");
        currentAppleCoordinatesIndex = 0;
    }

    public Coordinates getCurrentAppleCoordinates() {
        if (appleCoordinates.length >= currentAppleCoordinatesIndex + 1) {
            String[] currentAppleCoordinates = appleCoordinates[currentAppleCoordinatesIndex].split(",");
            return new Coordinates(Integer.parseInt(currentAppleCoordinates[0]),
                    Integer.parseInt(currentAppleCoordinates[1]));
        }

        return null;
    }

    public void prepareNextAppleCoordinates() {
        currentAppleCoordinatesIndex++;
    }

    public Direction getCurrentDirection() {
        if (actions.length >= currentActionIndex + 1) {
            String[] currentActions = actions[currentActionIndex].split(",");
            String direction = currentActions[0];
            return switch (direction) {
                case "L" -> LEFT;
                case "R" -> RIGHT;
                case "U" -> UP;
                case "D" -> DOWN;
                default -> null;
            };
        }

        return null;
    }

    public Coordinates getCurrentDirectionChangeCoordinates() {
        if (actions.length >= currentActionIndex + 1) {
            String[] currentActions = actions[currentActionIndex].split(",");
            return new Coordinates(Integer.parseInt(currentActions[1]),
                    Integer.parseInt(currentActions[2]));
        }

        return null;
    }

    public void prepareNextAction() {
        currentActionIndex++;
    }
}
