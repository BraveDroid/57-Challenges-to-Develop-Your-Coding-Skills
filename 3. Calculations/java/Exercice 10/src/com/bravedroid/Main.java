package com.bravedroid;

import com.bravedroid.businesslogic.SelfCheckoutCalculator;
import com.bravedroid.presenter.Presenter;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
       SelfCheckoutCalculator selfCheckoutCalculator = new SelfCheckoutCalculator();
       Presenter presenter = new Presenter(selfCheckoutCalculator);
       presenter.readPriceOfItem1();
       presenter.readQuantityOfItem1();
       presenter.readPriceOfItem2();
       presenter.readQuantityOfItem2();
       presenter.readPriceOfItem3();
       presenter.readQuantityOfItem3();

       presenter.printSelfCheckout();
    }
}
