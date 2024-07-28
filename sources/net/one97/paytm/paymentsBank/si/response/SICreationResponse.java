package net.one97.paytm.paymentsBank.si.response;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class SICreationResponse extends IJRPaytmDataModel {
    @b(a = "payload")
    private Payload payload;
    @b(a = "requestId")
    private String requestId;
    @b(a = "responseCode")
    private Integer responseCode;
    @b(a = "responseMessage")
    private String responseMessage;

    public String getRequestId() {
        return this.requestId;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

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

    public static class Payload extends IJRPaytmDataModel implements IJRDataModel {
        @b(a = "errorCode")
        private String errorCode;
        @b(a = "errorMessage")
        private String errorMessage;
        @b(a = "siId")
        private Integer siId;

        public String getErrorMessage() {
            return this.errorMessage;
        }

        public void setErrorMessage(String str) {
            this.errorMessage = str;
        }

        public String getErrorCode() {
            return this.errorCode;
        }

        public void setErrorCode(String str) {
            this.errorCode = str;
        }

        public Integer getSiId() {
            return this.siId;
        }

        public void setSiId(Integer num) {
            this.siId = num;
        }
    }
}
