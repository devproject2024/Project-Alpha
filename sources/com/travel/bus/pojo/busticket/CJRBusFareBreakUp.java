package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBusFareBreakUp implements IJRDataModel {
    @b(a = "fareDetails")
    private CJRBusTicketFareDetails fareDetails;

    public CJRBusTicketFareDetails getFareDetails() {
        return this.fareDetails;
    }
}
