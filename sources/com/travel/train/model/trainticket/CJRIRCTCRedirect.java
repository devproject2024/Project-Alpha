package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRIRCTCRedirect implements IJRDataModel {
    private static final long serialVersionUID = 1;
    private String mirctcuserid;
    @b(a = "url")
    private String murl;
    @b(a = "wsReturnUrl")
    private String mwsReturnUrl;
    @b(a = "wsTxnId")
    private String mwsTxnId;

    public String getMurl() {
        return this.murl;
    }

    public String getMwsTxnId() {
        return this.mwsTxnId;
    }

    public String getMwsReturnUrl() {
        return this.mwsReturnUrl;
    }

    public String getMirctcuserid() {
        return this.mirctcuserid;
    }
}
