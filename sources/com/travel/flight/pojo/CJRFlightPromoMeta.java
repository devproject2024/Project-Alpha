package com.travel.flight.pojo;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFlightPromoMeta implements IJRDataModel {
    @a
    @b(a = "requestid")
    private String requestid;

    public String getRequestid() {
        return this.requestid;
    }

    public void setRequestid(String str) {
        this.requestid = str;
    }
}
