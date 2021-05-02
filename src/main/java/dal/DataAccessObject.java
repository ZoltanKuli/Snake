package main.java.dal;

import main.java.model.leaderboard.LeaderboardRecord;
import main.java.model.leaderboard.Player;
import main.java.model.playback.PlaybackRecord;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static main.java.resources.data.DataConstants.DATABASE_PASSWORD;
import static main.java.resources.data.DataConstants.DATABASE_URL;
import static main.java.resources.data.DataConstants.DATABASE_USER_NAME;

public final class DataAccessObject {

    private final Player player;
    private final List<LeaderboardRecord> leaderboardRecords;
    private final List<PlaybackRecord> playbackRecords;

    public DataAccessObject() {
        player = new Player();
        leaderboardRecords = Collections.synchronizedList(new ArrayList<>());
        playbackRecords = Collections.synchronizedList(new ArrayList<>());
    }

    public synchronized void setPlayerName(String PlayerName) {
        player.setName(PlayerName);
    }

    public synchronized void queryLeaderboardRecords() throws SQLException {
        Connection connection = DriverManager.getConnection(
                DATABASE_URL, DATABASE_USER_NAME, DATABASE_PASSWORD);
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(
                "SELECT player_name, snake_length_percentage, game_time_millis, game_end_timestamp " +
                        "FROM leaderboard ORDER BY snake_length_percentage DESC, game_time_millis ASC");
        setLeaderboardRecords(resultSet);

        connection.close();
    }

    public synchronized List<LeaderboardRecord> getLeaderboardRecords() throws SQLException {
        if (leaderboardRecords.isEmpty()) {
            queryLeaderboardRecords();
        }

        return Collections.synchronizedList(new ArrayList<>(leaderboardRecords));
    }

    private synchronized void setLeaderboardRecords(ResultSet resultSet) throws SQLException {
        leaderboardRecords.clear();

        while (resultSet.next()) {
            LeaderboardRecord leaderboardRecord = new LeaderboardRecord(resultSet.getString(1),
                    resultSet.getInt(2) / 100.0,
                    resultSet.getLong(3), resultSet.getTimestamp(4));

            leaderboardRecords.add(leaderboardRecord);
        }
    }

    public synchronized void queryPlaybackRecords(int horizontalFieldNumber, int verticalFieldNumber) throws SQLException {
        Connection connection = DriverManager.getConnection(
                DATABASE_URL, DATABASE_USER_NAME, DATABASE_PASSWORD);
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(String.format(
                "SELECT actions, apple_coordinates FROM leaderboard WHERE " +
                        "horizontal_field_number = %d AND vertical_field_number = %d " +
                        "ORDER BY snake_length_percentage DESC, game_time_millis ASC",
                horizontalFieldNumber, verticalFieldNumber));
        setPlaybackRecords(resultSet);

        connection.close();
    }

    public synchronized List<PlaybackRecord> getPlaybackRecords(int horizontalFieldNumber, int verticalFieldNumber) throws SQLException {
        queryPlaybackRecords(horizontalFieldNumber, verticalFieldNumber);
        return Collections.synchronizedList(new ArrayList<>(playbackRecords));
    }

    private synchronized void setPlaybackRecords(ResultSet resultSet) throws SQLException {
        playbackRecords.clear();

        while (resultSet.next()) {
            PlaybackRecord playbackRecord = new PlaybackRecord(resultSet.getString(1),
                    resultSet.getString(2));

            playbackRecords.add(playbackRecord);
        }
    }

    public synchronized void storeNewLeaderboardRecord(double snakeLengthPercentage, long gameTimeMillis,
                                                       int horizontalFieldNumber, int verticalFieldNumber,
                                                       String actions, String appleCoordinates) throws SQLException {
        Connection connection = DriverManager.getConnection(
                DATABASE_URL, DATABASE_USER_NAME, DATABASE_PASSWORD);
        Statement statement = connection.createStatement();

        statement.executeUpdate(String.format("INSERT INTO `snake_game`.`leaderboard` (`player_name`, " +
                        "`snake_length_percentage`, `game_time_millis`, `horizontal_field_number`, " +
                        "`vertical_field_number`, `actions`, `apple_coordinates`) " +
                        "VALUES ('%s', '%d', '%s', '%d', '%d', '%s', '%s')",
                player.getName(), (int) Math.floor(snakeLengthPercentage * 100), gameTimeMillis, horizontalFieldNumber,
                verticalFieldNumber, actions, appleCoordinates));

        connection.close();
    }
}
