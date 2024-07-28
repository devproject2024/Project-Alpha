package net.one97.paytm.P2B;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRP2bCheckTxnStatus extends IJRPaytmDataModel {
    @b(a = "orderId")
    String orderId;
    @b(a = "response")
    CJRP2bCheckTxnResponse response;
    @b(a = "status")
    String status;
    @b(a = "statusCode")
    String statusCode;
    @b(a = "statusMessage")
    String statusMessage;

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

    public CJRP2bCheckTxnResponse getResponse() {
        return this.response;
    }

    public void setResponse(CJRP2bCheckTxnResponse cJRP2bCheckTxnResponse) {
        this.response = cJRP2bCheckTxnResponse;
    }
}
