package com.lastminute.salestaxes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lorentz on 27/04/16.
 */
public class Receipt {

    private List<ReceiptItem> items;
    private double totalTaxes;
    private double totalPrice;

    public Receipt() {
        items = new ArrayList<ReceiptItem>();
    }

    public double getTotalTaxes() {
        return totalTaxes;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public List<ReceiptItem> getItems() {
        return items;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("Output:");
        result.append("\n");

        for (ReceiptItem item : items) {
            result.append(item);
            result.append("\n");
        }

        result.append("SalesTaxes: ").append(totalPrice).append("\n");
        result.append("Total: ").append(totalPrice);

        return result.toString();
    }

    public void addItem(ReceiptItem item) {
        double priceTax = item.getSalesTax();
        totalTaxes += priceTax;
        totalPrice += item.getTotalPrice();
        items.add(item);
    }
}
