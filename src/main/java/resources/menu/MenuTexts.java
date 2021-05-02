package main.java.resources.menu;

public final class MenuTexts {
    public final static String TITLE = "Snake";

    public final static String GET_PLAYER_NAME_LABEL_TEXT = "Please enter your name!";
    public final static String SET_PLAYER_NAME_BUTTON_TEXT = "Confirm";

    public final static String START_NEW_GAME_BUTTON_TEXT = "New Game";
    public final static String SHOW_LEADERBOARD_BUTTON_TEXT = "Leaderboard";
    public final static String QUIT_GAME_BUTTON_TEXT = "Quit Game";

    public final static String[] LEADERBOARD_COLUMN_TITLES = new String[]{
            "RANK", "PLAYER NAME", "SNAKE LENGTH", "GAME TIME", "GAME END TIME"
    };
    public final static String UNABLE_TO_LOAD_LEADERBOARD_RECORDS = "We are unable to load any records at this time.";
    public final static String SNAKE_LENGTH_FORMATTER = "%.2f %%";
    public final static String GAME_TIME_FORMATTER = "%02d hrs  %02d min  %02d sec";
    public final static String GAME_END_DATE_TIME_FORMATTER = "MM/dd/yyyy hh:mm aa";

    public final static String RESUME_GAME_BUTTON_TEXT = "Resume Game";
    public final static String EXIT_TO_MAIN_MENU_BUTTON_TEXT = "Exit to Main Menu";

    public final static String EXIT_TO_MAIN_MENU_MENU_LABEL_TEXT = "Are you sure you want to exit?";
    public final static String YES_TO_EXIT_TO_MAIN_MENU_BUTTON_TEXT = "Exit Game";
    public final static String NO_TO_EXIT_TO_MAIN_MENU_BUTTON_TEXT = "Continue Game";

    public final static String GAME_OVER_MENU_REACTION_LABEL_TEXT_LEVEL_0 = "DISAPPOINTING";
    public final static String GAME_OVER_MENU_REACTION_LABEL_TEXT_LEVEL_1 = "PATHETIC";
    public final static String GAME_OVER_MENU_REACTION_LABEL_TEXT_LEVEL_2 = "AWFUL";
    public final static String GAME_OVER_MENU_REACTION_LABEL_TEXT_LEVEL_3 = "AVERAGE";
    public final static String GAME_OVER_MENU_REACTION_LABEL_TEXT_LEVEL_4 = "GOOD";
    public final static String GAME_OVER_MENU_REACTION_LABEL_TEXT_LEVEL_5 = "NICE";
    public final static String GAME_OVER_MENU_REACTION_LABEL_TEXT_LEVEL_6 = "GREAT";
    public final static String GAME_OVER_MENU_REACTION_LABEL_TEXT_LEVEL_7 = "AWESOME";
    public final static String GAME_OVER_MENU_REACTION_LABEL_TEXT_LEVEL_8 = "AMAZING";
    public final static String GAME_OVER_MENU_REACTION_LABEL_TEXT_LEVEL_9 = "ASTOUNDING";
    public final static String GAME_OVER_MENU_REACTION_LABEL_TEXT_LEVEL_10 = "UNBELIEVABLE";
    public final static String GAME_OVER_MENU_LENGTH_LABEL_TEXT_UNTIL_LEVEL_3 = "You grew your snake to only %.2f%% of its maximum length.";
    public final static String GAME_OVER_MENU_LENGTH_LABEL_TEXT_ABOVE_LEVEL_3 = "You grew your snake to %.2f%% of its maximum length.";
    public final static String DIRECTLY_EXIT_TO_MAIN_MENU_BUTTON_TEXT = "Exit to Main Menu";
    public final static String PLAY_AGAIN_BUTTON_TEXT = "Start New Game";

    private MenuTexts() {
    }
}
