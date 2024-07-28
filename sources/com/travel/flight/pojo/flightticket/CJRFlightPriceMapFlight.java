package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFlightPriceMapFlight implements IJRDataModel {
    @b(a = "display_price")
    private String displayPrice;
    @b(a = "provider")
    private String providerName;
    @b(a = "refundable")
    private boolean refundable;
    @b(a = "refundable_text")
    private String refundableText;
    @b(a = "totalfare")
    private int totalfare;

    public int getTotalfare() {
        return this.totalfare;
    }

    public void setTotalfare(int i2) {
        this.totalfare = i2;
    }

    public String getProviderName() {
        return this.providerName;
    }

    public void setProviderName(String str) {
        this.providerName = str;
    }

    public boolean isRefundable() {
        return this.refundable;
    }

    public void setRefundable(boolean z) {
        this.refundable = z;
    }

    public String getRefundableText() {
        return this.refundableText;
    }

    public void setRefundableText(String str) {
        this.refundableText = str;
    }

    public String getDisplayPrice() {
        return this.displayPrice;
    }

    public void setDisplayPrice(String str) {
        this.displayPrice = str;
    }
}
