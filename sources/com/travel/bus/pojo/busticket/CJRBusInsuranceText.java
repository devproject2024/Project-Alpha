package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBusInsuranceText implements IJRDataModel {
    @b(a = "Onward")
    private CJRBusOnwardTrip onwardTrip;
    @b(a = "Return")
    private CJRBusReturnTrip returnTrip;

    public CJRBusOnwardTrip getOnward() {
        return this.onwardTrip;
    }

    public void setOnward(CJRBusOnwardTrip cJRBusOnwardTrip) {
        this.onwardTrip = cJRBusOnwardTrip;
    }

    public CJRBusReturnTrip getReturn() {
        return this.returnTrip;
    }

    public void setReturn(CJRBusReturnTrip cJRBusReturnTrip) {
        this.returnTrip = cJRBusReturnTrip;
    }
}
