package main.java.view.menu;

import main.java.controller.MainActionListener;
import main.java.resources.menu.SizeCalculator;
import main.java.view.menu.item.button.ExitToMainMenuButton;
import main.java.view.menu.item.button.ResumeGameButton;

import java.awt.Dimension;
import java.awt.Insets;

import static main.java.resources.general.CustomColors.MAIN_BACKGROUND_COLOR;
import static main.java.resources.menu.MenuConstants.IN_GAME_MENU_BUTTON_MARGIN_HORIZONTAL_MULTIPLIER;
import static main.java.resources.menu.MenuConstants.IN_GAME_MENU_BUTTON_MARGIN_VERTICAL_MULTIPLIER;

public final class InGameMenu extends Menu {
    public InGameMenu(Dimension windowDimension, boolean isVisible, MainActionListener mainActionListener) {
        super(false, windowDimension, isVisible, mainActionListener);
        setBackground(MAIN_BACKGROUND_COLOR);
        setComponents();
    }

    @Override
    protected void setComponents() {
        ResumeGameButton resumeGameButton = new ResumeGameButton(windowDimension, buttonDimension);
        ExitToMainMenuButton exitToMainMenuButton = new ExitToMainMenuButton(windowDimension, buttonDimension);

        int buttonHorizontalMargin = SizeCalculator.calculateSizeBasedOnWindowDimension(windowDimension, IN_GAME_MENU_BUTTON_MARGIN_HORIZONTAL_MULTIPLIER);
        int buttonVerticalMargin = SizeCalculator.calculateSizeBasedOnWindowDimension(windowDimension, IN_GAME_MENU_BUTTON_MARGIN_VERTICAL_MULTIPLIER);
        gridBagConstraints.insets = new Insets(buttonVerticalMargin, buttonHorizontalMargin,
                buttonVerticalMargin, buttonHorizontalMargin);
        addNewLine();
        add(resumeGameButton, gridBagConstraints);
        addNewLine();
        add(exitToMainMenuButton, gridBagConstraints);

        resumeGameButton.addActionListener(mainActionListener);
        exitToMainMenuButton.addActionListener(mainActionListener);
    }
}
