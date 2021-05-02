package main.java.model.game.object;

import java.util.Objects;

public class Coordinates {

    private int xCoordinate;
    private int yCoordinate;

    public Coordinates(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public synchronized Integer getXCoordinate() {
        return xCoordinate;
    }

    public synchronized void setXCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public synchronized Integer getYCoordinate() {
        return yCoordinate;
    }

    public synchronized void setYCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    @Override
    public synchronized boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;

        return this.getXCoordinate().equals(that.getXCoordinate()) &&
                this.getYCoordinate().equals(that.getYCoordinate());
    }

    @Override
    public synchronized int hashCode() {
        return Objects.hash(this.getXCoordinate(),
                this.getYCoordinate());
    }
}
