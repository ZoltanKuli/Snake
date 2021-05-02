package main.java.handler.data;

import main.java.dal.DataAccessObject;
import main.java.model.leaderboard.LeaderboardRecord;
import main.java.model.playback.PlaybackRecord;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static main.java.resources.menu.MenuTexts.GAME_END_DATE_TIME_FORMATTER;
import static main.java.resources.menu.MenuTexts.GAME_TIME_FORMATTER;
import static main.java.resources.menu.MenuTexts.SNAKE_LENGTH_FORMATTER;

public final class DataHandler {
    private final DataAccessObject dataAccessObject;

    public DataHandler() {
        dataAccessObject = new DataAccessObject();
    }

    public synchronized void setPlayerName(String playerName) {
        dataAccessObject.setPlayerName(playerName);
    }

    public synchronized void queryLeaderboardRecords() {
        try {
            dataAccessObject.queryLeaderboardRecords();
        } catch (SQLException ignored) {
        }
    }

    public synchronized List<LeaderboardRecord> getLeaderboardRecords() {
        try {
            return dataAccessObject.getLeaderboardRecords();
        } catch (SQLException exception) {
            return null;
        }
    }

    public synchronized PlaybackRecord getPlaybackRecord(int horizontalFieldNumber, int verticalFieldNumber) {
        try {
            List<PlaybackRecord> playbackRecords =
                    dataAccessObject.getPlaybackRecords(horizontalFieldNumber, verticalFieldNumber);
            int numOfPlaybackRecords = playbackRecords.size();

            if (numOfPlaybackRecords == 0) {
                return null;
            }

            if (numOfPlaybackRecords > 100) {
                numOfPlaybackRecords = 100;
            }

            int randomPlaybackRecordIndex = new Random().nextInt(numOfPlaybackRecords);
            return dataAccessObject.getPlaybackRecords(horizontalFieldNumber, verticalFieldNumber).get(randomPlaybackRecordIndex);
        } catch (SQLException exception) {
            return null;
        }
    }

    public synchronized String[][] getLeaderboardRecordsInFormattedStringArray() {
        List<LeaderboardRecord> leaderboardRecords = getLeaderboardRecords();

        if (leaderboardRecords != null) {
            int leaderBoardSize = 100;
            if (leaderboardRecords.size() < 100) {
                leaderBoardSize = leaderboardRecords.size();
            }

            String[][] leaderboardRecordsArray = new String[leaderBoardSize][5];
            for (int i = 0; i < leaderBoardSize; i++) {
                leaderboardRecordsArray[i][0] = String.valueOf(i + 1);
                leaderboardRecordsArray[i][1] = leaderboardRecords.get(i).getPlayerName();
                leaderboardRecordsArray[i][2] = formatSnakeLength(leaderboardRecords.get(i).getSnakeLengthPercentage());
                leaderboardRecordsArray[i][3] = formatGameTime(leaderboardRecords.get(i).getGameTime());
                leaderboardRecordsArray[i][4] = formatGameEndDateTime(leaderboardRecords.get(i).getGameEndDateTime());
            }

            return leaderboardRecordsArray;
        }

        return null;
    }

    private String formatSnakeLength(double snakeLengthPercent) {
        String snakeLength = SNAKE_LENGTH_FORMATTER;

        if (snakeLengthPercent < 10) {
            snakeLength = snakeLength.replace("%.2f", "0%.2f");
        }

        return String.format(snakeLength, snakeLengthPercent);
    }

    private String formatGameTime(long gameTime) {
        return String.format(GAME_TIME_FORMATTER,
                TimeUnit.MILLISECONDS.toHours(gameTime),
                TimeUnit.MILLISECONDS.toMinutes(gameTime) -
                        TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(gameTime)),
                TimeUnit.MILLISECONDS.toSeconds(gameTime) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(gameTime)));
    }

    private String formatGameEndDateTime(Date gameEndDateTime) {
        DateFormat dateFormat = new SimpleDateFormat(GAME_END_DATE_TIME_FORMATTER);

        return dateFormat.format(gameEndDateTime);
    }

    public synchronized void storeNewLeaderboardRecord(double snakeLengthPercentage, long gameTimeMillis,
                                                       int horizontalFieldNumber, int verticalFieldNumber,
                                                       String actions, String appleCoordinates) {
        try {
            dataAccessObject.storeNewLeaderboardRecord(snakeLengthPercentage, gameTimeMillis,
                    horizontalFieldNumber, verticalFieldNumber, actions, appleCoordinates);
        } catch (SQLException ignored) {
        }
    }
}
