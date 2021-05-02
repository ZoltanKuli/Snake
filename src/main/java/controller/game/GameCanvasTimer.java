package main.java.controller.game;

import javax.swing.Timer;
import java.awt.event.ActionListener;

import static main.java.resources.game.GameConstants.GAME_CANVAS_TIMER_INITIAL_DELAY;
import static main.java.resources.game.GameConstants.MILLIS_BETWEEN_GAME_CANVAS_UPDATES;

public final class GameCanvasTimer extends Timer {

    /**
     * Creates a {@code Timer} and initializes both the initial delay and
     * between-event delay to {@code delay} milliseconds. If {@code delay}
     * is less than or equal to zero, the timer fires as soon as it
     * is started. If <code>listener</code> is not <code>null</code>,
     * it's registered as an action listener on the timer.
     *
     * @param listener an initial listener; can be <code>null</code>
     * @see #addActionListener
     * @see #setInitialDelay
     * @see #setRepeats
     */
    public GameCanvasTimer(ActionListener listener) {
        super(MILLIS_BETWEEN_GAME_CANVAS_UPDATES, listener);

        setInitialDelay(GAME_CANVAS_TIMER_INITIAL_DELAY);
    }
}
