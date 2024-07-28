package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class PreAuthTxnHistory extends IJRDataModel {
    @a
    @b(a = "orderId")
    private Object orderId;
    @a
    @b(a = "requestGuid")
    private Object requestGuid;
    @a
    @b(a = "response")
    private Response response;
    @a
    @b(a = "status")
    private String status;
    @a
    @b(a = "statusCode")
    private String statusCode;
    @a
    @b(a = "statusMessage")
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

    public Response getResponse() {
        return this.response;
    }

    public void setResponse(Response response2) {
        this.response = response2;
    }
}
