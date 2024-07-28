package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainPNRStatus extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "code")
    private String mCode;
    @b(a = "error")
    private String mError;
    @b(a = "meta")
    private CJRPNRStatusMeta mMeta;
    @b(a = "body")
    private CJRPNRStatusDetails mPNRStatusDetails;
    @b(a = "status")
    private CJRPNRStatus mStatus;

    public String getmError() {
        return this.mError;
    }

    public CJRPNRStatus getmStatus() {
        return this.mStatus;
    }

    public CJRPNRStatusDetails getPNRStatusDetails() {
        return this.mPNRStatusDetails;
    }

    public CJRPNRStatusMeta getmMeta() {
        return this.mMeta;
    }

    public String getmCode() {
        return this.mCode;
    }
}
