package com.travel.flight.pojo.flightticket;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFlightDatePriceInfo implements IJRDataModel {
    private String colorCode;
    private String date;
    private int fare;

    public String getDate() {
        return this.date;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public int getFare() {
        return this.fare;
    }

    public void setFare(int i2) {
        this.fare = i2;
    }

    public String getColorCode() {
        return this.colorCode;
    }

    public void setColorCode(String str) {
        this.colorCode = str;
    }
}
