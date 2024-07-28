package com.paytmmall.artifact.order.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJROrdersummaryReferral extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "offerUrl")
    private String mOfferUrl;
    @b(a = "title")
    private String mTitle;
    @b(a = "uiControl")
    private String mUiControl;
    @b(a = "url")
    private String mUrl;

    public String getUrl() {
        return this.mUrl;
    }

    public String getOfferUrl() {
        return this.mOfferUrl;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getUiControl() {
        return this.mUiControl;
    }
}
