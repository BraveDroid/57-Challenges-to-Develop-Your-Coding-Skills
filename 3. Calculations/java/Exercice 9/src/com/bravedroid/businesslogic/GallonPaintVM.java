package com.bravedroid.businesslogic;

public class GallonPaintVM {
    private double squareFeet;
    private int countGallonPaint;

    public double getSquareFeet() {
        return squareFeet;
    }

    public void setSquareFeet(double squareFeet) {
        this.squareFeet = squareFeet;
    }

    public int getCountGallonPaint() {
        return countGallonPaint;
    }

    public void setCountGallonPaint(int countGallonPaint) {
        this.countGallonPaint = countGallonPaint;
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof GallonPaintVM) &&
                this.squareFeet == ((GallonPaintVM) other).getSquareFeet() &&
                this.countGallonPaint == ((GallonPaintVM) other).getCountGallonPaint();
    }
}
