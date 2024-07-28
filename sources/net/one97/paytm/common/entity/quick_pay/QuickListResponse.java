package net.one97.paytm.common.entity.quick_pay;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class QuickListResponse extends IJRPaytmDataModel implements IJRDataModel {
    private Payload payload;
    private String responseCode;
    private String responseMessage;

    public String getResponseMessage() {
        return this.responseMessage;
    }

    public void setResponseMessage(String str) {
        this.responseMessage = str;
    }

    public String getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(String str) {
        this.responseCode = str;
    }

    public Payload getPayload() {
        return this.payload;
    }

    public void setPayload(Payload payload2) {
        this.payload = payload2;
    }

    public String toString() {
        return "ClassPojo [responseMessage = " + this.responseMessage + ", responseCode = " + this.responseCode + ", payload = " + this.payload + "]";
    }
}
