package main.java.resources.menu;

public final class MenuConstants {

    public final static int MILLIS_BETWEEN_LEADERBOARD_QUERIES = 5000;
    public final static int LEADERBOARD_TIMER_INITIAL_DELAY = 0;

    public final static int PLAYER_NAME_MENU_BUTTON_WIDTH_DIVISOR = 3;
    public final static int PLAYER_NAME_MENU_BUTTON_HEIGHT_DIVISOR = 16;
    public final static double PLAYER_NAME_MENU_LABEL_MARGIN_HORIZONTAL_MULTIPLIER = 1;
    public final static double PLAYER_NAME_MENU_LABEL_MARGIN_VERTICAL_MULTIPLIER = getMarginMultiplier(16);
    public final static double PLAYER_NAME_MENU_TEXT_FIELD_MARGIN_HORIZONTAL_MULTIPLIER = 1;
    public final static double PLAYER_NAME_MENU_TEXT_FIELD_MARGIN_VERTICAL_MULTIPLIER = getMarginMultiplier(12);
    public final static double PLAYER_NAME_MENU_BUTTON_MARGIN_HORIZONTAL_MULTIPLIER = 1;
    public final static double PLAYER_NAME_MENU_BUTTON_MARGIN_VERTICAL_MULTIPLIER = 0.25;
    public final static double GET_PLAYER_NAME_LABEL_FONT_MULTIPLIER = 0.25;
    public final static double GET_PLAYER_NAME_TEXT_FIELD_FONT_MULTIPLIER = 0.25;

    public final static int MENU_BUTTON_WIDTH_DIVISOR = 4;
    public final static int MENU_BUTTON_HEIGHT_DIVISOR = 16;

    public final static double MAIN_MENU_BUTTON_MARGIN_HORIZONTAL_MULTIPLIER = 1;
    public final static double MAIN_MENU_BUTTON_MARGIN_VERTICAL_MULTIPLIER = getMarginMultiplier(16);

    public final static double UNABLE_TO_LOAD_LEADERBOARD_RECORDS_LABEL_FONT_MULTIPLIER = 0.25;
    public final static double LEADERBOARD_TABLE_HEADER_FONT_MULTIPLIER = 0.25;
    public final static double LEADERBOARD_TABLE_FONT_MULTIPLIER = 0.25;
    public final static double LEADERBOARD_TABLE_HEIGHT_MULTIPLIER = 0.75;

    public final static double IN_GAME_MENU_BUTTON_MARGIN_HORIZONTAL_MULTIPLIER = 1;
    public final static double IN_GAME_MENU_BUTTON_MARGIN_VERTICAL_MULTIPLIER = getMarginMultiplier(16);

    public final static int GAME_OVER_MENU_BUTTON_WIDTH_DIVISOR = 5;
    public final static int GAME_OVER_MENU_BUTTON_HEIGHT_DIVISOR = 16;
    public final static double GAME_OVER_MENU_REACTION_LABEL_MARGIN_HORIZONTAL_MULTIPLIER = 1;
    public final static double GAME_OVER_MENU_REACTION_LABEL_MARGIN_VERTICAL_MULTIPLIER = getMarginMultiplier(16);
    public final static double GAME_OVER_MENU_LENGTH_LABEL_MARGIN_HORIZONTAL_MULTIPLIER = 1;
    public final static double GAME_OVER_MENU_LENGTH_LABEL_MARGIN_VERTICAL_MULTIPLIER = getMarginMultiplier(16);
    public final static double GAME_OVER_MENU_BUTTON_MARGIN_HORIZONTAL_MULTIPLIER = 16;
    public final static double GAME_OVER_MENU_BUTTON_MARGIN_VERTICAL_MULTIPLIER = 5;
    public final static double GAME_OVER_MENU_REACTION_LABEL_FONT_MULTIPLIER = 2;
    public final static double GAME_OVER_MENU_LENGTH_LABEL_FONT_MULTIPLIER = 0.25;

    public final static int EXIT_TO_MAIN_MENU_MENU_BUTTON_WIDTH_DIVISOR = 5;
    public final static int EXIT_TO_MAIN_MENU_MENU_BUTTON_HEIGHT_DIVISOR = 16;
    public final static double EXIT_TO_MAIN_MENU_MENU_LABEL_MARGIN_HORIZONTAL_MULTIPLIER = 1;
    public final static double EXIT_TO_MAIN_MENU_MENU_LABEL_MARGIN_VERTICAL_MULTIPLIER = getMarginMultiplier(16);
    public final static double EXIT_TO_MAIN_MENU_MENU_BUTTON_MARGIN_HORIZONTAL_MULTIPLIER = 16;
    public final static double EXIT_TO_MAIN_MENU_MENU_BUTTON_MARGIN_VERTICAL_MULTIPLIER = 5;
    public final static double EXIT_TO_MAIN_MENU_MENU_LABEL_FONT_MULTIPLIER = 0.5;

    public static final int MENU_BUTTON_BACKGROUND_ALPHA_VALUE = 216;
    public final static double MENU_BUTTON_FONT_MULTIPLIER = 0.25;

    private MenuConstants() {
    }

    private static double getMarginMultiplier(double exponent) {
        return 1.0 / Math.pow(2, exponent);
    }
}
