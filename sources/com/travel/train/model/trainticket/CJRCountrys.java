package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRCountrys extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "country")
    private String mCountry;
    @b(a = "countryCode")
    private String mCountryCode;
    @b(a = "countryId")
    private String mCountryId;

    public String getCountry() {
        return this.mCountry;
    }

    public void setCountry(String str) {
        this.mCountry = str;
    }

    public String getCountryId() {
        return this.mCountryId;
    }

    public void setCountryId(String str) {
        this.mCountryId = str;
    }

    public String getCountryCode() {
        return this.mCountryCode;
    }
}
