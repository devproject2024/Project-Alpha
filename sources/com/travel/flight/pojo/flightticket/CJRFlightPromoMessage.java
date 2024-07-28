package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFlightPromoMessage implements IJRDataModel {
    @a
    @b(a = "message")
    private String message;
    @a
    @b(a = "title")
    private String title;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }
}
