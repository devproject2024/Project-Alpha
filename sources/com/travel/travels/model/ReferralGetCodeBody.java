package com.travel.travels.model;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public class ReferralGetCodeBody extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @c(a = "content_header")
    private String contentHeader;
    @c(a = "content_body")
    private ReferralGetCodeContentBody getCodeContentBody;
    @c(a = "referral_code")
    private String referralCode;
    @c(a = "smsText")
    private String smsText;
    @c(a = "tc")
    private ReferTermsConditionsBody termsConditions;
    @c(a = "verticals")
    private List<String> verticals = null;

    public String getSmsText() {
        return this.smsText;
    }

    public void setSmsText(String str) {
        this.smsText = str;
    }

    public ReferTermsConditionsBody getTermsConditions() {
        return this.termsConditions;
    }

    public void setTermsConditions(ReferTermsConditionsBody referTermsConditionsBody) {
        this.termsConditions = referTermsConditionsBody;
    }

    public String getReferralCode() {
        return this.referralCode;
    }

    public void setReferralCode(String str) {
        this.referralCode = str;
    }

    public String getContentHeader() {
        return this.contentHeader;
    }

    public void setContentHeader(String str) {
        this.contentHeader = str;
    }

    public ReferralGetCodeContentBody getGetCodeContentBody() {
        return this.getCodeContentBody;
    }

    public void setGetCodeContentBody(ReferralGetCodeContentBody referralGetCodeContentBody) {
        this.getCodeContentBody = referralGetCodeContentBody;
    }

    public List<String> getVerticals() {
        return this.verticals;
    }

    public void setVerticals(List<String> list) {
        this.verticals = list;
    }
}
