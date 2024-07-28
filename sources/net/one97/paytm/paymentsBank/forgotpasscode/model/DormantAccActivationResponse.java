package net.one97.paytm.paymentsBank.forgotpasscode.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class DormantAccActivationResponse extends IJRPaytmDataModel {
    @b(a = "response")
    private a response;
    @b(a = "status")
    private String status;
    @b(a = "success")
    private boolean success;

    public class a {
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }

    public a getResponse() {
        return this.response;
    }

    public void setResponse(a aVar) {
        this.response = aVar;
    }
}
