package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class ReferTermsConditionsBody extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "terms")
    private String termsMessage;

    public String getTermsMessage() {
        return this.termsMessage;
    }
}
