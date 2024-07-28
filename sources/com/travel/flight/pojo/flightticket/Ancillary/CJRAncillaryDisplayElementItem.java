package com.travel.flight.pojo.flightticket.Ancillary;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRAncillaryDisplayElementItem implements IJRDataModel {
    @b(a = "description")
    private String description;
    @b(a = "icon")
    private String icon;

    public String getIcon() {
        return this.icon;
    }

    public String getDescription() {
        return this.description;
    }
}
