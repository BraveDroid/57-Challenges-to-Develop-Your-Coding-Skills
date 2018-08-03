package com.bravedroid.model;

public class PizzaPartyVM {
    private int piecesOfPizzaPerPerson;
    private int leftoverPieces;

    public int getPiecesOfPizzaPerPerson() {
        return piecesOfPizzaPerPerson;
    }

    public void setPiecesOfPizzaPerPerson(int piecesOfPizzaPerPerson) {
        this.piecesOfPizzaPerPerson = piecesOfPizzaPerPerson;
    }

    public int getLeftoverPieces() {
        return leftoverPieces;
    }

    public void setLeftoverPieces(int leftoverPieces) {
        this.leftoverPieces = leftoverPieces;
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof PizzaPartyVM) &&
                this.piecesOfPizzaPerPerson == ((PizzaPartyVM) other).getPiecesOfPizzaPerPerson() &&
                this.leftoverPieces == ((PizzaPartyVM) other).getLeftoverPieces();
    }
}
