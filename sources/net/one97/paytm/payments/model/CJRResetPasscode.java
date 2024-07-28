package net.one97.paytm.payments.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRResetPasscode extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "message")
    private String mMessage;
    @b(a = "responseCode")
    private String mResponseCode;
    @b(a = "status")
    private String mStatus;

    public String getStatus() {
        return this.mStatus;
    }

    public String getResponseCode() {
        return this.mResponseCode;
    }

    public String getMessage() {
        return this.mMessage;
    }
}
