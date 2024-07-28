package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.Date;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainOfferCode extends IJRPaytmDataModel implements IJRDataModel {
    private boolean isOfferApplied;
    @b(a = "code")
    private String mCode;
    @b(a = "effective_price")
    private double mEffectivePrice;
    @b(a = "offerText")
    private String mOfferText;
    @b(a = "savings")
    private String mSavings;
    @b(a = "terms")
    private String mTerms;
    @b(a = "terms_title")
    private String mTermsTitle;
    @b(a = "valid_upto")
    private String mValidTill;
    private Date mValidUpTo;

    public boolean isOfferApplied() {
        return this.isOfferApplied;
    }

    public void setIsOfferApplied(boolean z) {
        this.isOfferApplied = z;
    }

    public String getCode() {
        return this.mCode;
    }

    public String getTermsTitle() {
        return this.mTermsTitle;
    }

    public String getOfferText() {
        return this.mOfferText;
    }

    public String getTerms() {
        return this.mTerms;
    }

    public Date getValidUpTo() {
        return this.mValidUpTo;
    }

    public double getEffectivePrice() {
        return this.mEffectivePrice;
    }

    public String getSavingsPrice() {
        return this.mSavings;
    }

    public String getmValidTill() {
        return this.mValidTill;
    }
}
