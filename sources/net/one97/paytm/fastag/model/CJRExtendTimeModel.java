package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRExtendTimeModel extends IJRPaytmDataModel {
    @b(a = "message")
    private String mMessage;
    @b(a = "status")
    private String mStatus;
    @b(a = "statusCode")
    private String mStatusCode;

    public String getmStatus() {
        return this.mStatus;
    }

    public String getmMessage() {
        return this.mMessage;
    }
}
