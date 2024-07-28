package net.one97.paytm.contacts.entities.beans;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class ContactHealthResponse extends IJRPaytmDataModel implements IJRDataModel {
    private String code;
    private String message;
    private ContactResponse response;
    private String status;
    private boolean success;

    public String getCode() {
        return this.code;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public ContactResponse getResponse() {
        return this.response;
    }

    public void setResponse(ContactResponse contactResponse) {
        this.response = contactResponse;
    }

    public boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String toString() {
        return "ClassPojo [code = " + this.code + ", response = " + this.response + ", success = " + this.success + ", message = " + this.message + ", status = " + this.status + "]";
    }
}
