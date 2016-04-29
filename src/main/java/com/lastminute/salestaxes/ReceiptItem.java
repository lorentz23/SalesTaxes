package com.lastminute.salestaxes;

import java.math.BigDecimal;

/**
 * Created by lorentz on 27/04/16.
 */
public class ReceiptItem {

    private int number;
    private String name;
    private double price;
    private Double totalPrice;
    private Double salesTax;
    private SALES_TAX_TYPE[] salesTaxTypes;

    public ReceiptItem(int number, String name, double price, SALES_TAX_TYPE... salesTaxTypes) {
        this.number = number;
        this.name = name;
        this.price = price;
        this.salesTaxTypes = salesTaxTypes;
    }

    public String getName() {
        return name;
    }

    public double getSalesTax() {
        if (salesTax == null) {
            salesTax = 0.0;
            double totalRate = 0;
            for (SALES_TAX_TYPE type : salesTaxTypes) {
                totalRate += type.getRate();
            }

//          salesTax = new BigDecimal(price * totalRate).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            salesTax = Math.round(price * totalRate * 20.0d) / 20.0d;
        }

        return salesTax;
    }

    public double getTotalPrice() {

        if (totalPrice == null) {
            // totalPrice = price + getSalesTax();
            totalPrice = number * new BigDecimal(price + getSalesTax()).setScale(2, BigDecimal.ROUND_HALF_EVEN).doubleValue();
        }

        return totalPrice;
    }

    @Override
    public String toString() {
        return String.valueOf(number) + " " + name + ": " + totalPrice;
    }
}
