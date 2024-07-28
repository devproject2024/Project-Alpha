package net.one97.paytm.wallet.newdesign.addmoney.model;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.addmoney.common.paymethodresponse.Head;

public class CJRBinResponse extends IJRPaytmDataModel {
    @c(a = "body")
    CJRBinResponseBody body;
    @c(a = "head")
    Head head;

    public Head getHead() {
        return this.head;
    }

    public CJRBinResponseBody getBody() {
        return this.body;
    }
}
