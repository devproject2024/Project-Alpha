package net.one97.paytm.paymentsBank.si.response;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class SIPrevalidateResponse extends IJRPaytmDataModel {
    @b(a = "payload")
    private Payload payload;
    @b(a = "responseCode")
    private Integer responseCode;
    @b(a = "responseMessage")
    private String responseMessage;

    public String getResponseMessage() {
        return this.responseMessage;
    }

    public void setResponseMessage(String str) {
        this.responseMessage = str;
    }

    public Integer getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(Integer num) {
        this.responseCode = num;
    }

    public Payload getPayload() {
        return this.payload;
    }

    public void setPayload(Payload payload2) {
        this.payload = payload2;
    }

    public static class Payload extends IJRPaytmDataModel {
        @b(a = "siId")
        private Integer siId;

        public Integer getSiId() {
            return this.siId;
        }

        public void setSiId(Integer num) {
            this.siId = num;
        }
    }
}
