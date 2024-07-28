package com.travel.flight.pojo;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRPNRStatus extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "message")
    private CJRPNRMessage mMessagePNR;
    @b(a = "result")
    private String mResult;

    public String getmResult() {
        return this.mResult;
    }

    public void setmResult(String str) {
        this.mResult = str;
    }

    public CJRPNRMessage getmMessagePNR() {
        return this.mMessagePNR;
    }

    public void setmMessagePNR(CJRPNRMessage cJRPNRMessage) {
        this.mMessagePNR = cJRPNRMessage;
    }
}
