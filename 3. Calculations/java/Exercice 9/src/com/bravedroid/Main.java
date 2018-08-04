package com.bravedroid;

import com.bravedroid.businesslogic.GallonPaintCalculator;
import com.bravedroid.presenter.GallonsPaintPrinter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        GallonPaintCalculator gallonPaintCalculator = new GallonPaintCalculator();
        GallonsPaintPrinter gallonsPaintPrinter = new GallonsPaintPrinter(gallonPaintCalculator);
        gallonsPaintPrinter.readLengthInFeet();
        gallonsPaintPrinter.readWidthInFeet();
        gallonsPaintPrinter.printGallonsPaint();
    }
}
