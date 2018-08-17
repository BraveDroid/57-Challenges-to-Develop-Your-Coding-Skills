package com.bravedroid.businesslogic;

public class MultiStateSalesTaxCalculator {
    public MultiStateSalesTaxCalculatorVM calculateMultiStateSaleTax(double orderAmount) {
        MultiStateSalesTaxCalculatorVM vm = new MultiStateSalesTaxCalculatorVM();

        final int rateOfTaxInWisconsin = 5;
        double taxInWisconsin = (orderAmount * rateOfTaxInWisconsin) / 100;
        vm.setTaxInWisconsin(taxInWisconsin);

        final double rateOfTaxEauClaire = 5.005;
        double taxInEauClaire = (orderAmount * rateOfTaxEauClaire) / 100;
        vm.setTaxInEauClaire(taxInEauClaire);

        final double rateOfTaxDunn = 5.004;
        double taxInDunn = (orderAmount * rateOfTaxDunn) / 100;
        vm.setTaxInDunn(taxInDunn);

        final int rateOfTaxInIllinois = 8;
        double taxInIllinois = (orderAmount * rateOfTaxInIllinois) / 100;
        vm.setTaxInIllinois(taxInIllinois);

        vm.setTaxInOtherState(orderAmount);

        return vm;
    }
}
