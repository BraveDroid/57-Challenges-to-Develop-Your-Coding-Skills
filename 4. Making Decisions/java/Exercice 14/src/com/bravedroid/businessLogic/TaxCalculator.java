package com.bravedroid.businessLogic;

public class TaxCalculator {
    public TaxCalculatorVM calculateTax(double orderAmount) {
        TaxCalculatorVM vm = new TaxCalculatorVM();
        vm.setSubtotal(orderAmount);
        final double rateTax = 5.5;
        double tax = (orderAmount * rateTax) / 100;
        vm.setTax(tax);
        vm.setTotal(orderAmount + tax);
        return vm;
    }
}
