package main.java.model.leaderboard;

import java.util.Date;

public final class LeaderboardRecord {

    private final String playerName;
    private final double snakeLengthPercentage;
    private final long gameTime;
    private final Date gameEndDateTime;

    public LeaderboardRecord(String playerName, double snakeLengthPercentage,
                             long gameTime, Date gameEndDateTime) {
        this.playerName = playerName;
        this.snakeLengthPercentage = snakeLengthPercentage;
        this.gameTime = gameTime;
        this.gameEndDateTime = gameEndDateTime;
    }

    public synchronized String getPlayerName() {
        return playerName;
    }

    public synchronized double getSnakeLengthPercentage() {
        return snakeLengthPercentage;
    }

    public synchronized long getGameTime() {
        return gameTime;
    }

    public synchronized Date getGameEndDateTime() {
        return new Date(gameEndDateTime.getTime());
    }
}
