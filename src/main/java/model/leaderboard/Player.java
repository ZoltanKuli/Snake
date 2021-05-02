package main.java.model.leaderboard;

public final class Player {
    public static final int MIN_PLAYER_NAME_LENGTH = 3;
    public static final int MAX_PLAYER_NAME_LENGTH = 18;

    private String name;

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }
}
