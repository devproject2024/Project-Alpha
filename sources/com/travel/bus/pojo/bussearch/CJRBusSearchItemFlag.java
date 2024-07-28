package com.travel.bus.pojo.bussearch;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBusSearchItemFlag implements IJRDataModel {
    @b(a = "blocked")
    private Boolean blocked;
    @b(a = "departed")
    private Boolean departed;
    @b(a = "selling_fast")
    private boolean sellingFast;
    @b(a = "sold_out")
    private Boolean soldOut;

    public Boolean getSoldOut() {
        return this.soldOut;
    }

    public void setSoldOut(Boolean bool) {
        this.soldOut = bool;
    }

    public Boolean getDeparted() {
        return this.departed;
    }

    public void setDeparted(Boolean bool) {
        this.departed = bool;
    }

    public void setBlocked(Boolean bool) {
        this.blocked = bool;
    }

    public boolean getSellingFast() {
        return this.sellingFast;
    }

    public void setSellingFast(boolean z) {
        this.sellingFast = z;
    }
}
