package com.travel.flight.pojo.flightticket.Ancillary;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRAncillaryText implements IJRDataModel {
    @b(a = "display_elements")
    private CJRAncillaryDisplayElement displayElement;

    public CJRAncillaryDisplayElement getDisplayElement() {
        return this.displayElement;
    }
}
