package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public final class ModifySearchMessage extends IJRPaytmDataModel {
    @b(a = "icon")
    private final String icon;
    @b(a = "message")
    private final String message;

    public final String getMessage() {
        return this.message;
    }

    public final String getIcon() {
        return this.icon;
    }

    public ModifySearchMessage(String str, String str2) {
        this.message = str;
        this.icon = str2;
    }
}
