package com.bravedroid;

import com.bravedroid.businesslogic.BloodAlcoholCalculator;
import com.bravedroid.presenter.BloodAlcoholPrinter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BloodAlcoholCalculator bloodAlcoholCalculator = new BloodAlcoholCalculator();
        BloodAlcoholPrinter bloodAlcoholPrinter = new BloodAlcoholPrinter(bloodAlcoholCalculator);
        bloodAlcoholPrinter.readWeight();
        bloodAlcoholPrinter.readGender();
        bloodAlcoholPrinter.readAmountOfAlcoholConsumed();
        bloodAlcoholPrinter.readNumberOfHoursSinceLastDrink();
        bloodAlcoholPrinter.printBloodAlcoholCalculator();
    }
}
