package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainMsgResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "body")
    private CJRTrainMsgResponseBody body;
    @b(a = "status")
    private CJRTrainStatus status;

    public CJRTrainMsgResponseBody getBody() {
        return this.body;
    }

    public CJRTrainStatus getStatus() {
        return this.status;
    }
}
