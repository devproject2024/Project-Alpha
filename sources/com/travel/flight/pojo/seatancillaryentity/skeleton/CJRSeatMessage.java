package com.travel.flight.pojo.seatancillaryentity.skeleton;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRSeatMessage extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @a
    @b(a = "message")
    private final String message;
    @a
    @b(a = "title")
    private final String title;

    public CJRSeatMessage(String str, String str2) {
        this.title = str;
        this.message = str2;
    }

    public String getTitle() {
        return this.title;
    }

    public String getMessage() {
        return this.message;
    }
}
