package com.paytmmall.artifact.cart.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRReverseItemInfo extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "exchangeSubtitle")
    private String exchangeSubtitle;
    @b(a = "exchangeText")
    private String exchangeText;
    @b(a = "exchangeTitle")
    private String exchangeTitle;
    @b(a = "status")
    private String status;

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getExchangeTitle() {
        return this.exchangeTitle;
    }

    public void setExchangeTitle(String str) {
        this.exchangeTitle = str;
    }

    public String getExchangeText() {
        return this.exchangeText;
    }

    public void setExchangeText(String str) {
        this.exchangeText = str;
    }

    public String getExchangeSubtitle() {
        return this.exchangeSubtitle;
    }

    public void setExchangeSubtitle(String str) {
        this.exchangeSubtitle = str;
    }
}
