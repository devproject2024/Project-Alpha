package net.one97.paytm.wallet.newdesign.models;

import com.google.gson.a.a;
import com.google.gson.a.c;
import net.one97.paytm.network.CJRWalletDataModel;

public class UpdateRecentPaymentsAPIResponse extends CJRWalletDataModel {
    @c(a = "orderId")
    @a
    private Object orderId;
    @c(a = "requestGuid")
    @a
    private Object requestGuid;
    @c(a = "response")
    @a
    private Object response;
    @c(a = "status")
    @a
    private String status;
    @c(a = "statusCode")
    @a
    private String statusCode;
    @c(a = "statusMessage")
    @a
    private String statusMessage;

    public Object getRequestGuid() {
        return this.requestGuid;
    }

    public void setRequestGuid(Object obj) {
        this.requestGuid = obj;
    }

    public Object getOrderId() {
        return this.orderId;
    }

    public void setOrderId(Object obj) {
        this.orderId = obj;
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

    public Object getResponse() {
        return this.response;
    }

    public void setResponse(Object obj) {
        this.response = obj;
    }
}
