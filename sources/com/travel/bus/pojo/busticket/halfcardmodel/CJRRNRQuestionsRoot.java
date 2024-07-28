package com.travel.bus.pojo.busticket.halfcardmodel;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRRNRQuestionsRoot extends IJRPaytmDataModel {
    @b(a = "body")
    private CJRRNRRootBody body;

    public CJRRNRRootBody getBody() {
        return this.body;
    }
}
