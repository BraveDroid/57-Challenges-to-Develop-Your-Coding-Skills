package com.bravedroid.presenter;

public class InputFormUserDTO {
    private double weight;
    private String gender;
    private double amountOfAlcoholConsumed;
    private double amountOfTimeSinceLastDrink;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getAmountOfAlcoholConsumed() {
        return amountOfAlcoholConsumed;
    }

    public void setAmountOfAlcoholConsumed(double amountOfAlcoholByVolume) {
        this.amountOfAlcoholConsumed = amountOfAlcoholByVolume;
    }

    public double getAmountOfTimeSinceLastDrink() {
        return amountOfTimeSinceLastDrink;
    }

    public void setAmountOfTimeSinceLastDrink(double amountOfTimeSinceLastDrink) {
        this.amountOfTimeSinceLastDrink = amountOfTimeSinceLastDrink;
    }
}
