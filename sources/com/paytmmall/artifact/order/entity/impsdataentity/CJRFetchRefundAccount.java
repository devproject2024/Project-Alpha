package com.paytmmall.artifact.order.entity.impsdataentity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRFetchRefundAccount extends IJRPaytmDataModel {
    @b(a = "body")
    private CJRAccountBodyResponse body;
    @b(a = "resultInfo")
    private CJRResultInfo resultInfo;
    @b(a = "signature")
    private String signature;

    public CJRResultInfo getResultInfo() {
        return this.resultInfo;
    }

    public String getSignature() {
        return this.signature;
    }

    public void setSignature(String str) {
        this.signature = str;
    }

    public CJRAccountBodyResponse getBody() {
        return this.body;
    }
}
