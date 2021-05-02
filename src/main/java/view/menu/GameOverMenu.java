package main.java.view.menu;

import main.java.controller.MainActionListener;
import main.java.resources.menu.SizeCalculator;
import main.java.view.menu.item.button.DirectlyExitToMainMenuButton;
import main.java.view.menu.item.button.PlayAgainButton;
import main.java.view.menu.item.label.GameOverMenuLengthLabel;
import main.java.view.menu.item.label.GameOverMenuReactionLabel;

import java.awt.Dimension;
import java.awt.Insets;

import static main.java.resources.general.CustomColors.MAIN_BACKGROUND_COLOR;
import static main.java.resources.menu.MenuConstants.GAME_OVER_MENU_BUTTON_HEIGHT_DIVISOR;
import static main.java.resources.menu.MenuConstants.GAME_OVER_MENU_BUTTON_MARGIN_HORIZONTAL_MULTIPLIER;
import static main.java.resources.menu.MenuConstants.GAME_OVER_MENU_BUTTON_MARGIN_VERTICAL_MULTIPLIER;
import static main.java.resources.menu.MenuConstants.GAME_OVER_MENU_BUTTON_WIDTH_DIVISOR;
import static main.java.resources.menu.MenuConstants.GAME_OVER_MENU_LENGTH_LABEL_MARGIN_HORIZONTAL_MULTIPLIER;
import static main.java.resources.menu.MenuConstants.GAME_OVER_MENU_LENGTH_LABEL_MARGIN_VERTICAL_MULTIPLIER;
import static main.java.resources.menu.MenuConstants.GAME_OVER_MENU_REACTION_LABEL_MARGIN_HORIZONTAL_MULTIPLIER;
import static main.java.resources.menu.MenuConstants.GAME_OVER_MENU_REACTION_LABEL_MARGIN_VERTICAL_MULTIPLIER;

public final class GameOverMenu extends Menu {

    private GameOverMenuReactionLabel gameOverMenuReactionLabel;
    private GameOverMenuLengthLabel gameOverMenuLengthLabel;

    public GameOverMenu(Dimension windowDimension, boolean isVisible, MainActionListener mainActionListener) {
        super(true, windowDimension, isVisible, mainActionListener);
        buttonDimension = new Dimension((int) windowDimension.getWidth() / GAME_OVER_MENU_BUTTON_WIDTH_DIVISOR,
                (int) windowDimension.getHeight() / GAME_OVER_MENU_BUTTON_HEIGHT_DIVISOR);
        setBackground(MAIN_BACKGROUND_COLOR);
        setComponents();
    }

    @Override
    protected void setComponents() {
        gameOverMenuReactionLabel = new GameOverMenuReactionLabel(windowDimension);
        gameOverMenuLengthLabel = new GameOverMenuLengthLabel(windowDimension);
        DirectlyExitToMainMenuButton directlyExitToMainMenuButton = new DirectlyExitToMainMenuButton(windowDimension, buttonDimension);
        PlayAgainButton playAgainButton = new PlayAgainButton(windowDimension, buttonDimension);

        int gameOverMenuReactionLabelHorizontalMargin = SizeCalculator.calculateSizeBasedOnWindowDimension(windowDimension, GAME_OVER_MENU_REACTION_LABEL_MARGIN_HORIZONTAL_MULTIPLIER);
        int gameOverMenuReactionLabelVerticalMargin = SizeCalculator.calculateSizeBasedOnWindowDimension(windowDimension, GAME_OVER_MENU_REACTION_LABEL_MARGIN_VERTICAL_MULTIPLIER);
        gridBagConstraints.insets = new Insets(gameOverMenuReactionLabelVerticalMargin, gameOverMenuReactionLabelHorizontalMargin,
                gameOverMenuReactionLabelVerticalMargin, gameOverMenuReactionLabelHorizontalMargin);
        gridBagConstraints.gridwidth = 2;
        addNewLine();
        add(gameOverMenuReactionLabel, gridBagConstraints);

        int gameOverMenuLengthLabelHorizontalMargin = SizeCalculator.calculateSizeBasedOnWindowDimension(windowDimension, GAME_OVER_MENU_LENGTH_LABEL_MARGIN_HORIZONTAL_MULTIPLIER);
        int gameOverMenuLengthLabelVerticalMargin = SizeCalculator.calculateSizeBasedOnWindowDimension(windowDimension, GAME_OVER_MENU_LENGTH_LABEL_MARGIN_VERTICAL_MULTIPLIER);
        gridBagConstraints.insets = new Insets(gameOverMenuLengthLabelVerticalMargin, gameOverMenuLengthLabelHorizontalMargin,
                gameOverMenuLengthLabelVerticalMargin, gameOverMenuLengthLabelHorizontalMargin);
        addNewLine();
        add(gameOverMenuLengthLabel, gridBagConstraints);

        int buttonHorizontalMargin = SizeCalculator.calculateSizeBasedOnWindowDimension(windowDimension, GAME_OVER_MENU_BUTTON_MARGIN_HORIZONTAL_MULTIPLIER);
        int buttonVerticalMargin = SizeCalculator.calculateSizeBasedOnWindowDimension(windowDimension, GAME_OVER_MENU_BUTTON_MARGIN_VERTICAL_MULTIPLIER);
        gridBagConstraints.insets = new Insets(buttonVerticalMargin, buttonHorizontalMargin,
                buttonVerticalMargin, buttonHorizontalMargin);
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 0;
        addNewLine();
        add(directlyExitToMainMenuButton, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        add(playAgainButton, gridBagConstraints);

        directlyExitToMainMenuButton.addActionListener(mainActionListener);
        playAgainButton.addActionListener(mainActionListener);
    }

    public void updateTexts(double snakeLengthPercentage) {
        gameOverMenuReactionLabel.updateText(snakeLengthPercentage);
        gameOverMenuLengthLabel.updateText(snakeLengthPercentage);
    }
}
