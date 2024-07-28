package net.one97.paytm.paymentsBank.form15g.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.io.Serializable;
import net.one97.paytm.common.entity.IJRDataModel;

public class SubmitForm15ghModel extends IJRPaytmDataModel implements Serializable, IJRDataModel {
    @b(a = "ackNumber")
    String ackNumber;
    @b(a = "message")
    String message;
    @b(a = "response")
    SubmitForm15ghResponceModel response;
    @b(a = "status")
    String status;
    @b(a = "success")
    boolean success;

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }

    public SubmitForm15ghResponceModel getResponse() {
        return this.response;
    }

    public void setResponse(SubmitForm15ghResponceModel submitForm15ghResponceModel) {
        this.response = submitForm15ghResponceModel;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getAckNumber() {
        return this.ackNumber;
    }

    public void setAckNumber(String str) {
        this.ackNumber = str;
    }
}
