package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainOrderSummaryResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "body")
    private CJRTrainOrderSummaryBody body;
    @b(a = "meta")
    private CJRTrainOrderSummaryMeta meta;
    @b(a = "status")
    private CJRTrainStatus status;

    public CJRTrainStatus getStatus() {
        return this.status;
    }

    public CJRTrainOrderSummaryBody getBody() {
        return this.body;
    }

    public CJRTrainOrderSummaryMeta getMeta() {
        return this.meta;
    }
}
