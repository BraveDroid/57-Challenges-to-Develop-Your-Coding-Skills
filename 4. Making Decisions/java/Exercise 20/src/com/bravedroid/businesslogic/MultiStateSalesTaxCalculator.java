package com.bravedroid.businesslogic;

import java.text.DecimalFormat;

public class MultiStateSalesTaxCalculator {
    public MultiStateSalesTaxCalculatorVM calculateMultiStateSaleTax(double orderAmount) {
        MultiStateSalesTaxCalculatorVM vm = new MultiStateSalesTaxCalculatorVM();
        double taxInWisconsin = (orderAmount * 5) / 100;
        taxInWisconsin = Double.parseDouble(new DecimalFormat("##.##").format(taxInWisconsin));
        vm.setTaxInWisconsin(taxInWisconsin);
        double taxInEauClaire = (orderAmount * 5.005) / 100;
        taxInEauClaire = Double.parseDouble(new DecimalFormat("##.##").format(taxInEauClaire));
        vm.setTaxInEauClaire(taxInEauClaire);
        double taxInDunn = (orderAmount * 5.004) / 100;
        taxInDunn = Double.parseDouble(new DecimalFormat("##.##").format(taxInDunn));
        vm.setTaxInDunn(taxInDunn);
        double taxInIllinois = (orderAmount * 8) / 100;
        taxInIllinois = Double.parseDouble(new DecimalFormat("##.##").format(taxInIllinois));
        vm.setTaxInIllinois(taxInIllinois);
        vm.setTaxInOtherState(orderAmount);
        return vm;
    }
}
