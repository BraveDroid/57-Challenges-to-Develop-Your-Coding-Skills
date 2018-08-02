package com.bravedroid.presenter;

import com.bravedroid.businessLogic.PizzaPartyCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PizzaPartyPrinter {
    private PizzaPartyCalculator pizzaPartyCalculator;
    private String numberOfPersonInString;
    private String numberPizzaInString;
    private int numberOfPerson;
    private int numberOfPizza;

    public PizzaPartyPrinter(PizzaPartyCalculator pizzaPartyCalculator) {
        this.pizzaPartyCalculator = pizzaPartyCalculator;
    }

    public void provideNumberPersonAndPizza() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("How many people?");
        numberOfPersonInString = input.readLine();

        System.out.println("How many pizzas do you have?");
        numberPizzaInString = input.readLine();
    }

    public void printPizzaParty() {
        try {
            numberOfPerson = Integer.parseInt(numberOfPersonInString);
            numberOfPizza = Integer.parseInt(numberPizzaInString);

        } catch (NumberFormatException ex) {
            System.out.println(" the value entered is not numeric.");
        }
        if (numberOfPerson < 1 || numberOfPizza < 1) {
            System.out.println("Input value should be greater than zero!! ");
        }
        int allPizzaSlices = pizzaPartyCalculator.calculateAllPizzaSlices(numberOfPizza);
        int piecesOfPizzaPerPerson = pizzaPartyCalculator.calculatePiecesOfPizzaPerPerson(numberOfPerson, allPizzaSlices);
        int leftoverPieces = pizzaPartyCalculator.calculateLeftoverPieces(piecesOfPizzaPerPerson, allPizzaSlices, numberOfPerson);

        System.out.println(numberOfPerson + " people with " + numberOfPizza + " pizzas");
        System.out.println("Each person gets " + piecesOfPizzaPerPerson + " pieces of pizza.");
        System.out.println("There are " + leftoverPieces + " leftover pieces.");
    }
}
