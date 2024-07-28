package net.one97.paytm.common.entity.impsdatamodel;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFetchRefundAccount extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "body")
    private CJRAccountBodyResponse body;
    @b(a = "signature")
    private String signature;

    public String getSignature() {
        return this.signature;
    }

    public void setSignature(String str) {
        this.signature = str;
    }

    public CJRAccountBodyResponse getBody() {
        return this.body;
    }
}
