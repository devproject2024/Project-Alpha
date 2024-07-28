package com.travel.flight.pojo.flightticket.paxinfo;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRDynamicPaxInfo implements IJRDataModel {
    @b(a = "adult")
    private CJRDynamicPassenger adult;
    @b(a = "child")
    private CJRDynamicPassenger child;
    @b(a = "gst")
    private CJRDynamicPassenger gst;
    @b(a = "infant")
    private CJRDynamicPassenger infant;

    public CJRDynamicPassenger getAdult() {
        return this.adult;
    }

    public CJRDynamicPassenger getChild() {
        return this.child;
    }

    public CJRDynamicPassenger getInfant() {
        return this.infant;
    }

    public CJRDynamicPassenger getGst() {
        return this.gst;
    }
}
