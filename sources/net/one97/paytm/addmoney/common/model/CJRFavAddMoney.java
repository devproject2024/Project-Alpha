package net.one97.paytm.addmoney.common.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRFavAddMoney extends IJRPaytmDataModel {
    @b(a = "response")
    private CJRFavAddMoneyResponse mResponse;
    @b(a = "statusCode")
    private String mStatusCode;

    public String getStatusCode() {
        return this.mStatusCode;
    }

    public CJRFavAddMoneyResponse getResponse() {
        return this.mResponse;
    }
}
