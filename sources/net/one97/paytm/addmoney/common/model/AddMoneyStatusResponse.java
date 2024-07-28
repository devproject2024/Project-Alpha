package net.one97.paytm.addmoney.common.model;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;

public class AddMoneyStatusResponse extends IJRPaytmDataModel {
    Head head;
    @c(a = "body")
    AddMoneyStatusResponseBody mResponse;

    public AddMoneyStatusResponseBody getResponse() {
        return this.mResponse;
    }
}
