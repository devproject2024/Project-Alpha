package com.business.merchant_payments.model.qrsummarymodel;

import com.business.merchant_payments.model.BaseModel;
import com.google.gson.a.a;
import com.google.gson.a.c;

public class EditQRResponse extends BaseModel {
    @c(a = "orderId")
    @a
    public String orderId;
    @c(a = "requestGuid")
    @a
    public String requestGuid;
    @c(a = "response")
    @a
    public QRResponse response;
    @c(a = "status")
    @a
    public String status;
    @c(a = "statusCode")
    @a
    public String statusCode;
    @c(a = "statusMessage")
    @a
    public String statusMessage;

    public String getRequestGuid() {
        return this.requestGuid;
    }

    public void setRequestGuid(String str) {
        this.requestGuid = str;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(String str) {
        this.statusCode = str;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public void setStatusMessage(String str) {
        this.statusMessage = str;
    }

    public QRResponse getResponse() {
        return this.response;
    }

    public void setResponse(QRResponse qRResponse) {
        this.response = qRResponse;
    }

    public class QRResponse {
        @c(a = "editResponse")
        @a
        public String editResponse;
        @c(a = "qrCodeId")
        @a
        public String qrCodeId;

        public QRResponse(EditQRResponse editQRResponse) {
        }

        public String getQrCodeId() {
            return this.qrCodeId;
        }

        public void setQrCodeId(String str) {
            this.qrCodeId = str;
        }

        public String getEditResponse() {
            return this.editResponse;
        }

        public void setEditResponse(String str) {
            this.editResponse = str;
        }
    }
}
