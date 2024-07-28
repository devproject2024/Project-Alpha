package com.travel.train.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTnCModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "promocode")
    private String promoCode;
    @b(a = "terms")
    private String terms;

    public String getTerms() {
        return this.terms;
    }

    public String getPromoCode() {
        return this.promoCode;
    }
}
