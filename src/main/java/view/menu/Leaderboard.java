package main.java.view.menu;

import main.java.handler.data.DataHandler;
import main.java.resources.menu.SizeCalculator;
import main.java.view.menu.item.label.UnableToLoadLeaderboardRecords;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Dimension;
import java.awt.Font;

import static javax.swing.BorderFactory.createEmptyBorder;
import static javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS;
import static javax.swing.SwingConstants.LEFT;
import static main.java.resources.general.CustomColors.LEADERBOARD_HEADER_BACKGROUND_COLOR;
import static main.java.resources.general.CustomColors.LEADERBOARD_HEADER_FONT_COLOR;
import static main.java.resources.general.CustomColors.LEADERBOARD_SELECTED_ROW_BACKGROUND_COLOR;
import static main.java.resources.general.CustomColors.MAIN_BACKGROUND_COLOR;
import static main.java.resources.menu.MenuConstants.LEADERBOARD_TABLE_FONT_MULTIPLIER;
import static main.java.resources.menu.MenuConstants.LEADERBOARD_TABLE_HEADER_FONT_MULTIPLIER;
import static main.java.resources.menu.MenuConstants.LEADERBOARD_TABLE_HEIGHT_MULTIPLIER;
import static main.java.resources.menu.MenuTexts.LEADERBOARD_COLUMN_TITLES;

public class Leaderboard extends Menu {

    private final DataHandler dataHandler;

    public Leaderboard(Dimension windowDimension, boolean isVisible, DataHandler dataHandler) {
        super(true, windowDimension, isVisible, null);
        setBackground(MAIN_BACKGROUND_COLOR);

        this.dataHandler = dataHandler;
    }

    @Override
    public void setComponents() {
        removeAll();

        String[][] leaderboardRecords = dataHandler.getLeaderboardRecordsInFormattedStringArray();
        if (leaderboardRecords != null && leaderboardRecords.length != 0) {
            JTable table = new JTable(leaderboardRecords, LEADERBOARD_COLUMN_TITLES) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            table.setOpaque(false);
            table.setBackground(MAIN_BACKGROUND_COLOR);
            table.getTableHeader().setBackground(LEADERBOARD_HEADER_BACKGROUND_COLOR);
            table.getTableHeader().setForeground(LEADERBOARD_HEADER_FONT_COLOR);
            table.setSelectionBackground(LEADERBOARD_SELECTED_ROW_BACKGROUND_COLOR);

            table.getTableHeader().setFont(new Font(table.getTableHeader().getFont().getFontName(), Font.BOLD,
                    SizeCalculator.calculateSizeBasedOnWindowDimension(windowDimension,
                            LEADERBOARD_TABLE_FONT_MULTIPLIER)));
            table.setFont(new Font(table.getFont().getFontName(), Font.PLAIN,
                    SizeCalculator.calculateSizeBasedOnWindowDimension(windowDimension,
                            LEADERBOARD_TABLE_HEADER_FONT_MULTIPLIER)));

            table.setRowHeight(SizeCalculator.calculateSizeBasedOnWindowDimension(windowDimension, LEADERBOARD_TABLE_HEIGHT_MULTIPLIER));
            table.setAutoResizeMode(AUTO_RESIZE_ALL_COLUMNS);

            DefaultTableCellRenderer defaultTableCellRenderer = (DefaultTableCellRenderer)
                    table.getTableHeader().getDefaultRenderer();
            defaultTableCellRenderer.setHorizontalAlignment(LEFT);

            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setPreferredSize(windowDimension);
            scrollPane.setOpaque(false);
            scrollPane.setBorder(createEmptyBorder());

            addNewLine();
            add(scrollPane);
        } else {
            UnableToLoadLeaderboardRecords unableToLoadLeaderboardRecords =
                    new UnableToLoadLeaderboardRecords(windowDimension);

            addNewLine();
            add(unableToLoadLeaderboardRecords, gridBagConstraints);
        }
    }
}
