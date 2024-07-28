package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRDiscountedStrip implements IJRDataModel {
    @b(a = "airline")
    private String mAirline;
    @b(a = "airlineCode")
    private String mAirlineCode;
    @b(a = "combined_flightid")
    private String mCombinedFlightId;
    @b(a = "display_price")
    private String mDisplayPrice;
    @b(a = "price")
    private String mPrice;

    public void setPrice(String str) {
        this.mPrice = str;
    }

    public String getPrice() {
        return this.mPrice;
    }

    public void setDisplayPrice(String str) {
        this.mDisplayPrice = str;
    }

    public String getDisplayPrice() {
        return this.mDisplayPrice;
    }

    public void setAirline(String str) {
        this.mAirline = str;
    }

    public String getAirline() {
        return this.mAirline;
    }

    public void setAirlineCode(String str) {
        this.mAirlineCode = str;
    }

    public String getAirlineCode() {
        return this.mAirlineCode;
    }

    public void setCombinedFlightId(String str) {
        this.mCombinedFlightId = str;
    }

    public String getCombinedFlightId() {
        return this.mCombinedFlightId;
    }
}
