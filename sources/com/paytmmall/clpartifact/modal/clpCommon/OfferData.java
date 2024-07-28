package com.paytmmall.clpartifact.modal.clpCommon;

import com.google.gson.a.c;
import com.paytmmall.clpartifact.modal.grid.CJROfferV1;
import java.io.Serializable;

public class OfferData implements Serializable {
    @c(a = "isFlashCode")
    private Boolean isFlashSale;
    @c(a = "cashback")
    private String mCashback;
    @c(a = "code")
    private String mCode;
    @c(a = "offer")
    private OfferDataModel mOffer;
    @c(a = "offerText")
    private String mOfferText;
    @c(a = "totalSavings")
    private String mTotalSavings;
    @c(a = "validFrom")
    private String mValidFrom;
    @c(a = "validUpto")
    private String mValidUpto;
    @c(a = "visibleFrom")
    private String mVisibleFrom;
    @c(a = "visibleUpto")
    private String mVisibleUpto;
    @c(a = "offer_v1")
    private CJROfferV1 offerV1;

    public Boolean getFlashSale() {
        return this.isFlashSale;
    }

    public void setFlashSale(Boolean bool) {
        this.isFlashSale = bool;
    }

    public CJROfferV1 getOfferV1() {
        return this.offerV1;
    }

    public void setOfferV1(CJROfferV1 cJROfferV1) {
        this.offerV1 = cJROfferV1;
    }

    public String getmTotalSavings() {
        return this.mTotalSavings;
    }

    public void setmTotalSavings(String str) {
        this.mTotalSavings = str;
    }

    public OfferDataModel getmOffer() {
        return this.mOffer;
    }

    public void setmOffer(OfferDataModel offerDataModel) {
        this.mOffer = offerDataModel;
    }

    public String getmCashback() {
        return this.mCashback;
    }

    public void setmCashback(String str) {
        this.mCashback = str;
    }

    public String getmOfferText() {
        return this.mOfferText;
    }

    public void setmOfferText(String str) {
        this.mOfferText = str;
    }

    public String getmValidUpto() {
        return this.mValidUpto;
    }

    public void setmValidUpto(String str) {
        this.mValidUpto = str;
    }

    public String getmVisibleFrom() {
        return this.mVisibleFrom;
    }

    public void setmVisibleFrom(String str) {
        this.mVisibleFrom = str;
    }

    public String getmValidFrom() {
        return this.mValidFrom;
    }

    public void setmValidFrom(String str) {
        this.mValidFrom = str;
    }

    public String getmVisibleUpto() {
        return this.mVisibleUpto;
    }

    public void setmVisibleUpto(String str) {
        this.mVisibleUpto = str;
    }

    public String getmCode() {
        return this.mCode;
    }

    public void setmCode(String str) {
        this.mCode = str;
    }
}
