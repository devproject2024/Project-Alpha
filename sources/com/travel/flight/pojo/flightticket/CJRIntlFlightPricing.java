package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRIntlFlightPricing implements IJRDataModel {
    @b(a = "display_price")
    private String mDisplayPrice;
    @b(a = "onward_price")
    private int onwardPrice;
    @b(a = "onward_pricing")
    private CJRFlightPriceMapFlight onwardPricing;
    @b(a = "provider")
    private String provider;
    @b(a = "refundable")
    private boolean refundable;
    @b(a = "refundable_text")
    private String refundable_text;
    @b(a = "return_price")
    private int returnPrice;
    @b(a = "return_pricing")
    private CJRFlightPriceMapFlight returnPricing;
    @b(a = "totalfare")
    private String totalfare;

    public boolean getRefundable() {
        return this.refundable;
    }

    public void setRefundable(boolean z) {
        this.refundable = z;
    }

    public String getRefundable_text() {
        return this.refundable_text;
    }

    public void setRefundable_text(String str) {
        this.refundable_text = str;
    }

    public String getTotalfare() {
        return this.totalfare;
    }

    public void setTotalfare(String str) {
        this.totalfare = str;
    }

    public String getProvider() {
        return this.provider;
    }

    public void setProvider(String str) {
        this.provider = str;
    }

    public String getmDisplayPrice() {
        return this.mDisplayPrice;
    }

    public void setmDisplayPrice(String str) {
        this.mDisplayPrice = str;
    }

    public boolean isRefundable() {
        return this.refundable;
    }

    public int getOnwardPrice() {
        return this.onwardPrice;
    }

    public void setOnwardPrice(int i2) {
        this.onwardPrice = i2;
    }

    public int getReturnPrice() {
        return this.returnPrice;
    }

    public void setReturnPrice(int i2) {
        this.returnPrice = i2;
    }

    public CJRFlightPriceMapFlight getReturnPricing() {
        return this.returnPricing;
    }

    public void setReturnPricing(CJRFlightPriceMapFlight cJRFlightPriceMapFlight) {
        this.returnPricing = cJRFlightPriceMapFlight;
    }

    public CJRFlightPriceMapFlight getOnwardPricing() {
        return this.onwardPricing;
    }

    public void setOnwardPricing(CJRFlightPriceMapFlight cJRFlightPriceMapFlight) {
        this.onwardPricing = cJRFlightPriceMapFlight;
    }
}
