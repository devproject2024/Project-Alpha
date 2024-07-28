package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRStatus implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "message")
    private CJRFlightMessage mFlightMesssgae;
    @b(a = "result")
    private String mResult;

    public static long getSerialVersionUID() {
        return 1;
    }

    public String getmResult() {
        return this.mResult;
    }

    public void setmResult(String str) {
        this.mResult = str;
    }

    public CJRFlightMessage getmFlightMesssgae() {
        return this.mFlightMesssgae;
    }
}
