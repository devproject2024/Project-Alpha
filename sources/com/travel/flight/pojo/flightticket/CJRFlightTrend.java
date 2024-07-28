package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFlightTrend implements IJRDataModel {
    @b(a = "days")
    private int days;

    public int getDays() {
        return this.days;
    }

    public void setDays(int i2) {
        this.days = i2;
    }
}
