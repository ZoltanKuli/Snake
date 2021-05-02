package main.java.controller.playback;

import javax.swing.Timer;
import java.awt.event.ActionListener;

import static main.java.resources.playback.PlaybackConstants.MILLIS_BETWEEN_PLAYBACK_UPDATES;
import static main.java.resources.playback.PlaybackConstants.PLAYBACK_TIMER_INITIAL_DELAY;

public final class PlaybackControllerTimer extends Timer {

    private final PlaybackController playbackController;

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
    public PlaybackControllerTimer(PlaybackController playbackController, ActionListener listener) {
        super(MILLIS_BETWEEN_PLAYBACK_UPDATES, listener);

        setInitialDelay(PLAYBACK_TIMER_INITIAL_DELAY);

        this.playbackController = playbackController;
    }


    @Override
    public void start() {
        super.start();

        playbackController.setPlaybackDefaults();
    }
}
