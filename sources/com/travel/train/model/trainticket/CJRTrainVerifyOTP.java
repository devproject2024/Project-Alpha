package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainVerifyOTP extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "status")
    private CJRVerifyOTPStatus VerifyOTPStatus;
    @b(a = "body")
    private CJRVerifyOTPDetails mOTPDetails;

    public CJRVerifyOTPStatus getVerifyOTPStatus() {
        return this.VerifyOTPStatus;
    }

    public CJRVerifyOTPDetails getOTPDetails() {
        return this.mOTPDetails;
    }
}
