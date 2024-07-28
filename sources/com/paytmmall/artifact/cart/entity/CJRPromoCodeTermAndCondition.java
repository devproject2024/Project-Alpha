package com.paytmmall.artifact.cart.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRPromoCodeTermAndCondition extends IJRPaytmDataModel {
    @b(a = "promocode")
    private String promocode;
    @b(a = "siteId")
    private int site_id;
    @b(a = "terms")
    private String terms;
    @b(a = "termsTitle")
    private String terms_title;

    public String getTerms() {
        return this.terms;
    }

    public String getPromocode() {
        return this.promocode;
    }

    public int getSiteId() {
        return this.site_id;
    }

    public String getTermsTitle() {
        return this.terms_title;
    }
}
