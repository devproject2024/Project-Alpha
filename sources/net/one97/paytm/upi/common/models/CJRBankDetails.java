package net.one97.paytm.upi.common.models;

import com.google.gson.a.c;
import net.one97.paytm.upi.common.UpiBaseDataModel;

public class CJRBankDetails implements UpiBaseDataModel {
    @c(a = "response")
    private CJRBankDetailsResponse mResponse;
    @c(a = "statusCode")
    private String mStatusCode;
    @c(a = "statusMessage")
    private String mStatusMessage;

    public String getStatusCode() {
        return this.mStatusCode;
    }

    public String getStatusMessage() {
        return this.mStatusMessage;
    }

    public CJRBankDetailsResponse getResponse() {
        return this.mResponse;
    }
}
