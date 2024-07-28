package com.travel.travels.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class ReferTermsConditionsBody extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "terms")
    private String termsMessage;
    @b(a = "terms_title")
    private String termsTitle;

    public String getTermsMessage() {
        return this.termsMessage;
    }

    public void setTermsMessage(String str) {
        this.termsMessage = str;
    }

    public String getTermsTitle() {
        return this.termsTitle;
    }

    public void setTermsTitle(String str) {
        this.termsTitle = str;
    }
}
