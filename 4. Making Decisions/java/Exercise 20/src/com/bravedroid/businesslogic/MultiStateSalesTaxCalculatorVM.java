package com.bravedroid.businesslogic;

import com.bravedroid.businesslogic.util.NumberFormatHelper;

public class MultiStateSalesTaxCalculatorVM {
    private NumberFormatHelper numberFormatHelper = new NumberFormatHelper();
    private double taxInWisconsin;
    private double taxInEauClaire;
    private double taxInDunn;
    private double taxInIllinois;
    private double taxInOtherState;

    public double getTaxInWisconsin() {
        return taxInWisconsin;
    }

    public void setTaxInWisconsin(double taxInWisconsin) {
        this.taxInWisconsin = taxInWisconsin;
    }

    public double getTaxInEauClaire() {
        return numberFormatHelper.formatNumberToTheNearestCent(taxInEauClaire);
    }

    public void setTaxInEauClaire(double taxInEauClaire) {
        this.taxInEauClaire = taxInEauClaire;
    }

    public double getTaxInDunn() {
        return numberFormatHelper.formatNumberToTheNearestCent(taxInDunn);
    }

    public void setTaxInDunn(double taxInDunn) {
        this.taxInDunn = taxInDunn;
    }

    public double getTaxInIllinois() {
        return numberFormatHelper.formatNumberToTheNearestCent(taxInIllinois);
    }

    public void setTaxInIllinois(double taxInIllinois) {
        this.taxInIllinois = taxInIllinois;
    }

    public double getTaxInOtherState() {
        return numberFormatHelper.formatNumberToTheNearestCent(taxInOtherState);
    }

    public void setTaxInOtherState(double taxInOtherState) {
        this.taxInOtherState = taxInOtherState;
    }
}
