package net.one97.paytm.paymentsBank.form15g.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.io.Serializable;
import net.one97.paytm.common.entity.IJRDataModel;

public class Form15ghModel extends IJRPaytmDataModel implements Serializable, IJRDataModel {
    @b(a = "message")
    String message;
    @b(a = "response")
    Form15ghResponceModel response;
    @b(a = "responseCode")
    String responseCode;
    @b(a = "status")
    String status;
    @b(a = "success")
    boolean success;

    public String getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(String str) {
        this.responseCode = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }

    public Form15ghResponceModel getResponse() {
        return this.response;
    }

    public void setResponse(Form15ghResponceModel form15ghResponceModel) {
        this.response = form15ghResponceModel;
    }
}
