package com.paytmmall.artifact.cart.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytmmall.artifact.common.entity.CJRError;

public class CJRCartStatus extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "code")
    private String mCode;
    @b(a = "message")
    private CJRError mMessage;
    @b(a = "result")
    private String mResult;

    public String getResult() {
        return this.mResult;
    }

    public CJRError getMessage() {
        return this.mMessage;
    }

    public String getCode() {
        return this.mCode;
    }
}
