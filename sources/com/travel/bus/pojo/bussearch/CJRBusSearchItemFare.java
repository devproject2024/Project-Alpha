package com.travel.bus.pojo.bussearch;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBusSearchItemFare implements IJRDataModel {
    @a
    @b(a = "prices")
    private double[] prices = null;
    @a
    @b(a = "tax_inclusive")
    private Boolean taxInclusive;

    public void setTaxInclusive(Boolean bool) {
        this.taxInclusive = bool;
    }

    public double[] getPrices() {
        return this.prices;
    }

    public void setPrices(double[] dArr) {
        this.prices = dArr;
    }
}
