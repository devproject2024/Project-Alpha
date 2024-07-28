package net.one97.paytm.paymentsBank.pdc.response;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class PDCPrevalidateResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "payload")
    private Payload payload;
    @b(a = "requestId")
    private String requestId;
    @b(a = "responseCode")
    private int responseCode;
    @b(a = "responseMessage")
    private String responseMessage;

    public String getResponseMessage() {
        return this.responseMessage;
    }

    public void setResponseMessage(String str) {
        this.responseMessage = str;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(int i2) {
        this.responseCode = i2;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public Payload getPayload() {
        return this.payload;
    }

    public void setPayload(Payload payload2) {
        this.payload = payload2;
    }

    public static class Payload extends IJRPaytmDataModel implements IJRDataModel {
        @b(a = "message")
        private String message;
        @b(a = "reqMappingId")
        private String reqMappingId;

        public String getReqMappingId() {
            return this.reqMappingId;
        }

        public void setReqMappingId(String str) {
            this.reqMappingId = str;
        }

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String str) {
            this.message = str;
        }
    }
}
