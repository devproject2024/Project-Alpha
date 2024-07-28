package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBankDetails extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "response")
    private CJRBankDetailsResponse mResponse;
    @b(a = "statusCode")
    private String mStatusCode;
    @b(a = "statusMessage")
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
