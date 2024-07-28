package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRVerifyOTPStatus extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "result")
    private String mResult;
    @b(a = "message")
    private CJRVerifyOTPMessage mVerifyOTPMessage;

    public String getResult() {
        return this.mResult;
    }

    public CJRVerifyOTPMessage getResendOTPMessage() {
        return this.mVerifyOTPMessage;
    }
}
