package com.paytmmall.artifact.order.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRLifafaOffer extends IJRPaytmDataModel {
    public static final String OFFER_FORMAT_NUMBER = "number";
    @b(a = "code")
    private String offerCode;
    @b(a = "description")
    private String offerDescription;
    @b(a = "format")
    private String offerFormat;
    @b(a = "image")
    private String offerImageUrl;
    @b(a = "state")
    private int offerState;
    @b(a = "value")
    private String offerValue;
    @b(a = "text1")
    private String txt1;
    @b(a = "text2")
    private String txt2;
    @b(a = "valid_from")
    private String validFromDate;
    @b(a = "valid_to")
    private String validToDate;

    public String getOfferCode() {
        return this.offerCode;
    }

    public boolean isOfferAvailable() {
        return this.offerState == 1;
    }

    public String getOfferValue() {
        return this.offerValue;
    }

    public String getOfferFormat() {
        return this.offerFormat;
    }

    public String getValidFromDate() {
        return this.validFromDate;
    }

    public String getValidToDate() {
        return this.validToDate;
    }

    public String getTxt1() {
        return this.txt1;
    }

    public String getTxt2() {
        return this.txt2;
    }

    public String getOfferDescription() {
        return this.offerDescription;
    }

    public String getOfferImageUrl() {
        return this.offerImageUrl;
    }
}
