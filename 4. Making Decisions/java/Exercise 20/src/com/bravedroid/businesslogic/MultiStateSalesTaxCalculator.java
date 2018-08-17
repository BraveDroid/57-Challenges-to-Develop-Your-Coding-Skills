package com.bravedroid.businesslogic;

import java.text.DecimalFormat;

public class MultiStateSalesTaxCalculator {
    public MultiStateSalesTaxCalculatorVM calculateMultiStateSaleTax(double orderAmount) {
        MultiStateSalesTaxCalculatorVM vm = new MultiStateSalesTaxCalculatorVM();

        final int rateOfTaxInWisconsin = 5;
        double taxInWisconsin = (orderAmount * rateOfTaxInWisconsin) / 100;
        taxInWisconsin = Double.parseDouble(new DecimalFormat("##.###").format(taxInWisconsin));
        vm.setTaxInWisconsin(taxInWisconsin);

        final double rateOfTaxEauClaire = 5.005;
        double taxInEauClaire = (orderAmount * rateOfTaxEauClaire) / 100;
        taxInEauClaire = Double.parseDouble(new DecimalFormat("##.###").format(taxInEauClaire));
        vm.setTaxInEauClaire(taxInEauClaire);

        final double rateOfTaxDunn = 5.004;
        double taxInDunn = (orderAmount * rateOfTaxDunn) / 100;
        taxInDunn = Double.parseDouble(new DecimalFormat("##.###").format(taxInDunn));
        vm.setTaxInDunn(taxInDunn);

        final int rateOfTaxInIllinois = 8;
        double taxInIllinois = (orderAmount * rateOfTaxInIllinois) / 100;
        taxInIllinois = Double.parseDouble(new DecimalFormat("##.###").format(taxInIllinois));
        vm.setTaxInIllinois(taxInIllinois);

        vm.setTaxInOtherState(orderAmount);

        return vm;
    }
}
