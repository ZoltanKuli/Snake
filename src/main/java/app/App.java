package main.java.app;

import com.formdev.flatlaf.FlatIntelliJLaf;

public class App {

    public static void main(String[] args) {
        System.setProperty("sun.java2d.uiScale", "1.0");

        FlatIntelliJLaf.install();

        new MainFrame();
    }
}
