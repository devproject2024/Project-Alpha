package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTaxItem implements IJRDataModel {
    @b(a = "name")
    private String name;
    @b(a = "value")
    private double value;

    public String getName() {
        return this.name;
    }

    public double getValue() {
        return this.value;
    }
}
