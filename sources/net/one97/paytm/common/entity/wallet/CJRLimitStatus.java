package net.one97.paytm.common.entity.wallet;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRLimitStatus extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "response")
    private CJRLimitStatusResponse mResponse;
    @b(a = "statusCode")
    private String mStatusCode;

    public String getStatusCode() {
        return this.mStatusCode;
    }

    public CJRLimitStatusResponse getResponse() {
        return this.mResponse;
    }
}
