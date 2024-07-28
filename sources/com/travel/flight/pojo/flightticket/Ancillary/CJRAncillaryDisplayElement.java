package com.travel.flight.pojo.flightticket.Ancillary;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRAncillaryDisplayElement implements IJRDataModel {
    @b(a = "baggage")
    private CJRAncillaryDisplayElementItem baggage;
    @b(a = "food")
    private CJRAncillaryDisplayElementItem food;

    public CJRAncillaryDisplayElementItem getFood() {
        return this.food;
    }

    public CJRAncillaryDisplayElementItem getBaggage() {
        return this.baggage;
    }
}
