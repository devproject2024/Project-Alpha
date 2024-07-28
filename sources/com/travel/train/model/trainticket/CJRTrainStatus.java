package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainStatus extends IJRPaytmDataModel implements IJRDataModel {
    @a
    @b(a = "message")
    private CJRTrainMessage CJRTrainMessage;
    @a
    @b(a = "result")
    private String result;

    public String getResult() {
        return this.result;
    }

    public CJRTrainMessage getCJRTrainMessage() {
        return this.CJRTrainMessage;
    }
}
