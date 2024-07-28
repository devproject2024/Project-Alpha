package net.one97.paytm.paymentsBank.pdc.response;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class PDCCheckoutResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "payload")
    private Payload payload;
    @b(a = "requestId")
    private String requestId;
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
        @b(a = "amount")
        private double amount;
        @b(a = "documentation")
        private String documentation;
        @b(a = "errorCode")
        private String errorCode;
        @b(a = "errorMessage")
        private String errorMessage;
        @b(a = "orderDateAndTime")
        private String orderDateAndTime;
        @b(a = "orderId")
        private String orderId;
        @b(a = "reqMappingId")
        private String reqMappingId;

        public String getReqMappingId() {
            return this.reqMappingId;
        }

        public void setReqMappingId(String str) {
            this.reqMappingId = str;
        }

        public String getOrderDateAndTime() {
            return this.orderDateAndTime;
        }

        public void setOrderDateAndTime(String str) {
            this.orderDateAndTime = str;
        }

        public String getOrderId() {
            return this.orderId;
        }

        public void setOrderId(String str) {
            this.orderId = str;
        }

        public double getAmount() {
            return this.amount;
        }

        public void setAmount(double d2) {
            this.amount = d2;
        }

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
