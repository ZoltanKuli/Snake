package main.java.model.game.object;

public final class Apple {
    private Coordinates coordinates;

    public synchronized Coordinates getCoordinates() {
        return coordinates;
    }

    public synchronized void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
