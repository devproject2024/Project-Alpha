package com.paytmmall.artifact.order.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJROrderSummaryAddress extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "address")
    private String mAddress;
    @b(a = "city")
    private String mCity;
    @b(a = "country")
    private String mCountry;
    @b(a = "customer_id")
    private String mCustomerId;
    @b(a = "firstname")
    private String mFirstName;
    @b(a = "pincode")
    private String mPinCode;
    @b(a = "state")
    private String mState;

    public String getFirstName() {
        return this.mFirstName;
    }

    public String getCustomerId() {
        return this.mCustomerId;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public String getState() {
        return this.mState;
    }

    public String getCountry() {
        return this.mCountry;
    }

    public String getPinCode() {
        return this.mPinCode;
    }

    public String getCity() {
        return this.mCity;
    }
}
