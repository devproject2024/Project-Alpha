package com.travel.flight.pojo.flightticket.Ancillary;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRAncillaryItemValidations implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "baggage")
    private CJRAncillaryValidationItem baggage;
    @b(a = "food")
    private CJRAncillaryValidationItem food;

    public CJRAncillaryValidationItem getFood() {
        return this.food;
    }

    public CJRAncillaryValidationItem getBaggage() {
        return this.baggage;
    }
}
