package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainCancellationResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "body")
    private CJRTrainCancellationResponseBody body;
    @b(a = "status")
    private CJRPNRStatus status;

    public CJRPNRStatus getStatus() {
        return this.status;
    }

    public CJRTrainCancellationResponseBody getBody() {
        return this.body;
    }
}
