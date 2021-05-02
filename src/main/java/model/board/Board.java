package main.java.model.board;

import java.awt.Dimension;

import static main.java.resources.board.BoardConstants.FIELD_MARGIN_DIVISOR;
import static main.java.resources.board.BoardConstants.FIELD_NUMBER_MULTIPLIER;
import static main.java.resources.board.BoardConstants.REMAINDER_DIVISOR;

public final class Board {
    private final Dimension canvasDimension;

    private int horizontalFieldNumber;
    private int verticalFieldNumber;

    private int fieldSize;
    private int fieldMargin;
    private int horizontalRemainderSize;
    private int verticalRemainderSize;

    public Board(Dimension canvasDimension) {
        this.canvasDimension = canvasDimension;

        setHorizontalFieldNumber();
        setFieldSize();
        setVerticalFieldNumber();

        setFieldMargin();
        setRemainderSizes();
    }

    private synchronized void setHorizontalFieldNumber() {
        double dimensionMultiple = canvasDimension.width * canvasDimension.height * FIELD_NUMBER_MULTIPLIER;
        double dimensionMultipleSquaredOnce = Math.sqrt(dimensionMultiple);
        horizontalFieldNumber = (int) Math.ceil(Math.sqrt(dimensionMultipleSquaredOnce));
    }

    private synchronized void setFieldSize() {
        fieldSize = (int) Math.floor(canvasDimension.width / (double) horizontalFieldNumber);
    }

    private synchronized void setVerticalFieldNumber() {
        verticalFieldNumber = (int) Math.floor(canvasDimension.height / (double) fieldSize);
    }

    private synchronized void setFieldMargin() {
        fieldMargin = (int) Math.floor(fieldSize / FIELD_MARGIN_DIVISOR);
    }

    private synchronized void setRemainderSizes() {
        horizontalRemainderSize = (int) Math.floor(
                (canvasDimension.width - horizontalFieldNumber * fieldSize) / REMAINDER_DIVISOR);
        verticalRemainderSize = (int) Math.floor(
                (canvasDimension.height - verticalFieldNumber * fieldSize) / REMAINDER_DIVISOR);
    }

    public synchronized Dimension getCanvasDimension() {
        return canvasDimension;
    }

    public synchronized int getHorizontalFieldNumber() {
        return horizontalFieldNumber;
    }

    public synchronized int getVerticalFieldNumber() {
        return verticalFieldNumber;
    }

    public synchronized int getFieldSize() {
        return fieldSize;
    }

    public synchronized int getFieldMargin() {
        return fieldMargin;
    }

    public synchronized int getHorizontalRemainderSize() {
        return horizontalRemainderSize;
    }

    public synchronized int getVerticalRemainderSize() {
        return verticalRemainderSize;
    }
}
