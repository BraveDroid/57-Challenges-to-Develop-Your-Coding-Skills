package com.bravedroid.presenter;

import com.bravedroid.businessLogic.PizzaPartyCalculator;
import com.bravedroid.model.PizzaPartyVM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PizzaPartyPrinter {
    private static final String REQUEST_MESSAGE_PEOPLE_COUNT = "How many people?";
    private static final String REQUEST_MESSAGE_PIZZA_COUNT = "How many pizzas do you have?";
    private static final String ERROR_MESSAGE_NOT_NUMERIC_INPUT = " the value entered is not numeric or not an integer.";

    private BufferedReader input;
    private PizzaPartyCalculator pizzaPartyCalculator;
    private int numberOfPerson;
    private int numberOfPizza;
    private boolean mustExit;

    public PizzaPartyPrinter(PizzaPartyCalculator pizzaPartyCalculator) {
        input = new BufferedReader(new InputStreamReader(System.in));
        this.pizzaPartyCalculator = pizzaPartyCalculator;
    }

    public void readNumberPerson() throws IOException {
        System.out.println(REQUEST_MESSAGE_PEOPLE_COUNT);
        try {
            String numberOfPersonInString = input.readLine();
            if (numberOfPersonInString.equals("exit")) {
                mustExit = true;
                return;
            }
            numberOfPerson = Integer.parseInt(numberOfPersonInString);
            validateNumIsGreaterThanZero(numberOfPerson);
        } catch (NumberFormatException ex) {
            System.out.println(ERROR_MESSAGE_NOT_NUMERIC_INPUT);
            readNumberPerson();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            readNumberPerson();
        }
    }

    public void readNumberPizza() throws IOException {
        if (mustExit) return;
        System.out.println(REQUEST_MESSAGE_PIZZA_COUNT);
        try {
            String numberPizzaInString = input.readLine();
            if (numberPizzaInString.equals("exit")) {
                mustExit = true;
                return;
            }
            numberOfPizza = Integer.parseInt(numberPizzaInString);
            validateNumIsGreaterThanZero(numberOfPizza);
        } catch (NumberFormatException ex) {
            System.out.println(ERROR_MESSAGE_NOT_NUMERIC_INPUT);
            readNumberPizza();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            readNumberPizza();
        }
    }

    public void printPizzaParty() {
        if (mustExit) return;
        if (numberOfPizza == 0 || numberOfPerson == 0)
            return;

        PizzaPartyVM vm = pizzaPartyCalculator.calculatePartitions(numberOfPizza, numberOfPerson);
        int piecesOfPizzaPerPerson = vm.getPiecesOfPizzaPerPerson();
        int leftoverPieces = vm.getLeftoverPieces();

        System.out.println(numberOfPerson + " people with " + numberOfPizza + " pizzas");
        System.out.println("Each person gets " + piecesOfPizzaPerPerson + " pieces of pizza.");
        System.out.println("There are " + leftoverPieces + " leftover pieces.");
    }

    private void validateNumIsGreaterThanZero(int number) {
        if (number < 1)
            throw new IllegalArgumentException("Input value should be greater than zero!! ");
    }
}
