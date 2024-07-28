package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainTicketStatusGuide extends IJRPaytmDataModel implements IJRDataModel {
    @a
    @b(a = "body")
    private CJRTrainTicketStatusGuideBody body;
    @a
    @b(a = "status")
    private CJRTrainStatus status;

    public CJRTrainStatus getStatus() {
        return this.status;
    }

    public CJRTrainTicketStatusGuideBody getBody() {
        return this.body;
    }
}
