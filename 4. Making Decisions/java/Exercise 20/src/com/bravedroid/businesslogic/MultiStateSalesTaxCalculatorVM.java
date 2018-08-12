package com.bravedroid.businesslogic;

public class MultiStateSalesTaxCalculatorVM {
    private double taxInWisconsin;
    private double taxInEauClaire;
    private double taxInDunn;
    private double taxInIllinois;
    private double TaxInOtherState;

    public double getTaxInWisconsin() {
        return taxInWisconsin;
    }

    public void setTaxInWisconsin(double taxInWisconsin) {
        this.taxInWisconsin = taxInWisconsin;
    }

    public double getTaxInEauClaire() {
        return taxInEauClaire;
    }

    public void setTaxInEauClaire(double taxInEauClaire) {
        this.taxInEauClaire = taxInEauClaire;
    }

    public double getTaxInDunn() {
        return taxInDunn;
    }

    public void setTaxInDunn(double taxInDunn) {
        this.taxInDunn = taxInDunn;
    }

    public double getTaxInIllinois() {
        return taxInIllinois;
    }

    public void setTaxInIllinois(double taxInIllinois) {
        this.taxInIllinois = taxInIllinois;
    }

    public double getTaxInOtherState() {
        return TaxInOtherState;
    }

    public void setTaxInOtherState(double taxInOtherState) {
        TaxInOtherState = taxInOtherState;
    }
}
