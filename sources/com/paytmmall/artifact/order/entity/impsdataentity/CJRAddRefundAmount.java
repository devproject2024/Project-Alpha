package com.paytmmall.artifact.order.entity.impsdataentity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRAddRefundAmount extends IJRPaytmDataModel {
    @b(a = "body")
    private CJRAccountBodyResponse body;

    public CJRAccountBodyResponse getBody() {
        return this.body;
    }

    public void setBody(CJRAccountBodyResponse cJRAccountBodyResponse) {
        this.body = cJRAccountBodyResponse;
    }
}
