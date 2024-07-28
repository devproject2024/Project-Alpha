package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRVerifyOTPMessage extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "message")
    private String mMessage;
    @b(a = "title")
    private String mTilte;

    public String getTilte() {
        return this.mTilte;
    }

    public String getMessage() {
        return this.mMessage;
    }
}
