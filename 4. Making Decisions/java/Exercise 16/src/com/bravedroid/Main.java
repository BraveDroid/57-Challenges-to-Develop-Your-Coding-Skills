package com.bravedroid;

import com.bravedroid.presenter.LegalDrivingAgePrinter;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        LegalDrivingAgePrinter legalDrivingAgePrinter=new LegalDrivingAgePrinter();
        legalDrivingAgePrinter.readAge();
        legalDrivingAgePrinter.printLegalDrivingAge();
    }
}
