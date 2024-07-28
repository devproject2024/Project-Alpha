package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFlightMessage implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "message")
    private String mMessage;
    @b(a = "title")
    private String mTitle;

    public String getmMessage() {
        return this.mMessage;
    }

    public String getmTitle() {
        return this.mTitle;
    }
}
