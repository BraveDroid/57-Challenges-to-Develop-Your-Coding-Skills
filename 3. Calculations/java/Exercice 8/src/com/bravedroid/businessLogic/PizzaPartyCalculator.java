package com.bravedroid.businessLogic;

public class PizzaPartyCalculator {
    public int calculateAllPizzaSlices(int numberPizza) {
        return numberPizza * 8;
    }

    public int calculatePiecesOfPizzaPerPerson(int numberOfPerson, int allPizzaSlices) {
        return allPizzaSlices / numberOfPerson;
    }

    public int calculateLeftoverPieces(int piecesOfPizzaPerPerson, int allPizzaSlices, int numberOfPerson) {
        int leftOverPieces = allPizzaSlices - (piecesOfPizzaPerPerson * numberOfPerson);
        if (leftOverPieces < 1) {
            return 0;
        } else {
            return leftOverPieces;
        }
    }
}

