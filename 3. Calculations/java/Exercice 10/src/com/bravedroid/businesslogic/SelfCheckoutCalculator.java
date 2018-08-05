package com.bravedroid.businesslogic;

import com.bravedroid.presenter.InputDTO;

public class SelfCheckoutCalculator {
    private static final double TAX_RATE = 5.5;

    public SelfCheckoutVM calculateSelfCheckout(InputDTO input) {
        SelfCheckoutVM vm = new SelfCheckoutVM();

        double priceOfItem1 = input.getPriceOfItem1();
        double quantityOfItem1 = input.getQuantityOfItem1();
        double priceOfItem2 = input.getPriceOfItem2();
        double quantityOfItem2 = input.getQuantityOfItem2();
        double priceOfItem3 = input.getPriceOfItem3();
        double quantityOfItem3 = input.getQuantityOfItem3();

        double subtotal = (priceOfItem1 * quantityOfItem1) + (priceOfItem2 * quantityOfItem2) + (priceOfItem3 * quantityOfItem3);
        vm.setSubtotal(subtotal);

        double tax = (subtotal * TAX_RATE) / 100;
        vm.setTax(tax);

        double total = subtotal + tax;
        vm.setTotal(total);

        return vm;
    }
}
