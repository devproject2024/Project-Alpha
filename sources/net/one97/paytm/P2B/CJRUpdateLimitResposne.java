package net.one97.paytm.P2B;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRUpdateLimitResposne extends IJRPaytmDataModel {
    @b(a = "otpState")
    public String otpState;
    @b(a = "statusCode")
    public String statusCode;
    @b(a = "statusMessage")
    public String statusMessage;

    public String getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(String str) {
        this.statusCode = str;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public void setStatusMessage(String str) {
        this.statusMessage = str;
    }

    public String getOtpState() {
        return this.otpState;
    }

    public void setOtpState(String str) {
        this.otpState = str;
    }
}
