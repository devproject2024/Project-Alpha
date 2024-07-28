package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRCountryList extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "body")
    private CJRCountryBody mCountryBody;

    public CJRCountryBody getCountryBody() {
        return this.mCountryBody;
    }
}
