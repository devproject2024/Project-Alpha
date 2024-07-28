package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.CJRStatusError;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainDetails extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "error")
    private String mError;
    @b(a = "status")
    private CJRStatusError mStatus;
    @b(a = "body")
    private CJRTrainDetailsBody mTrainDetailsBody;

    public String getmError() {
        return this.mError;
    }

    public CJRStatusError getmStatus() {
        return this.mStatus;
    }

    public CJRTrainDetailsBody getmTrainDetailsBody() {
        return this.mTrainDetailsBody;
    }
}
