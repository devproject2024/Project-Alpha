package com.paytmmall.artifact.cart.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRAddresses extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "addressess")
    private CJRAddressList mAddress = new CJRAddressList();
    @b(a = "ERROR")
    private String mError;
    @b(a = "message")
    private String mMessage;
    @b(a = "responseCode")
    private String mResponseCode;
    @b(a = "status")
    private String mStatus;

    public CJRAddressList getAddress() {
        return this.mAddress;
    }

    public String getStatus() {
        return this.mStatus;
    }

    public String getResponseCode() {
        return this.mResponseCode;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public String getError() {
        return this.mError;
    }
}
