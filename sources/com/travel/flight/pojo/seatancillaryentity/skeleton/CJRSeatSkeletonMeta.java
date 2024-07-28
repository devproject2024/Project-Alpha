package com.travel.flight.pojo.seatancillaryentity.skeleton;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRSeatSkeletonMeta extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
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
