package com.travel.model;

import net.one97.paytm.common.entity.IJRDataModel;

public final class CalendarDatePriceInfo implements IJRDataModel {
    private String colorCode;
    private String date;
    private int fare;

    public final String getDate() {
        return this.date;
    }

    public final void setDate(String str) {
        this.date = str;
    }

    public final int getFare() {
        return this.fare;
    }

    public final void setFare(int i2) {
        this.fare = i2;
    }

    public final String getColorCode() {
        return this.colorCode;
    }

    public final void setColorCode(String str) {
        this.colorCode = str;
    }
}
