package com.travel.flight.pojo.seatancillaryentity.skeleton;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRSeatStatus extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @a
    @b(a = "message")
    private final CJRSeatMessage CJRSeatMessage;
    @a
    @b(a = "result")
    private final String result;

    public CJRSeatStatus(String str, CJRSeatMessage cJRSeatMessage) {
        this.result = str;
        this.CJRSeatMessage = cJRSeatMessage;
    }

    public String getResult() {
        return this.result;
    }

    public CJRSeatMessage getCJRSeatMessage() {
        return this.CJRSeatMessage;
    }
}
