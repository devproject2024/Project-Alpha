package com.travel.bus.pojo.busticket;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;

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

    public String getSmsText() {
        return this.smsText;
    }

    public ReferTermsConditionsBody getTermsConditions() {
        return this.termsConditions;
    }

    public String getReferralCode() {
        return this.referralCode;
    }

    public String getContentHeader() {
        return this.contentHeader;
    }

    public ReferralGetCodeContentBody getGetCodeContentBody() {
        return this.getCodeContentBody;
    }
}
