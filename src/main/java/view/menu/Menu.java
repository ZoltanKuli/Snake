package main.java.view.menu;

import main.java.controller.MainActionListener;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import static main.java.resources.menu.MenuConstants.MENU_BUTTON_HEIGHT_DIVISOR;
import static main.java.resources.menu.MenuConstants.MENU_BUTTON_WIDTH_DIVISOR;

abstract class Menu extends JPanel {

    protected final Dimension windowDimension;
    protected final MainActionListener mainActionListener;
    protected Dimension buttonDimension;
    protected GridBagConstraints gridBagConstraints;
    private boolean isVisible;

    protected Menu(boolean isOpaque, Dimension windowDimension, boolean isVisible, MainActionListener mainActionListener) {
        super();
        setOpaque(isOpaque);

        this.windowDimension = windowDimension;
        setSize(windowDimension);
        buttonDimension = new Dimension((int) windowDimension.getWidth() / MENU_BUTTON_WIDTH_DIVISOR,
                (int) windowDimension.getHeight() / MENU_BUTTON_HEIGHT_DIVISOR);

        setLayout(new GridBagLayout());
        gridBagConstraints = new GridBagConstraints();

        this.mainActionListener = mainActionListener;

        setVisible(isVisible);
    }

    protected abstract void setComponents();

    protected void addNewLine() {
        gridBagConstraints.gridy = gridBagConstraints.gridy + 1;
    }

    @Override
    public void setVisible(boolean aFlag) {
        super.setVisible(aFlag);

        isVisible = aFlag;

        revalidate();
    }

    public boolean getIsVisible() {
        return isVisible;
    }
}
