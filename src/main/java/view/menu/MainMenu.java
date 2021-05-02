package main.java.view.menu;

import main.java.controller.MainActionListener;
import main.java.resources.menu.SizeCalculator;
import main.java.view.menu.item.button.QuitGameButton;
import main.java.view.menu.item.button.ShowLeaderboardButton;
import main.java.view.menu.item.button.StartNewGameButton;

import java.awt.Dimension;
import java.awt.Insets;

import static main.java.resources.general.CustomColors.MAIN_BACKGROUND_COLOR;
import static main.java.resources.menu.MenuConstants.MAIN_MENU_BUTTON_MARGIN_HORIZONTAL_MULTIPLIER;
import static main.java.resources.menu.MenuConstants.MAIN_MENU_BUTTON_MARGIN_VERTICAL_MULTIPLIER;

public final class MainMenu extends Menu {
    public MainMenu(Dimension windowDimension, boolean isVisible, MainActionListener mainActionListener) {
        super(false, windowDimension, isVisible, mainActionListener);
        setBackground(MAIN_BACKGROUND_COLOR);
        setComponents();
    }

    @Override
    protected void setComponents() {
        StartNewGameButton startNewGameButton = new StartNewGameButton(windowDimension, buttonDimension);
        ShowLeaderboardButton showLeaderboardButton = new ShowLeaderboardButton(windowDimension, buttonDimension);
        QuitGameButton quitGameButton = new QuitGameButton(windowDimension, buttonDimension);

        int buttonHorizontalMargin = SizeCalculator.calculateSizeBasedOnWindowDimension(windowDimension, MAIN_MENU_BUTTON_MARGIN_HORIZONTAL_MULTIPLIER);
        int buttonVerticalMargin = SizeCalculator.calculateSizeBasedOnWindowDimension(windowDimension, MAIN_MENU_BUTTON_MARGIN_VERTICAL_MULTIPLIER);
        gridBagConstraints.insets = new Insets(buttonVerticalMargin, buttonHorizontalMargin,
                buttonVerticalMargin, buttonHorizontalMargin);
        addNewLine();
        add(startNewGameButton, gridBagConstraints);
        addNewLine();
        add(showLeaderboardButton, gridBagConstraints);
        addNewLine();
        add(quitGameButton, gridBagConstraints);

        startNewGameButton.addActionListener(mainActionListener);
        showLeaderboardButton.addActionListener(mainActionListener);
        quitGameButton.addActionListener(mainActionListener);
    }
}
