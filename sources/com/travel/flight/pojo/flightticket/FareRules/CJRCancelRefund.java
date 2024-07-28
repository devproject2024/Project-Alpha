package com.travel.flight.pojo.flightticket.FareRules;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRCancelRefund implements IJRDataModel {
    @b(a = "color")
    private String color;
    @b(a = "label")
    private String label;

    public String getColor() {
        return this.color;
    }

    public String getLabel() {
        return this.label;
    }
}
