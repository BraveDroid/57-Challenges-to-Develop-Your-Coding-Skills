package com.bravedroid.businessLogic;

public class TaxCalculatorVM {
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
    public boolean equals(Object other) {
        return (other instanceof TaxCalculatorVM) &&
                this.subtotal == ((TaxCalculatorVM) other).getSubtotal() &&
                this.tax == ((TaxCalculatorVM) other).getTax() &&
                this.total == ((TaxCalculatorVM) other).getTotal();
    }
}
