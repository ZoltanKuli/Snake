package main.java.resources.menu;

import java.awt.Dimension;

public final class SizeCalculator {
    private SizeCalculator() {

    }

    public static int calculateSizeBasedOnWindowDimension(Dimension windowDimension, double multiplier) {
        double dimensionMultiple = windowDimension.width * windowDimension.height * multiplier;
        double dimensionMultipleSquaredOnce = Math.sqrt(dimensionMultiple);
        return (int) Math.ceil(Math.sqrt(dimensionMultipleSquaredOnce));
    }
}
