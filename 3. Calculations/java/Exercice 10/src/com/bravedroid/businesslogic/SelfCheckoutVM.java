package com.bravedroid.businesslogic;

public class SelfCheckoutVM {
   private double subtotal;
   private double tax;
   private double total;

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "SelfCheckoutVM{" +
                "subtotal=" + subtotal +
                ", tax=" + tax +
                ", total=" + total +
                '}';
    }
}
