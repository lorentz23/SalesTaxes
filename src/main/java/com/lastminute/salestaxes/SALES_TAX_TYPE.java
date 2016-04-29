package com.lastminute.salestaxes;

/**
 * Created by lorentz on 27/04/16.
 */
public enum SALES_TAX_TYPE {

    BASIC(0.10),
    IMPORTED(0.05),
    EXEMPT(0);

    private double rate;

    SALES_TAX_TYPE(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

    public static SALES_TAX_TYPE getSalesTaxType(String typeStr) {
        for (SALES_TAX_TYPE type : values()) {
            if (type.name().equalsIgnoreCase(typeStr)) {
                return type;
            }
        }

        return null;
    }
}
