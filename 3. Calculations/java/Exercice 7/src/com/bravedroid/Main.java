package com.bravedroid;

import com.bravedroid.Businesslogic.AreaCalculator;
import com.bravedroid.presenter.AreaPrinter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        AreaCalculator areaCalculator = new AreaCalculator();
        AreaPrinter areaPrinter = new AreaPrinter(areaCalculator);
        areaPrinter.readSizes();
        areaPrinter.printArea();
    }
}
