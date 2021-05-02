package main.java.controller.playback;

import main.java.handler.data.DataHandler;
import main.java.handler.playback.PlaybackHandler;
import main.java.view.game.PlaybackCanvas;

public final class PlaybackController {

    private final PlaybackCanvas playbackCanvas;
    private final PlaybackHandler playbackHandler;
    private final DataHandler dataHandler;

    public PlaybackController(PlaybackCanvas playbackCanvas,
                              PlaybackHandler playbackHandler, DataHandler dataHandler) {

        this.playbackCanvas = playbackCanvas;
        this.playbackHandler = playbackHandler;
        this.dataHandler = dataHandler;
    }

    public void setPlaybackDefaults() {
        try {
            playbackHandler.setPlaybackDefaults(dataHandler.getPlaybackRecord(playbackHandler.getHorizontalFieldNumber(),
                    playbackHandler.getVerticalFieldNumber()));
        } catch (NullPointerException ignored) {

        }
    }

    public void updatePlaybackCanvas() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                playbackCanvas.updatePlaybackCanvas();
            }
        });

        thread.start();
    }

    public void updatePlayback() {
        if (playbackHandler.getIsSnakeAlive()) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    playbackHandler.updatePlayback();
                }
            });

            thread.start();
        } else {
            setPlaybackDefaults();
        }
    }
}
