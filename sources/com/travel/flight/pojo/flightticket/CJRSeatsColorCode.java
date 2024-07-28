package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRSeatsColorCode implements IJRDataModel {
    @b(a = "5")
    private String mFiveColorCode;
    @b(a = "3")
    private String mThreeColorCode;

    public String getThreeColorCode() {
        return this.mThreeColorCode;
    }

    public void setThreeColorCode(String str) {
        this.mThreeColorCode = str;
    }

    public String getFiveColorCode() {
        return this.mFiveColorCode;
    }

    public void setFiveColorCode(String str) {
        this.mFiveColorCode = str;
    }
}
