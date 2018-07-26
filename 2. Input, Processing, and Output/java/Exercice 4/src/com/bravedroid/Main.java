package com.bravedroid;

import com.bravedroid.presenter.PrinterMadLab;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        PrinterMadLab printerMadLab = new PrinterMadLab();
        printerMadLab.printMadLab();
    }
}
