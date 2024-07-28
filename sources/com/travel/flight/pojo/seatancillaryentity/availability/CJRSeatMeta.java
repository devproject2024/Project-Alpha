package com.travel.flight.pojo.seatancillaryentity.availability;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRSeatMeta extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @a
    @b(a = "meta")
    private final String requestid;

    public CJRSeatMeta(String str) {
        this.requestid = str;
    }

    public String getRequestid() {
        return this.requestid;
    }
}
