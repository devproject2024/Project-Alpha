package net.one97.paytm.paymentsBank.model.nach;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class NachConsentResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "message")
    private String message;
    @b(a = "responseCode")
    private String responseCode;
    @b(a = "status")
    private String status;

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(String str) {
        this.responseCode = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }
}
