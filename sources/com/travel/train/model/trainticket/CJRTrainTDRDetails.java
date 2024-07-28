package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainTDRDetails extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "body")
    private CJRTrainTDRBody body;
    @b(a = "code")
    private String mCode;
    @b(a = "error")
    private String mError;
    @b(a = "status")
    private CJRTrainStatus status;

    public CJRTrainStatus getStatus() {
        return this.status;
    }

    public CJRTrainTDRBody getBody() {
        return this.body;
    }

    public String getmError() {
        return this.mError;
    }

    public String getmCode() {
        return this.mCode;
    }
}
