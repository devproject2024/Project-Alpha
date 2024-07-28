package com.paytmmall.artifact.cart.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRShoppingCart extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "errorCode")
    private String errorCode;
    @b(a = "address")
    private CJRAddressList mAddress;
    @b(a = "cart")
    private CJRCart mCart;
    @b(a = "error")
    private String mError;
    @b(a = "status")
    private CJRCartStatus mStatus;
    @b(a = "code")
    private int mStatusCode;

    public String getmError() {
        return this.mError;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public CJRAddressList getAddress() {
        return this.mAddress;
    }

    public CJRCart getCart() {
        return this.mCart;
    }

    public CJRCartStatus getStatus() {
        return this.mStatus;
    }
}
