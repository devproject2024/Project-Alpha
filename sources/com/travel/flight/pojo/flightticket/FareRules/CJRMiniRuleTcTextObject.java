package com.travel.flight.pojo.flightticket.FareRules;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMiniRuleTcTextObject implements IJRDataModel {
    @b(a = "message")
    private String message;
    @b(a = "visible")
    private boolean visible;

    public String getMessage() {
        return this.message;
    }

    public boolean isVisible() {
        return this.visible;
    }
}
