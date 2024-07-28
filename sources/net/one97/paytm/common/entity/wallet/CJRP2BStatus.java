package net.one97.paytm.common.entity.wallet;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRP2BStatus extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "response")
    private CJRP2BStatusResponse mResponse;
    @b(a = "statusCode")
    private String mStatusCode;
    @b(a = "statusMessage")
    private String mStatusMessage;

    public String getStatusCode() {
        return this.mStatusCode;
    }

    public CJRP2BStatusResponse getResponse() {
        return this.mResponse;
    }

    public String getmStatusMessage() {
        return this.mStatusMessage;
    }

    public void setmStatusMessage(String str) {
        this.mStatusMessage = str;
    }
}
