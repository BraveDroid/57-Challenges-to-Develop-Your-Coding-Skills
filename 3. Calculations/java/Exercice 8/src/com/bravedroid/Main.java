package com.bravedroid;

import com.bravedroid.businessLogic.PizzaPartyCalculator;
import com.bravedroid.presenter.PizzaPartyPrinter;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        PizzaPartyCalculator pizzaPartyCalculator = new PizzaPartyCalculator();
        PizzaPartyPrinter pizzaPartyPrinter = new PizzaPartyPrinter(pizzaPartyCalculator);
        pizzaPartyPrinter.provideNumberPersonAndPizza();
        pizzaPartyPrinter.printPizzaParty();
    }
}
