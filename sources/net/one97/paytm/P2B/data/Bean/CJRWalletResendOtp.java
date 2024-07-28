package net.one97.paytm.p2b.data.Bean;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRWalletResendOtp extends IJRPaytmDataModel {
    @b(a = "statusCode")
    private String mStatusCode;
    @b(a = "statusMessage")
    private String mStatusMessage;

    public String getStatusMessage() {
        return this.mStatusMessage;
    }

    public String getStatusCode() {
        return this.mStatusCode;
    }
}
