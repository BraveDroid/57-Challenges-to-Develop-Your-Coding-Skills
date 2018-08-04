package com.bravedroid.businesslogic;

public class GallonPaintCalculator {
    public GallonPaintVM calculateGallonPaintVM(double width, double length) {
        GallonPaintVM vm = new GallonPaintVM();
        vm.setSquareFeet(width * length);
        int numberOfGallonPaint = calculateGallonPaint(width, length);
        vm.setCountGallonPaint(numberOfGallonPaint);
        return vm;
    }

    int calculateGallonPaint(double width, double length) {
        final int oneGallonSize = 350;
        double gallonNumber = (width * length) / oneGallonSize;
        if (gallonNumber < 1) {
            return 1;
        }
        if ((width * length) % 350 == 0) {
            return (int) Math.round(gallonNumber);
        } else {
            return (int) gallonNumber + 1;
        }
    }
}