package com.bravedroid.businessLogic;

public class TaxCalculator {
    private TaxCalculatorVM vm = new TaxCalculatorVM();

    public TaxCalculatorVM calculateTax(double orderAmount) {
        vm.setSubtotal(orderAmount);
        double rateTax = 5.5;
        double tax = (orderAmount * rateTax) / 100;
        vm.setTax(tax);
        vm.setTotal(orderAmount + tax);
        return vm;
    }
}
