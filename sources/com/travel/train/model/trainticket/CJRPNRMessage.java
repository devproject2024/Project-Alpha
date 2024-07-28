package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRPNRMessage extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "message")
    private String mMessage;
    @b(a = "title")
    private String mTitle;

    public String getmTitle() {
        return this.mTitle;
    }

    public String getmMessage() {
        return this.mMessage;
    }
}
