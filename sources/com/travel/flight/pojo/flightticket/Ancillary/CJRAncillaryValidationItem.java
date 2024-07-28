package com.travel.flight.pojo.flightticket.Ancillary;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRAncillaryValidationItem implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "max")
    private Integer max;

    public Integer getMax() {
        return this.max;
    }
}
