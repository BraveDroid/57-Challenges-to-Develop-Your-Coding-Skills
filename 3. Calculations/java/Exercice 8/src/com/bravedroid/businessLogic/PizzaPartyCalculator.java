package com.bravedroid.businessLogic;

import com.bravedroid.model.PizzaPartyVM;

public class PizzaPartyCalculator {
    private static final int SLICE_PER_PIZZA = 8;

    public PizzaPartyVM calculatePartitions(int numberOfPizza, int numberOfPerson) {
        PizzaPartyVM vm = new PizzaPartyVM();
        vm.setPiecesOfPizzaPerPerson(numberOfPizza * SLICE_PER_PIZZA / numberOfPerson);
        vm.setLeftoverPieces(numberOfPizza * SLICE_PER_PIZZA % numberOfPerson);
        return vm;
    }
}
