package com.travel.flight.pojo;

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

    public void setmTitle(String str) {
        this.mTitle = str;
    }

    public String getmMessage() {
        return this.mMessage;
    }

    public void setmMessage(String str) {
        this.mMessage = str;
    }
}
