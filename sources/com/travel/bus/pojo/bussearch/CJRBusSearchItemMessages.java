package com.travel.bus.pojo.bussearch;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBusSearchItemMessages implements IJRDataModel {
    @b(a = "blocked")
    private String blocked;
    @b(a = "departed")
    private String departed;
    @b(a = "sold_out")
    private String soldOut;

    public String getSoldOut() {
        return this.soldOut;
    }

    public void setSoldOut(String str) {
        this.soldOut = str;
    }

    public String getBlocked() {
        return this.blocked;
    }

    public void setBlocked(String str) {
        this.blocked = str;
    }

    public String getDeparted() {
        return this.departed;
    }

    public void setDeparted(String str) {
        this.departed = str;
    }
}
