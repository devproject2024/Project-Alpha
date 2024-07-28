package net.one97.paytm.paymentsBank.si.response;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class SIDeActivateResponse extends IJRPaytmDataModel {
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
        @b(a = "documentation")
        private String documentation;
        @b(a = "errorCode")
        private String errorCode;
        @b(a = "errorMessage")
        private String errorMessage;

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

        public String getDocumentation() {
            return this.documentation;
        }

        public void setDocumentation(String str) {
            this.documentation = str;
        }
    }
}
