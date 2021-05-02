package main.java.view.menu;

import main.java.controller.MainActionListener;
import main.java.resources.menu.SizeCalculator;
import main.java.view.menu.item.button.SetPlayerNameButton;
import main.java.view.menu.item.input.GetPlayerNameTextField;
import main.java.view.menu.item.input.GetPlayerNameTextFieldListener;
import main.java.view.menu.item.label.GetPlayerNameLabel;

import java.awt.Dimension;
import java.awt.Insets;

import static main.java.resources.general.CustomColors.MAIN_BACKGROUND_COLOR;
import static main.java.resources.menu.MenuConstants.PLAYER_NAME_MENU_BUTTON_HEIGHT_DIVISOR;
import static main.java.resources.menu.MenuConstants.PLAYER_NAME_MENU_BUTTON_MARGIN_HORIZONTAL_MULTIPLIER;
import static main.java.resources.menu.MenuConstants.PLAYER_NAME_MENU_BUTTON_MARGIN_VERTICAL_MULTIPLIER;
import static main.java.resources.menu.MenuConstants.PLAYER_NAME_MENU_BUTTON_WIDTH_DIVISOR;
import static main.java.resources.menu.MenuConstants.PLAYER_NAME_MENU_LABEL_MARGIN_HORIZONTAL_MULTIPLIER;
import static main.java.resources.menu.MenuConstants.PLAYER_NAME_MENU_LABEL_MARGIN_VERTICAL_MULTIPLIER;
import static main.java.resources.menu.MenuConstants.PLAYER_NAME_MENU_TEXT_FIELD_MARGIN_HORIZONTAL_MULTIPLIER;
import static main.java.resources.menu.MenuConstants.PLAYER_NAME_MENU_TEXT_FIELD_MARGIN_VERTICAL_MULTIPLIER;

public final class PlayerNameMenu extends Menu {
    public PlayerNameMenu(Dimension windowDimension, boolean isVisible, MainActionListener mainActionListener) {
        super(true, windowDimension, isVisible, mainActionListener);
        buttonDimension = new Dimension((int) windowDimension.getWidth() / PLAYER_NAME_MENU_BUTTON_WIDTH_DIVISOR,
                (int) windowDimension.getHeight() / PLAYER_NAME_MENU_BUTTON_HEIGHT_DIVISOR);
        setBackground(MAIN_BACKGROUND_COLOR);
        setComponents();
    }

    @Override
    protected void setComponents() {
        GetPlayerNameLabel getPlayerNameLabel = new GetPlayerNameLabel(windowDimension);
        GetPlayerNameTextField getPlayerNameTextField = new GetPlayerNameTextField(windowDimension);
        SetPlayerNameButton setPlayerNameButton = new SetPlayerNameButton(windowDimension, buttonDimension, getPlayerNameTextField);

        int getPlayerNameLabelHorizontalMargin = SizeCalculator.calculateSizeBasedOnWindowDimension(windowDimension, PLAYER_NAME_MENU_LABEL_MARGIN_HORIZONTAL_MULTIPLIER);
        int getPlayerNameLabelVerticalMargin = SizeCalculator.calculateSizeBasedOnWindowDimension(windowDimension, PLAYER_NAME_MENU_LABEL_MARGIN_VERTICAL_MULTIPLIER);
        gridBagConstraints.insets = new Insets(getPlayerNameLabelVerticalMargin, getPlayerNameLabelHorizontalMargin,
                getPlayerNameLabelVerticalMargin, getPlayerNameLabelHorizontalMargin);
        addNewLine();
        add(getPlayerNameLabel, gridBagConstraints);

        int getPlayerNameTextFieldHorizontalMargin = SizeCalculator.calculateSizeBasedOnWindowDimension(windowDimension, PLAYER_NAME_MENU_TEXT_FIELD_MARGIN_HORIZONTAL_MULTIPLIER);
        int getPlayerNameTextFieldVerticalMargin = SizeCalculator.calculateSizeBasedOnWindowDimension(windowDimension, PLAYER_NAME_MENU_TEXT_FIELD_MARGIN_VERTICAL_MULTIPLIER);
        gridBagConstraints.insets = new Insets(getPlayerNameTextFieldVerticalMargin, getPlayerNameTextFieldHorizontalMargin,
                getPlayerNameTextFieldVerticalMargin, getPlayerNameTextFieldHorizontalMargin);
        addNewLine();
        add(getPlayerNameTextField, gridBagConstraints);

        int setPlayerNameButtonHorizontalMargin = SizeCalculator.calculateSizeBasedOnWindowDimension(windowDimension, PLAYER_NAME_MENU_BUTTON_MARGIN_HORIZONTAL_MULTIPLIER);
        int setPlayerNameButtonVerticalMargin = SizeCalculator.calculateSizeBasedOnWindowDimension(windowDimension, PLAYER_NAME_MENU_BUTTON_MARGIN_VERTICAL_MULTIPLIER);
        gridBagConstraints.insets = new Insets(setPlayerNameButtonVerticalMargin, setPlayerNameButtonHorizontalMargin,
                setPlayerNameButtonVerticalMargin, setPlayerNameButtonHorizontalMargin);
        addNewLine();
        add(setPlayerNameButton, gridBagConstraints);

        mainActionListener.setSetPlayerNameButtonActivationOnEnter(getPlayerNameTextField, setPlayerNameButton);
        setPlayerNameButton.addActionListener(mainActionListener);
        getPlayerNameTextField.addActionListener(mainActionListener);
        getPlayerNameTextField.getDocument().addDocumentListener(new GetPlayerNameTextFieldListener(getPlayerNameTextField, setPlayerNameButton));
    }
}
