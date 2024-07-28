package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRCountryCodeList extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "body")
    private CJRCountryCodeBody mCountryBody;

    public CJRCountryCodeBody getCountryBody() {
        return this.mCountryBody;
    }
}
