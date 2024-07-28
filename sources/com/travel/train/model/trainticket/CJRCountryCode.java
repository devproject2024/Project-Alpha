package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRCountryCode implements IJRDataModel {
    @b(a = "Nationality code")
    private String mCountryCode;
    @b(a = "Nationality name")
    private String mCountryName;

    public String getCountryName() {
        return this.mCountryName;
    }

    public void setCountryName(String str) {
        this.mCountryName = str;
    }

    public String getCountryCode() {
        return this.mCountryCode;
    }

    public void setCountryCode(String str) {
        this.mCountryCode = str;
    }
}
