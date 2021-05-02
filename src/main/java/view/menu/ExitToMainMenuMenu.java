package main.java.view.menu;

import main.java.controller.MainActionListener;
import main.java.resources.menu.SizeCalculator;
import main.java.view.menu.item.button.NoToExitToMainMenuButton;
import main.java.view.menu.item.button.YesToExitToMainMenuButton;
import main.java.view.menu.item.label.ExitToMainMenuMenuLabel;

import java.awt.Dimension;
import java.awt.Insets;

import static main.java.resources.general.CustomColors.MAIN_BACKGROUND_COLOR;
import static main.java.resources.menu.MenuConstants.EXIT_TO_MAIN_MENU_MENU_BUTTON_HEIGHT_DIVISOR;
import static main.java.resources.menu.MenuConstants.EXIT_TO_MAIN_MENU_MENU_BUTTON_MARGIN_HORIZONTAL_MULTIPLIER;
import static main.java.resources.menu.MenuConstants.EXIT_TO_MAIN_MENU_MENU_BUTTON_MARGIN_VERTICAL_MULTIPLIER;
import static main.java.resources.menu.MenuConstants.EXIT_TO_MAIN_MENU_MENU_BUTTON_WIDTH_DIVISOR;
import static main.java.resources.menu.MenuConstants.EXIT_TO_MAIN_MENU_MENU_LABEL_MARGIN_HORIZONTAL_MULTIPLIER;
import static main.java.resources.menu.MenuConstants.EXIT_TO_MAIN_MENU_MENU_LABEL_MARGIN_VERTICAL_MULTIPLIER;

public final class ExitToMainMenuMenu extends Menu {
    public ExitToMainMenuMenu(Dimension windowDimension, boolean isVisible, MainActionListener mainActionListener) {
        super(true, windowDimension, isVisible, mainActionListener);
        buttonDimension = new Dimension((int) windowDimension.getWidth() / EXIT_TO_MAIN_MENU_MENU_BUTTON_WIDTH_DIVISOR,
                (int) windowDimension.getHeight() / EXIT_TO_MAIN_MENU_MENU_BUTTON_HEIGHT_DIVISOR);
        setBackground(MAIN_BACKGROUND_COLOR);
        setComponents();
    }

    @Override
    protected void setComponents() {
        ExitToMainMenuMenuLabel exitToMainMenuMenuLabel = new ExitToMainMenuMenuLabel(windowDimension);
        NoToExitToMainMenuButton noToExitToMainMenuButton = new NoToExitToMainMenuButton(windowDimension, buttonDimension);
        YesToExitToMainMenuButton yesToExitToMainMenuButton = new YesToExitToMainMenuButton(windowDimension, buttonDimension);

        int exitToMainMenuMenuLabelHorizontalMargin = SizeCalculator.calculateSizeBasedOnWindowDimension(windowDimension, EXIT_TO_MAIN_MENU_MENU_LABEL_MARGIN_HORIZONTAL_MULTIPLIER);
        int exitToMainMenuMenuLabelVerticalMargin = SizeCalculator.calculateSizeBasedOnWindowDimension(windowDimension, EXIT_TO_MAIN_MENU_MENU_LABEL_MARGIN_VERTICAL_MULTIPLIER);
        gridBagConstraints.insets = new Insets(exitToMainMenuMenuLabelVerticalMargin, exitToMainMenuMenuLabelHorizontalMargin,
                exitToMainMenuMenuLabelVerticalMargin, exitToMainMenuMenuLabelHorizontalMargin);
        gridBagConstraints.gridwidth = 2;
        addNewLine();
        add(exitToMainMenuMenuLabel, gridBagConstraints);

        int buttonHorizontalMargin = SizeCalculator.calculateSizeBasedOnWindowDimension(windowDimension, EXIT_TO_MAIN_MENU_MENU_BUTTON_MARGIN_HORIZONTAL_MULTIPLIER);
        int buttonVerticalMargin = SizeCalculator.calculateSizeBasedOnWindowDimension(windowDimension, EXIT_TO_MAIN_MENU_MENU_BUTTON_MARGIN_VERTICAL_MULTIPLIER);
        gridBagConstraints.insets = new Insets(buttonVerticalMargin, buttonHorizontalMargin,
                buttonVerticalMargin, buttonHorizontalMargin);
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 0;
        addNewLine();
        add(noToExitToMainMenuButton, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        add(yesToExitToMainMenuButton, gridBagConstraints);

        noToExitToMainMenuButton.addActionListener(mainActionListener);
        yesToExitToMainMenuButton.addActionListener(mainActionListener);
    }
}
